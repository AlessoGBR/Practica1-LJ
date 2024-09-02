/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1lj.Backend;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alesso
 */
public class GestorSimbolos {

    private final Map<String, Color> operadoresColores;

    public GestorSimbolos() {
        operadoresColores = new HashMap<>();
        inicializarOperadoresColores();
    }

    private void inicializarOperadoresColores() {
        // Operadores aritméticos
        operadoresColores.put("+", new Color(0xFF33FF));
        operadoresColores.put("-", new Color(0xC19A6B));
        operadoresColores.put("*", new Color(0xD80073));
        operadoresColores.put("/", new Color(0xB4D941));
        operadoresColores.put("Mod", new Color(0xD9AB41));
        operadoresColores.put("^", new Color(0xFCD0B4));

        // Operadores de comparación
        operadoresColores.put("==", new Color(0x6A00FF));
        operadoresColores.put("<>", new Color(0x3F2212));
        operadoresColores.put(">", new Color(0xD9D441));
        operadoresColores.put("<", new Color(0xD94A41));
        operadoresColores.put(">=", new Color(0xE3C800));
        operadoresColores.put("<=", new Color(0xF0A30A));

        // Operadores lógicos
        operadoresColores.put("And", new Color(0x414ED9));
        operadoresColores.put("Or", new Color(0x41D95D));
        operadoresColores.put("Not", new Color(0xA741D9));

        // Asignacion
        operadoresColores.put("=", new Color(0x41D9D4));
        operadoresColores.put("+=", Color.WHITE);
        operadoresColores.put("-=", Color.WHITE);
        operadoresColores.put("*=", Color.WHITE);
        operadoresColores.put("/=", Color.WHITE);
        
        // Tipo de datos
        operadoresColores.put("ENTERO", new Color(0x1BA1E2));
        operadoresColores.put("DECIMAL", new Color(0xFFFF88));
        operadoresColores.put("CADENA", new Color(0xE51400));
        operadoresColores.put("BOOLEANO", new Color(0xFA6800));
        operadoresColores.put("CARACTER", new Color(0x0050EF));
        
        // Comentario
        operadoresColores.put("''", new Color(0xB3B3B3));
        
        // Simbolos 
        operadoresColores.put("()", new Color(0x9AD8DB));
        operadoresColores.put("{}", new Color(0xDBD29A));
        operadoresColores.put("[]", new Color(0xDBA49A));
        operadoresColores.put(".", new Color(0x9ADBA6));
        operadoresColores.put(",", new Color(0xB79ADB));
    }

    // Método que devuelve el mapa de operadores y colores
    public Map<String, Color> getOperadoresColores() {
        return operadoresColores;
    }

    public Color getColorParaSimbolo(String simbolo) {
        return operadoresColores.getOrDefault(simbolo, Color.BLUE); // Color por defecto
    }

}
