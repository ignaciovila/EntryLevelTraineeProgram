package com.cognizant.objetos;

public abstract class CuentaBancaria {
    private int numero;
    private int saldo;
    private Banco banco;

    public CuentaBancaria(int saldo, Banco banco) {
        this.numero = banco.getLast();
        this.saldo = saldo;
        this.banco = banco;
        System.out.println("La cuenta bancaria se ha creado correctamente, el número es " + this.numero);
    }

    public abstract void extraer(int monto);

    public int getNumero() {
        return numero;
    }

    protected void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSaldo() {
        return saldo;
    }

    protected void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof CuentaBancaria)) return false;

        CuentaBancaria that = (CuentaBancaria) o;

        if (numero != that.numero) return false;
        return banco != null ? banco.equals(that.banco) : that.banco == null;

    }

    @Override
    public int hashCode() {
        int result = numero;
        result = 31 * result + (banco != null ? banco.hashCode() : 0);
        return result;
    }


}