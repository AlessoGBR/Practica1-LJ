/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1lj.Backend;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author alesso
 */
public class GraphvizController {

    private final Token token;
    private String pathImagen;

    public GraphvizController(Token token, String ruta) {
        this.token = token;
        this.pathImagen = ruta;
    }

    public String getTknDOT() {
        // Desglosamos el símbolo del token leido preparándolo para agregarlo al archivo .dot
        char[] tknSymbs = this.token.getToken().toCharArray();
        StringBuilder tknToGraph = new StringBuilder();

        // Creamos los nodos y las transiciones entre ellos
        for (int i = 0; i < tknSymbs.length; i++) {
            // Definir el nodo y su conexión con el siguiente
            tknToGraph.append("S").append(i).append(" -> S").append(i + 1)
                    .append(" [label=\"").append(tknSymbs[i]).append("\"];\n");
        }

        return tknToGraph.toString();
    }

    private String getTknGraph() {
        // Creamos el archivo .dot para la creación de los gráficos
        StringBuilder txt = new StringBuilder("digraph G {\n")
                .append("    node [style=filled, fillcolor=\"#FFFFFF\", color=\"#a0522d\"];\n")
                .append("    edge [color=\"#000000\"];\n")
                .append("    rankdir=LR;\n");

        // Agregamos los tokens al archivo .dot
        txt.append(getTknDOT()).append("}");

        return txt.toString();
    }

// Método para dibujar el gráfico utilizando Graphviz
    public void drawGraph() {
        try {

            // Definir las rutas para el archivo .dot y el archivo de imagen .png
            String rutaDot = pathImagen + "tkn_grph.dot";
            String rutaPng = pathImagen + " " + token.getToken() + ".png";

            // Crear archivo .dot con la representación del token
            dotFileMaker(getTknGraph(), rutaDot);

            // Crear el proceso para ejecutar Graphviz en Ubuntu
            ProcessBuilder processBuilder = new ProcessBuilder("dot", "-Tpng", "-o", rutaPng, rutaDot);
            Process process = processBuilder.start();

            // Capturar salida de error del proceso
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuilder errorMessage = new StringBuilder();
            String line;
            while ((line = errorReader.readLine()) != null) {
                errorMessage.append(line).append(System.lineSeparator());
            }

            int exitCode = process.waitFor();

            // Verificar si el gráfico se generó correctamente
            if (exitCode == 0) {
                pathImagen = rutaPng;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(System.err);
        }
    }

    private void dotFileMaker(String contenido, String ruta) {
        // Guardar el archivo .dot en la ruta especificada
        try (FileWriter fileWriter = new FileWriter(ruta); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.write(contenido);
        } catch (IOException e) {
            System.err.println("Error al crear el archivo .dot: " + e.getMessage());
        }
    }

    public String getPathImagen() {
        return pathImagen;
    }

}
