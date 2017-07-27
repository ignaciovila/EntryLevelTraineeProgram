package com.cognizant;

public class Main {

    public static void main(String[] args) {
        // EJ 1
        for (int i = 1; i < 8; i++) {
            System.out.println("byte");
            System.out.println("short");
            System.out.println("int");
            System.out.println("long");
            System.out.println("float");
            System.out.println("double");
            System.out.println("boolean");
            System.out.println("char");
        }
        // EJ 2
        String textoByte = "1";
        byte b = Byte.parseByte(textoByte);

        String textoShort = "2";
        short s = Short.parseShort(textoShort);

        String textoInt = "3";
        int i = Integer.parseInt(textoInt);

        String textoLong = "4";
        long l = Long.parseLong(textoLong);

        String textoFloat = "5";
        float f = Float.parseFloat(textoFloat);

        String textoDouble = "6";
        double d = Double.parseDouble(textoDouble);

        // EJ 3
        System.out.println("PARES");
        for (int j = 1; j < 1001; j++) {
            if (j % 2 == 0) {
                System.out.println(j);
            }
        }

        // EJ 4
        for (int j = 2; j < 1001; j += 2) {
            switch (j) {
                case (100):
                    System.out.println("Llegamos al " + j);
                    break;
                case (300):
                    System.out.println("Llegamos al " + j);
                    break;
                case (500):
                    System.out.println("Llegamos al " + j);
                    break;
                case (700):
                    System.out.println("Llegamos al " + j);
                    break;
                default:
                    System.out.println(j);
            }
        }

        // EJ 5
        Calculadora calc = new Calculadora();
        calc.sumar(3,2);
        calc.restar(4,5);
        calc.multiplicar(8,8);
        calc.dividir(16, 4);
    }
}
