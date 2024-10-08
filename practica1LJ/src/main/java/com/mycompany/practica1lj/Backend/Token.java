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
public class Token {

    private final String lexema;
    private final Color color;
    private int fila;
    private int columna;
    private final TipoSimbolo tipo; // Tipo de símbolo

    public enum TipoSimbolo {
        OPERADOR, COMPARACION, IDENTIFICADOR, LOGICO, ASIGNACION, RESERVADAS, DATOS, ENTERO, DECIMAL, BOOLEANO, CADENA, CARACTER, SIGNOS, OTRO
    }

    public Token(String token, Color color, int fila, int columna, TipoSimbolo tipo) {
        this.lexema = token;
        this.color = color;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
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

    public TipoSimbolo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format("Token: %s, Color: %s, Fila: %d, Columna: %d", lexema, color.toString(), fila, columna);
    }

}
