package domain;

import java.util.regex.Pattern;
import domain.Reglas;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JTable;

public class Analizar {

    public static void separarConToken(String cadena) {
        StringTokenizer st = new StringTokenizer(cadena, "\s | \n | \t | \" |\\( | \\) | \\{ | \\} | \\[ | \\] | + | - | * | / | = | ; | ' | : | ,", true);
        String resultado = new String();
        while (st.hasMoreTokens()) {
            String imprimir = identificar(st.nextToken());
            if (imprimir != null) {
                System.out.println(imprimir);
            }
        }
        System.out.println("\n\n");
    }

    public static String separar(String cadena) {
        StringTokenizer st = new StringTokenizer(cadena, "\s | \n | \t | \" |\\( | \\) | \\{ | \\} | \\[ | \\] | + | - | * | / | = | ; | ' | : | ,", true);
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
            respuesta = parte + " -->Palabra Reservada";
            return respuesta;
        }
        if (Reglas.esVariable(parte)) {
            respuesta = parte + " --> Palabra/Variable";
            return respuesta;
        }
        if (Reglas.esMetodo(parte)) {
            respuesta = parte + " --> Metodo";
            return respuesta;
        }
        if (Reglas.esNumero(parte)) {
            respuesta = parte + " --> Numero";
            return respuesta;
        }
        if (Reglas.esEspacio(parte)) {
            respuesta = null;
            return respuesta;
        }

        if (Reglas.esSimbolo(parte)) {
            respuesta = parte + " --> Caracter especial";
            return respuesta;
        }
        if (Reglas.esOperadorAritmetico(parte)) {
            respuesta = parte + " --> Operador Aritmético";
            return respuesta;
        } else {
            respuesta = parte + " --> No es valido";
            return respuesta;
        }
    }

    public static void main(String[] args) {
        String test = new String();
        String res = new String();
//        test = "public class HolaMundo{\n"
//                + "public static void main(String Args[]){\n"
//                + "	System.out.println(\"Hola mundo\");\n"
//                + "}";
//        separarConToken(test);

//        test = "int a=1;"
//                + "int b=15;"
//                + "int c=18;"
//                + "a = b+c;";
//        separarConToken(test);
        test = "public class Tarea {\n"
                + "    public static void main(String args[])\n"
                + "    {\n"
                + "       Scanner consola = new Scanner(System.in);\n"
                + "        System.out.println(\"Proporciona el titulo: \");\n"
                + "        var titulo=consola.nextLine();\n"
                + "        System.out.println(\"Proporciona el autor\");\n"
                + "        var autor=consola.nextLine();\n"
                + "        System.out.println(titulo+\" fue escrito por \" + autor);\n"
                + "    }\n"
                + "}";
        res=separar(test);
        System.out.println(res);
        
        
//        test = "package test;\n"
//                + "\n"
//                + "import domain.Persona;\n"
//                + "import domain.*;\n"
//                + "\n"
//                + "public class TestForEach {\n"
//                + "    public static void main(String[] args) {\n"
//                + "        int edades[]= {5,6,8,9,4};\n"
//                + "        \n"
//                + "        for(int edad: edades){\n"
//                + "            System.out.println(\"edad = \" +edad);   \n"
//                + "        }\n"
//                + "        \n"
//                + "        Persona personas[]= {new Persona(\"Juan\"),new Persona(\"Mario\"),new Persona(\"Karla\")};\n"
//                + "        \n"
//                + "        for(Persona persona: personas){\n"
//                + "            System.out.println(\"persona = \" + persona);\n"
//                + "        }\n"
//                + "    }\n"
//                + "}";
//        separarConToken(test);

    }
}
