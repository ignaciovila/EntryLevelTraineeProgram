package com.cognizant.view;

import com.cognizant.dao.PersonasDAO;
import com.cognizant.model.Persona;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonasDAO personasDAO = new PersonasDAO();

        int out = -1;
        while (out != 0) {

            System.out.println("Seleccione la opción deseada:\n" + "1. Nueva persona\n" + "2. Mostrar persona\n"
                    + "3. Mostrar por nombre\n" + "4. Salir");
            out = Integer.parseInt(sc.nextLine());
            switch (out){
                case 1:
                    Persona persona = new Persona();

                    System.out.println("Ingrese nombre");
                    persona.setNombre(sc.nextLine());

                    System.out.println("Ingrese apellido");
                    persona.setApellido(sc.nextLine());

                    System.out.println("Ingrese edad");
                    persona.setEdad(Integer.parseInt(sc.nextLine()));

                    personasDAO.altaDePersona(persona);
                    out = -1;
                    break;
                case 2:
                    for (Persona p : personasDAO.recuperarPersonas()
                            ) {
                        System.out.println(p.toString());
                    }
                    out = -1;
                    break;
                case 3:
                    String ingreso = sc.nextLine();
                    ArrayList<Persona> personas = personasDAO.buscarPersonaPorNombre(ingreso);
                    for (Persona p : personas
                            ) {
                        System.out.println(p.toString());
                    }
                    out = -1;
                    break;
                case 4:
                    out = 0;
                    break;
                default:
                    System.out.println("La opción ingresada no existe");
                    out = -1;
            }
        }
        sc.close();
    }
}