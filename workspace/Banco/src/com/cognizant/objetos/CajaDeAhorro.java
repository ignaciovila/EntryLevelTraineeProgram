package com.cognizant.objetos;

public class CajaDeAhorro extends CuentaBancaria {

    public CajaDeAhorro(int saldo, Banco banco) {
        super(saldo, banco);
    }

    public void extraer(int monto) {
        if (this.getSaldo() >= monto) {
            setSaldo(getSaldo() - monto);
        }
    }
}
