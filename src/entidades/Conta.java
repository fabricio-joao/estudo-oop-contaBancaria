package entidades;

public class Conta {
    private String titular;
    private int numConta;
    private String agencia;
    private double saldo;

    public Conta(String titular, int numConta, String agencia, double saldo) {
        this.titular = titular;
        this.numConta = numConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
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

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        String info = "Titular da conta: " + this.getTitular();
               info += "\nNúmero conta: " + this.getNumConta();
               info += "\nAgencia: " + this.getAgencia();
               info += "\nSaldo: " + this.getSaldo();
        return info;
    }
}
