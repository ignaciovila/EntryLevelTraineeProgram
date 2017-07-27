package com.cognizant.objetos;

import java.util.ArrayList;
import java.util.HashMap;

public class Banco {
    private String nombre;
    private HashMap<Integer, CuentaBancaria> listaCuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.listaCuentas = new HashMap<Integer, CuentaBancaria>();
    }

    public void extraer(int numero, int monto) {
        CuentaBancaria cuenta = listaCuentas.get(numero);
        cuenta.extraer(monto);
    }

    public int getLast() {
        return listaCuentas.size();
    }

    public void addAcc(CuentaBancaria cuenta) {
        this.listaCuentas.put(listaCuentas.size(), cuenta);
    }

    public void addAcc(int saldo, int descubierto) {
        if (descubierto == 0) {
            CuentaBancaria cuenta = new CajaDeAhorro(saldo, this);
            this.listaCuentas.put(listaCuentas.size(), cuenta);
        } else {
            CuentaBancaria cuenta = new CuentaCorriente(saldo, descubierto, this);
            this.listaCuentas.put(listaCuentas.size(), cuenta);
        }
    }

    public CuentaBancaria getCuenta(int numero) {
        CuentaBancaria cuenta = listaCuentas.get(numero);
        return cuenta;
    }

    public int getSaldo(int numero) {
        int saldo = -1;
        saldo = listaCuentas.get(numero).getSaldo();
        return saldo;
    }

    public HashMap<Integer, CuentaBancaria> getLista() {
        return this.listaCuentas;
    }

    public void borrarCuenta(int numero) {
        listaCuentas.remove(numero);
    }
}
