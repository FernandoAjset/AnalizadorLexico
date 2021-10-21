package domain;

import java.util.regex.Pattern;
import domain.Reglas;
import java.util.ArrayList;

public class Analizar {

    ArrayList partes;

    public static void separarCadena(String cadena) {
        Pattern espacios = Pattern.compile("\s|\\(|\\)|\\{|\\}");

        String partes[] = espacios.split(cadena);
        identificar(partes);
        // System.out.println("\n\n");
        recorre(partes);
    }

    public static void recorre(String partes[]) {
        for (String recorre : partes) {
            System.out.println(recorre);
        }
    }

    public static void identificar(String partes[]) {
        for (String recorre : partes) {
            if (Reglas.esEspacio(recorre)!=true||recorre!=null) {
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
        test="";
        separarCadena(test);
    }
}
