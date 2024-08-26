/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1lj.Backend;

/**
 *
 * @author González Bravo
 */
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class AnalizadorOperadores {

    private Map<String, Color> operadores;

    public AnalizadorOperadores() {
        operadores = new HashMap<>();
        operadores.put("+", Color.decode("#FF33FF"));
        operadores.put("-", Color.decode("#C19A6B"));
        operadores.put("^", Color.decode("#FCD0B4"));
        operadores.put("/", Color.decode("#B4D941"));
        operadores.put("Mod", Color.decode("#D9AB41"));
        operadores.put("*", Color.decode("#D80073"));
    }

    public void analizarCodigo(String code, StyledDocument doc) {
        String[] tokens = code.split("\\s+|(?=[+\\-^/*])|(?<=[+\\-^/*])");
        for (String token : tokens) {
            Style style = doc.getStyle("Color");
            if (style == null) {
                style = doc.addStyle("Color", null);
            }
            StyleConstants.setForeground(style, operadores.getOrDefault(token, Color.BLACK));
            try {
                doc.insertString(doc.getLength(), token + " ", style);
            } catch (BadLocationException e) {
                System.out.println("error");
            }
        }
    }
}
