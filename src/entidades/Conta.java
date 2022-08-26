package entidades;

import excecao.ExcecaoDominio;

public abstract class Conta {
    private String agencia;
    private double saldo;

    public Conta( String agencia, double saldo) {
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
