package domain;

import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;

public class Analizar {

    public static String separar(String cadena) {
        StringTokenizer st = new StringTokenizer(cadena, "\s | \n | \t | \" |\\( | \\) | \\{ | \\} | \\[ | \\] | + | - | * | / | = | ; | ' | : | ,|<|>", true);
        String resultado = new String();
        while (st.hasMoreTokens()) {
            String imprimir = identificar(st.nextToken());

            if (imprimir != null) {
                //System.out.println(imprimir);
                resultado += imprimir + "\n";
            }
        }
        return resultado;
    }

    public static String separar(String cadena, DefaultTableModel modelo) {
        StringTokenizer st = new StringTokenizer(cadena, "\s | \n | \t | \" |\\( | \\) | \\{ | \\} | \\[ | \\] | + | - | * | / | = | ; | ' | : | ,|<|>", true);
        String resultado = new String();
        while (st.hasMoreTokens()) {
            String imprimir = identificar(st.nextToken());

            if (imprimir != null) {
                //System.out.println(imprimir);
                resultado += imprimir + "\n";
            }
        }
        return resultado;
    }

    public static String identificar(String parte) {
        parte = parte.replace("\n", "\s");
        parte = parte.replace("\t", "\s");
        var respuesta = new String();

        if (Reglas.esReservada(parte)) {
            respuesta = parte + "   -->Palabra Reservada";
            return respuesta;
        }
        if (Reglas.esVariable(parte)) {
            respuesta = parte + "   --> Palabra/Variable";
            return respuesta;
        }
        if (Reglas.esMetodo(parte)) {
            respuesta = parte + "   --> Metodo";
            return respuesta;
        }
        if (Reglas.esNumero(parte)) {
            respuesta = parte + "   --> Numero";
            return respuesta;
        }
        if (Reglas.esEspacio(parte)) {
            respuesta = null;
            return respuesta;
        }

        if (Reglas.esSimbolo(parte)) {
            respuesta = parte + "   --> Caracter especial";
            return respuesta;
        }
        if (Reglas.esOperadorAritmetico(parte)) {
            respuesta = parte + "   --> Operador Aritmético";
            return respuesta;
        } else {
            respuesta = parte + "   --> No es valido";
            return respuesta;
        }
    }
}
