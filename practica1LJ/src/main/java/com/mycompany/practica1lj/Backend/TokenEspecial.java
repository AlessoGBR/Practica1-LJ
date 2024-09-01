/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1lj.Backend;

import java.awt.Color;

/**
 *
 * @author alesso
 */
public class TokenEspecial {

    private final String lexema;
    private final Color color;
    private int fila;
    private int columna;
    private String tipo;

    public TokenEspecial(String token, Color color, int fila, int columna) {
        this.lexema = token;
        this.color = color;
        this.fila = fila;
        this.columna = columna;
    }

    public String getToken() {
        return lexema;
    }

    public Color getColor() {
        return color;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
