package entidades;

public abstract class Conta {

    private String agencia;
    private double saldo;

    private ContaPoupanca cp;
    private ContaCorrente cc;

    public Conta( String agencia, double saldo) {
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public ContaCorrente getCc() {
        return cc;
    }

    public void setCc(ContaCorrente cc) {
        this.cc = cc;
    }

    public ContaPoupanca getCp() {
        return cp;
    }

    public void setCp(ContaPoupanca cp) {
        this.cp = cp;
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

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

}
