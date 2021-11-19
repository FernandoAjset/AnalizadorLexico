package domain;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reglas {

    static String reservadas[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
        "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for",
        "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null",
        "package", "private", "protected", "public", "return", "short", "static", "strictfp", "String", "super", "switch",
        "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while", "main"};
    
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
        return mat.matches();
    }

    public static boolean esMetodo(String test) {
        Pattern pat = Pattern.compile("^([a-zA-Z_]+[0-9_]*([\\\\.][a-zA-Z_]+[0-9_]*)+)$");
        Matcher mat = pat.matcher(test);
        return mat.matches();
    }

    public static boolean esNumero(String test) {
        Pattern pat = Pattern.compile("^[0-9]+(\\.[0-9]+)*$");
        Matcher mat = pat.matcher(test);
        return mat.matches();
    }

    public static boolean esSimbolo(String test) {
        Pattern pat = Pattern.compile("[.!.¡.\".#.$.&.'.(.).,..:.;.<.=.>.?.@\\[\\].^._.`.{.|.}]+"); 
        Matcher mat = pat.matcher(test);
        
        boolean respuesta = mat.matches();
        if (respuesta != true) {
            Pattern pat2 = Pattern.compile("^[\\\\]+$");
            Matcher mat2 = pat2.matcher(test);
            respuesta = mat2.matches();
        }
        return respuesta;
        
    }

    public static boolean esEspacio(String test) {
        Pattern pat = Pattern.compile("^[\s]+$");
        Matcher mat = pat.matcher(test);
        return mat.matches();
    }

    public static boolean esComentario(String test) {
        Pattern pat = Pattern.compile("^([./]{1}[.*]{1})([\\-a-zA-Z0-9.!.\".#.$.%.&.'.(.).*.+-.,/../.:.;.<.=.>.?.@.[.].^._.`.{.|.}\s]*)([.*]{1}[./]{1})$");
        Matcher mat = pat.matcher(test);
        boolean respuesta = mat.matches();
        if (respuesta != true) {
            Pattern pat2 = Pattern.compile("^([./]{2})[[\s]*[a-zA-Z0-9.!.\".#.$.%.&.'.(.).*.+\\-.,.-/../.:.;.<.=.>.?.@.[.].^._.`.{.|.}]*[\s]*]*$");
            Matcher mat2 = pat2.matcher(test);
            respuesta = mat2.matches();
        }
        return respuesta;
    }
    
    public static boolean esOperadorAritmetico(String test){
        Pattern pat = Pattern.compile("^([+-/*/]{1})$");
        Matcher mat=pat.matcher(test);
        return mat.matches();
    }
}
