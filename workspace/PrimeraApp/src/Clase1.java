public class Clase1 {
    public static void main(String[] args) {
        // A PARTIR DE UNA FRASE "JAVA ES EL MEJOR LENGUAJE DE PROGRAMACIÓN DEL MUNDO", RECUPERAR LA CANTIDAD DE CARACTERES
        // PASARLO A MAYUS, REMPLAZAR LOS ESPACIOS POR UN ARROBA, RECUPERAR LAS PALABRAS, DECIR EN QUÉ POSICIÓN ESTÁ LA PALABRA 'MEJOR'
        // RECUPERAR LA SUBCADENA QUE ESTÁ ENTRE LA POSICIÓN 10-20, DECIR SI LA FRASE COMIENZA CON LA PALABRA JAVA, PREGUNTAR SI LA CADENA
        // ES IGUAL A MANDARINA

        String frase = "java es el mejor lenguaje de programación del mundo";
        System.out.println(frase.length());
        System.out.println(frase.toUpperCase());
        System.out.println(frase.replace(" ", "@"));
        String[] palabras = frase.split(" ");
        for (String palabra : palabras
                ) {
            System.out.print(palabra);
        }
        System.out.println("Mejor: " + frase.indexOf("mejor"));
        System.out.println("Subcadena: " + frase.substring(10, 20));
        boolean empJava = frase.startsWith("java");
        if (empJava) {
            System.out.println("SI");
        } else {
            System.out.println("MALA SUERTE");
        }
        if (frase.equalsIgnoreCase("mandarina") == true) {
            System.out.println("Es mandarina!");
        } else {
            System.out.println("Mala suerte");
        }
    }
}