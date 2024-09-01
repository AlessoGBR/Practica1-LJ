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

        // Reservadas 
        /*
        operadoresColores.put("Module", new Color(0x60A917));
        operadoresColores.put("End", new Color(0x60A917));
        operadoresColores.put("Sub", new Color(0x60A917));
        operadoresColores.put("Main", new Color(0x60A917));
        operadoresColores.put("Dim", new Color(0x60A917));
        operadoresColores.put("As", new Color(0x60A917));
        operadoresColores.put("Integer", new Color(0x60A917));
        operadoresColores.put("String", new Color(0x60A917));
        operadoresColores.put("Boolean", new Color(0x60A917));
        operadoresColores.put("Double", new Color(0x60A917));
        operadoresColores.put("Char", new Color(0x60A917));
        operadoresColores.put("Console.WriteLine", new Color(0x60A917));
        operadoresColores.put("Console.ReadLine", new Color(0x60A917));
        operadoresColores.put("If", new Color(0x60A917));
        operadoresColores.put("ElseIf", new Color(0x60A917));
        operadoresColores.put("Else", new Color(0x60A917));
        operadoresColores.put("Then", new Color(0x60A917));
        operadoresColores.put("While", new Color(0x60A917));
        operadoresColores.put("Do", new Color(0x60A917));
        operadoresColores.put("Loop", new Color(0x60A917));
        operadoresColores.put("For", new Color(0x60A917));
        operadoresColores.put("To", new Color(0x60A917));
        operadoresColores.put("Next", new Color(0x60A917));
        operadoresColores.put("Function", new Color(0x60A917));
        operadoresColores.put("Return", new Color(0x60A917));
        operadoresColores.put("Const", new Color(0x60A917));
         */
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
