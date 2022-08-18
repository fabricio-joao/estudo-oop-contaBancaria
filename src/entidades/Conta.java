package entidades;

public class Conta {
    private String titular;
    private int numConta;
    private String agencia;
    private double saldo;

    private ContaPoupanca cp;
    private ContaCorrente cc;

    public Conta(String titular, int numConta, String agencia, double saldo) {
        this.titular = titular;
        this.numConta = numConta;
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
        String info = "\nTitular da conta: " + this.getTitular();
               info += "\nNúmero conta: " + this.getNumConta();
               info += "\nAgencia: " + this.getAgencia();
               //info += "\nSaldo: " + this.getSaldo();
               info += "\nSaldo Poupança: " + this.getCp().getSaldo();
               info += "\nSaldo ContaCorrentr: " + this.getCc().getSaldo();
        return info;
    }
}
