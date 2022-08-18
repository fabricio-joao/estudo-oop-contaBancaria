package entidades;

public class Etiqueta extends  Conta{
    private ContaPoupanca cp;
    private ContaCorrente cc;
    
    public Etiqueta(String titular, int numConta, String agencia, double saldo) {
        super(titular, numConta, agencia, saldo);
    }


    public ContaPoupanca getCp() {
        return cp;
    }

    public void setCp(ContaPoupanca cp) {
        this.cp = cp;
    }

    @Override
    public void depositar(double valor) {

    }

    @Override
    public void sacar(double valor) {

    }

    public ContaCorrente getCc() {
        return cc;
    }

    public void setCc(ContaCorrente cc) {
        this.cc = cc;
    }

    public String toString() {
        String info = "\nTitular da conta: " + this.getTitular();
        info += "\nNúmero conta: " + this.getNumConta();
        info += "\nAgencia: " + this.getAgencia();
        info += "\nSaldo : " + this.getCp().getSaldo();
        return info;
    }
}
