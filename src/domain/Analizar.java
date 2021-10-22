package domain;

import java.util.regex.Pattern;
import domain.Reglas;
import java.util.ArrayList;

public class Analizar {

    static ArrayList<String> palabras = new ArrayList<String>();

//    public static void separarCadena(String cadena) {
//        Pattern espacios = Pattern.compile("\s|\\(|\\)|\\{|\\}");
//        String partes[] = espacios.split(cadena);
//        identificar(partes);
//        // System.out.println("\n\n");
//        //recorre(partes);
//    }
    public static void separarIndex(String cadena, int inicio, int fin) {

        if (cadena.indexOf("(") != -1) {
            fin = cadena.indexOf("(", inicio);

            if (fin != -1) {
            } else {
                fin = cadena.length();
            }

            String ingreso = cadena.substring(inicio, fin);
            ingresar(ingreso, fin, cadena);

            if (fin != cadena.length()) {
                inicio = fin + 1;
                separarIndex(cadena, inicio, fin);
            }
        }
    }

    public static void ingresar(String ingreso, int fin, String cadena) {
        if (fin != cadena.length()) {
            palabras.add(ingreso);
            palabras.add("(");
        } else {
            palabras.add(ingreso);
        }
    }

    public static void recorrer() {
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }

    public static void identificar(String partes[]) {
        for (String recorre : partes) {
            if (recorre.isEmpty() != true) {
                if (Reglas.esReservada(recorre)) {
                    System.out.println(recorre + " : Es una palabra Reservada");
                } else if (Reglas.esVariable(recorre)) {
                    System.out.println(recorre + " : Es una variable");
                } else if (Reglas.esMetodo(recorre)) {
                    System.out.println(recorre + " : Es un metodo");
                } else if (Reglas.esNumero(recorre)) {
                    System.out.println(recorre + " : Es un numero");
                } else if (Reglas.esSimbolo(recorre)) {
                    System.out.println(recorre + " : Es un caracter especial");
                } else if (Reglas.esEspacio(recorre)) {
                    System.out.println(recorre + " : Hay un espacio");
                } else {
                    System.out.println(recorre + " : No es valido");
                }
            }
        }
    }

    public static void main(String[] args) {
        String test = "if(Reglas.esReservada(recorre)){System.out.println();";
        //test="(";
        separarIndex(test, 0, 0);
        recorrer();
    }
}
