package com.example.parcial1;

public class Transformador{

    public static String mayuscula(String texto){
        return texto.toUpperCase();
    }

    public static String minuscula(String texto){
        return texto.toLowerCase();
    }

    public static String inversa(String texto){
        String textoInvertido = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            textoInvertido += texto.charAt(i);
        }
        return textoInvertido;
    }
    public static int contarPalabras(String texto){
        int numeroPalabras = 0;
        String[] textos = texto.trim().split("\\s+");
        numeroPalabras = textos.length;
        return numeroPalabras;
    }
}
