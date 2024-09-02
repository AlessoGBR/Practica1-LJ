/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1lj.Backend;

/**
 *
 * @author alesso
 */
import java.awt.Color;
import java.util.List;
import java.util.Map;

public class AnalizadorCodigo {

    private final Map<String, Color> operadoresColores;
    private int fila = 1;
    private int columna = 1;
    private final GestorSimbolos gestorSimbolos;

    public AnalizadorCodigo(Map<String, Color> operadoresColores) {
        this.operadoresColores = operadoresColores;
        GestorSimbolos gesgestorSimbolos = new GestorSimbolos();
        this.gestorSimbolos = gesgestorSimbolos;
    }

    public void analizarCodigo(String code, List<Token> listaTokens, List<String> errores) {
        StringBuilder tokenActual = new StringBuilder();
        fila = 1;
        columna = 1;
        int i = 0;
        char[] caracteres = code.toCharArray();

        while (i < caracteres.length) {
            char simbolo = caracteres[i];

            if (simbolo == '\n') {
                fila++;
                columna = 1;
                i++;
                continue;
            }

            if (Character.isWhitespace(simbolo)) {
                if (tokenActual.length() > 0) {
                    procesarToken(tokenActual.toString(), listaTokens, errores, fila, columna - tokenActual.length());
                    tokenActual.setLength(0);
                }
                columna++;
                i++;
                continue;
            }

            // Verificar si es una cadena de texto
            if (simbolo == '"') {
                tokenActual.append(simbolo);
                i++;
                columna++;
                while (i < caracteres.length && caracteres[i] != '"') {
                    tokenActual.append(caracteres[i]);
                    i++;
                    columna++;
                }
                if (i < caracteres.length && caracteres[i] == '"') {
                    tokenActual.append(caracteres[i]);
                    i++;
                    columna++;
                }
                String tokenStr = tokenActual.toString();
                if (esCadenaTexto(tokenStr)) {
                    Token.TipoSimbolo tipo = Token.TipoSimbolo.CADENA;
                    Color color = obtenerColorParaCadena(tipo, tokenStr);
                    listaTokens.add(new Token(tokenStr, color, fila, columna - tokenStr.length(), tipo));
                }
                tokenActual.setLength(0);
                continue;
            }

            // Verificar si es un carácter
            if (simbolo == '\'') {
                tokenActual.append(simbolo);
                i++;
                columna++;
                if (i < caracteres.length) {
                    tokenActual.append(caracteres[i]);
                    i++;
                    columna++;
                }
                if (i < caracteres.length && caracteres[i] == '\'') {
                    tokenActual.append(caracteres[i]);
                    i++;
                    columna++;
                }
                String tokenStr = tokenActual.toString();
                if (esCaracter(tokenStr)) {
                    Token.TipoSimbolo tipo = Token.TipoSimbolo.CARACTER;
                    Color color = obtenerColorParaCaracter(tipo, tokenStr);
                    listaTokens.add(new Token(tokenStr, color, fila, columna - tokenStr.length(), tipo));
                }
                tokenActual.setLength(0);
                continue;
            }

            // Verificar si es un identificador (comienza con una letra)
            if (Character.isLetter(simbolo)) {
                tokenActual.append(simbolo);
                i++;
                columna++;
                while (i < caracteres.length && (Character.isLetterOrDigit(caracteres[i]) || caracteres[i] == '_')) {
                    tokenActual.append(caracteres[i]);
                    i++;
                    columna++;
                }

                String tokenStr = tokenActual.toString();
                // Verificar si el identificador es una palabra reservada
                if (esPalabraReservada(tokenStr)) {
                    Token.TipoSimbolo tipo = Token.TipoSimbolo.RESERVADAS;
                    Color color = obtenerColorParaTipoSimbolo(tipo, tokenStr);
                    listaTokens.add(new Token(tokenStr, color, fila, columna - tokenStr.length(), tipo));
                } else if (esIdentificadorValido(tokenStr)) {
                    Token.TipoSimbolo tipo = Token.TipoSimbolo.IDENTIFICADOR;
                    Color colorIdentificador = new Color(0xFFD300); // Color amarillo para identificadores
                    listaTokens.add(new Token(tokenStr, colorIdentificador, fila, columna - tokenStr.length(), tipo));
                }
                tokenActual.setLength(0);
                continue;
            }

            // Verificar si es un número entero o decimal
            if (Character.isDigit(simbolo)) {
                tokenActual.append(simbolo);
                i++;
                columna++;
                boolean esDecimal = false;
                while (i < caracteres.length && (Character.isDigit(caracteres[i]) || caracteres[i] == '.')) {
                    if (caracteres[i] == '.') {
                        esDecimal = true;
                    }
                    tokenActual.append(caracteres[i]);
                    i++;
                    columna++;
                }

                String tokenStr = tokenActual.toString();
                Token.TipoSimbolo tipo = esNumeroDecimal(tokenStr) ? Token.TipoSimbolo.DECIMAL : (esNumeroEntero(tokenStr) ? Token.TipoSimbolo.ENTERO : null);
                if (tipo != null) {
                    if (esDecimal) {
                        Color color = obtenerColorParaNumeroDecimal(tipo, tokenStr);
                        listaTokens.add(new Token(tokenStr, color, fila, columna - tokenStr.length(), tipo));
                    } else {
                        Color color = obtenerColorParaNumero(tipo, tokenStr);
                        listaTokens.add(new Token(tokenStr, color, fila, columna - tokenStr.length(), tipo));
                    }
                }
                tokenActual.setLength(0);
                continue;
            }

            // Verificar si es un operador o símbolo
            tokenActual.append(simbolo);

            if (i + 1 < caracteres.length) {
                char siguienteSimbolo = caracteres[i + 1];
                String posibleToken = tokenActual.toString() + siguienteSimbolo;

                if (obtenerTipoSimbolo(posibleToken) != null) {
                    Color color = obtenerColorParaTipoSimbolo(obtenerTipoSimbolo(posibleToken), posibleToken);
                    listaTokens.add(new Token(posibleToken, color, fila, columna, obtenerTipoSimbolo(posibleToken)));
                    tokenActual.setLength(0);
                    i += 2;
                    columna += 2;
                    continue;
                }
            }

            String tokenStr = tokenActual.toString();
            Token.TipoSimbolo tipo = obtenerTipoSimbolo(tokenStr);
            if (tipo != null) {
                Color color = obtenerColorParaTipoSimbolo(tipo, tokenStr);
                listaTokens.add(new Token(tokenStr, color, fila, columna, tipo));
                tokenActual.setLength(0);
            }

            columna++;
            i++;
        }

        if (tokenActual.length() > 0) {
            procesarToken(tokenActual.toString(), listaTokens, errores, fila, columna - tokenActual.length());
        }
    }

    private Color obtenerColorParaTipoSimbolo(Token.TipoSimbolo tipo, String token) {
        if (tipo == Token.TipoSimbolo.RESERVADAS) {
            return new Color(0x60A917); // Color para palabras reservadas
        } else {
            return gestorSimbolos.getColorParaSimbolo(token); // Obtener color del gestor de símbolos
        }
    }

    private Color obtenerColorParaCaracter(Token.TipoSimbolo tipo, String token) {
        if (tipo == Token.TipoSimbolo.CARACTER) {
            return new Color(0x0050EF); // Color para palabras caracteres
        } else {
            return gestorSimbolos.getColorParaSimbolo(token); // Obtener color del gestor de símbolos
        }
    }

    private Color obtenerColorParaNumeroDecimal(Token.TipoSimbolo tipo, String token) {
        if (tipo == Token.TipoSimbolo.DECIMAL) {
            return new Color(0xFFFF88); // Color para palabras numeros decimales
        } else {
            return gestorSimbolos.getColorParaSimbolo(token); // Obtener color del gestor de símbolos
        }
    }

    private Color obtenerColorParaNumero(Token.TipoSimbolo tipo, String token) {
        if (tipo == Token.TipoSimbolo.ENTERO) {
            return new Color(0x1BA1E2); // Color para palabras numeros enteros
        } else {
            return gestorSimbolos.getColorParaSimbolo(token); // Obtener color del gestor de símbolos
        }
    }

    private Color obtenerColorParaCadena(Token.TipoSimbolo tipo, String token) {
        if (tipo == Token.TipoSimbolo.CADENA) {
            return new Color(0xE51400); // Color para palabras cadenas
        } else {
            return gestorSimbolos.getColorParaSimbolo(token); // Obtener color del gestor de símbolos
        }
    }

    private void procesarToken(String token, List<Token> listaTokens, List<String> errores, int fila, int columna) {
        Token.TipoSimbolo tipoSimbolo = obtenerTipoSimbolo(token);
        if (tipoSimbolo != null) {
            Color color = operadoresColores.getOrDefault(token, Color.BLACK);
            listaTokens.add(new Token(token, color, fila, columna, tipoSimbolo));
        }
    }

    private Token.TipoSimbolo obtenerTipoSimbolo(String token) {
        // Verificar operadores
        if (esOperador(token)) {
            return Token.TipoSimbolo.OPERADOR;
        } else if (esComparacion(token)) {
            return Token.TipoSimbolo.COMPARACION;
        } else if (esLogico(token)) {
            return Token.TipoSimbolo.LOGICO;
        } else if (esAsignacion(token)) {
            return Token.TipoSimbolo.ASIGNACION;
        } else if (esPalabraReservada(token)) {
            return Token.TipoSimbolo.RESERVADAS;
        } else if (esSigno(token)) {
            return Token.TipoSimbolo.SIGNOS;
        } else if (esNumeroEntero(token)) {
            return Token.TipoSimbolo.ENTERO;
        } else if (esNumeroDecimal(token)) {
            return Token.TipoSimbolo.DECIMAL;
        } else if (esCadenaTexto(token)) {
            return Token.TipoSimbolo.CADENA;
        } else if (esBooleano(token)) {
            return Token.TipoSimbolo.BOOLEANO;
        } else if (esCaracter(token)) {
            return Token.TipoSimbolo.CARACTER;
        }

        return null; // No es un tipo de dato conocido
    }

    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")
                || token.equals("^") || token.equals("Mod");
    }

    private boolean esComparacion(String token) {
        return token.equals("==") || token.equals("<>") || token.equals(">") || token.equals("<")
                || token.equals(">=") || token.equals("<=");
    }

    private boolean esLogico(String token) {
        return token.equals("And") || token.equals("Or") || token.equals("Not");
    }

    private boolean esAsignacion(String token) {
        return token.equals("+=") || token.equals("*=") || token.equals("/=")
                || token.equals("-=") || token.equals("=");
    }

    private boolean esPalabraReservada(String token) {
        return token.equals("Module") || token.equals("End") || token.equals("Sub") || token.equals("Main")
                || token.equals("Dim") || token.equals("As") || token.equals("Integer") || token.equals("String")
                || token.equals("Boolean") || token.equals("Double") || token.equals("Char") || token.equals("ConsoleWriteLine")
                || token.equals("ConsoleReadLine") || token.equals("If") || token.equals("ElseIf") || token.equals("Else")
                || token.equals("Then") || token.equals("While") || token.equals("Do") || token.equals("Loop")
                || token.equals("For") || token.equals("To") || token.equals("Next") || token.equals("Function")
                || token.equals("Return") || token.equals("Const");
    }

    private boolean esSigno(String token) {
        return token.equals("()") || token.equals("[]") || token.equals("{}") || token.equals(".") || token.equals(",");
    }

    private boolean esIdentificadorValido(String lexema) {
        if (lexema.isEmpty()) {
            return false;
        }
        char primerCaract = lexema.charAt(0);
        if (!Character.isLetter(primerCaract)) {
            return false;
        }
        for (int i = 1; i < lexema.length(); i++) {
            char c = lexema.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    private boolean esNumeroEntero(String lexema) {
        if (lexema.isEmpty()) {
            return false;
        }
        int start = (lexema.charAt(0) == '-') ? 1 : 0;
        for (int i = start; i < lexema.length(); i++) {
            if (!Character.isDigit(lexema.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean esNumeroDecimal(String lexema) {
        if (lexema.isEmpty()) {
            return false;
        }
        int puntoCount = 0;
        int start = (lexema.charAt(0) == '-') ? 1 : 0;
        for (int i = start; i < lexema.length(); i++) {
            char c = lexema.charAt(i);
            if (c == '.') {
                puntoCount++;
                if (puntoCount > 1) {
                    return false; // Solo un punto decimal permitido
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return puntoCount == 1; // Debe haber al menos un punto decimal
    }

    private boolean esCadenaTexto(String lexema) {
        return lexema.length() >= 2 && lexema.startsWith("\"") && lexema.endsWith("\"");
    }

    private boolean esBooleano(String lexema) {
        return lexema.equals("True") || lexema.equals("False");
    }

    private boolean esCaracter(String lexema) {
        return lexema.length() == 3 && lexema.startsWith("'") && lexema.endsWith("'");
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

}
