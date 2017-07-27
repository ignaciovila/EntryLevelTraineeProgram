package com.cognizant.objetos;

import com.cognizant.interfaces.Producto;

public class CuentaCorriente extends CuentaBancaria implements Producto {
    private int descubierto;

    public CuentaCorriente(int saldo, int descubierto, Banco banco) {
        super(saldo, banco);
        this.descubierto = descubierto;
    }

    public int calcularCosto(Producto producto) {
        return 250;
    }

    public void extraer(int monto) {
        if (this.getSaldo() + descubierto >= monto) {
            setSaldo(getSaldo() - monto);
        }
    }

    public int getDescubierto() {
        return this.descubierto;
    }
}