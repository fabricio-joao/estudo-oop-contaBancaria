package entidades;

public class Etiqueta {
private double recebeSaldo;
private String titular;
private String agencia;

    public Etiqueta(double recebeSaldo, String titular, String agencia) {
        this.recebeSaldo = recebeSaldo;
        this.titular = titular;
        this.agencia = agencia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getRecebeSaldo() {

        return recebeSaldo;
    }

    public void setRecebeSaldo(double recebeSaldo) {

        this.recebeSaldo = recebeSaldo;
    }

    @Override
    public String toString() {
        String info = "Titular: " + this.getTitular();
        info += "\nAgencia: " + this.getAgencia();
        info += "\nSaldo Deposito: " + this.getRecebeSaldo();
        return info;
    }
}
