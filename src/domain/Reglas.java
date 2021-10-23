package domain;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reglas {

    static String reservadas[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
        "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for",
        "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null",
        "package", "private", "protected", "public", "return", "short", "static", "strictfp", "String", "super", "switch",
        "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"};

    int a;

    public static boolean esReservada(String test) {
        for (String recorre : reservadas) {
            if (recorre.equals(test)) {
                return true;
            }
        }
        return false;
    }

    public static boolean esVariable(String test) {
        Pattern pat = Pattern.compile("^([a-zA-Z_]+[0-9_]*)$");
        Matcher mat = pat.matcher(test);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esMetodo(String test) {
        Pattern pat = Pattern.compile("^([a-zA-Z_]+[0-9_]*([\\\\.][a-zA-Z_]+[0-9_]*)+)$");   // "^([a-zA-Z_]+[0-9_]*[\\.][a-zA-Z_]+[0-9_]*[\\(]{1}[\\)]{1})$"
        Matcher mat = pat.matcher(test);
        return mat.matches();
    }

    public static boolean esNumero(String test) {
        Pattern pat = Pattern.compile("^[0-9]+(\\.[0-9]+)*$");
        Matcher mat = pat.matcher(test);
        return mat.matches();
    }

    public static boolean esSimbolo(String test) {
        Pattern pat = Pattern.compile("[.!.\".#.$.%.&.'.(.).*.+.,.-/../.:.;.<.=.>.?.@.[.].^._.`.{.|.}]{1}"); //"[! \" # $ % & ' ( ) * + , \\ -. / : ; < = > ? @ [ ] ^ _ ` { | }]?"
        Matcher mat = pat.matcher(test);
        return mat.matches();
    }

    public static boolean esEspacio(String test) {
        Pattern pat = Pattern.compile("[\n\s]+");
        Matcher mat = pat.matcher(test);
        return mat.matches();
    }

    public static boolean esComentario(String test) {
        Pattern pat = Pattern.compile("^([./]{1}[.*]{1})([.*]{1}[./]{1})$");
        Matcher mat = pat.matcher(test);
        return mat.matches();
    }
}
/*ASDFASDFSADASDFSAD!**8784641212F1215151*/ 
//^([./]{1}[.*]{1})([a-zA-Z0-9]*[.!.\".#.$.%.&.'.(.).*.+.,.-/../.:.;.<.=.>.?.@.[.].^._.`.{.|.}]*)([.*]{1}[./]{1})$
