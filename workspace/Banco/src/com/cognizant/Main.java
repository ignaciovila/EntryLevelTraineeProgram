package com.cognizant;

import com.cognizant.objetos.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Banco frances = new Banco("BBVA Francés");
        frances.addAcc(1000, 2000);
        frances.extraer(0, 3000);
        frances.addAcc(5000, 0);
        frances.addAcc(2000, 1000);
        frances.extraer(2, 500);

        // CASTEO AUTOMÁTICO
        CuentaBancaria c1 = new CuentaCorriente(1000, 2000, frances) {
        };
        // c1.getDescubierto();
        //CASTEO MANUAL
        CuentaCorriente c2 = (CuentaCorriente) c1;
        c2.getDescubierto();
        CuentaBancaria c3 = c1;
        CuentaBancaria c4 = new CajaDeAhorro(10000, frances);

        for (CuentaBancaria cuenta : frances.getLista().values()
             ) {
            System.out.println(cuenta.getNumero() + "       " + cuenta.getSaldo());
        }
    }
}
