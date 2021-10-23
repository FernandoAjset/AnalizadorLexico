package domain;

import java.util.regex.Pattern;
import domain.Reglas;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Analizar {

    public static void separarConToken(String cadena) {
        StringTokenizer st = new StringTokenizer(cadena, "\s | \\( | \\) | \\{ | \\}", true);

        System.out.println("Hay un total de: " + st.countTokens() + " tokens.");

        while (st.hasMoreTokens()) {
            identificar(st.nextToken());
        }

    }

    public static void identificar(/*ArrayList<String> partes*/String parte) {

        if (Reglas.esReservada(parte)) {
            System.out.println(parte + " : Es una palabra Reservada");
        } else if (Reglas.esVariable(parte)) {
            System.out.println(parte + " : Es una variable");
        } else if (Reglas.esMetodo(parte)) {
            System.out.println(parte + " : Es un metodo");
        } else if (Reglas.esNumero(parte)) {
            System.out.println(parte + " : Es un numero");
        } else if (Reglas.esEspacio(parte)) {
//            System.out.println(parte + " : Hay un espacio");

        } else if (Reglas.esSimbolo(parte)) {
            System.out.println(parte + " : Es un caracter especial");

        } else {
            System.out.println(parte + " : No es valido");
        }

    }

    public static void main(String[] args) {
        String test = "if (Reglas.esReservada(recorre)){System.out.println();";

        //test = "! \" # $ % & ' ( ) * + , - . / : ; < = > ? @ [ ] ^ _ ` { | } ?";
        test = "else {\n"
                + "            System.out.println(parte + \" : No es valido\");\n"
                + "        }";
        //test="\n";
//        recorrer();
        // identificar(partes);
        separarConToken(test);
    }
}
