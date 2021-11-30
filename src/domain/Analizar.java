//autor de código @ferajset

package domain;

import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Analizar {

    private static String palabra = new String();

    public static void separar(String cadena, DefaultTableModel modelo) {
        StringTokenizer st = new StringTokenizer(cadena, "\s | \n | \t | \" |\\( | \\) | \\{ | \\} | \\[ | \\] | + | - | * | / | = | ; | ' | : | ,|<|>", true);
        while (st.hasMoreTokens()) {
            Vector v = new Vector();
            String imprimir = identificar(st.nextToken());
            if (imprimir != null) {
                v.add(palabra);
                v.add(imprimir);
                modelo.addRow(v);
            }
        }
    }

    public static String identificar(String parte) {
        parte = parte.replace("\n", "\s");
        parte = parte.replace("\t", "\s");
        var respuesta = new String();

        if (Reglas.esReservada(parte)) {
            respuesta = "Palabra Reservada";
            palabra = parte;
            return respuesta;
        }
        if (Reglas.esVariable(parte)) {
            respuesta = "Palabra/Variable";
            palabra = parte;
            return respuesta;
        }
        if (Reglas.esMetodo(parte)) {
            respuesta = "Metodo";
            palabra = parte;
            return respuesta;
        }
        if (Reglas.esNumero(parte)) {
            respuesta = "Numero";
            palabra = parte;
            return respuesta;
        }
        if (Reglas.esEspacio(parte)) {
            respuesta = null;
            return respuesta;
        }

        if (Reglas.esSimbolo(parte)) {
            respuesta = "Caracter especial";
            palabra = parte;
            return respuesta;
        }
        if (Reglas.esOperadorAritmetico(parte)) {
            respuesta = "Operador Aritmético";
            palabra = parte;
            return respuesta;
        } else {
            respuesta = "No es valido";
            palabra = parte;
            return respuesta;
        }
    }
}
