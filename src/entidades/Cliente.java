package entidades;

public class Cliente extends Conta{
    private String titular;
    private int senha;
    private int numConta;

    public Cliente(String agencia, double saldo, String titular, int numConta) {
        super(agencia, saldo);
        this.titular = titular;
        this.senha = 987;
        this.numConta = numConta;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getSenha() {
        return senha;
    }

    public boolean validacao(int senha){
        if(this.getSenha() == senha){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {

    }

    @Override
    public void sacar(double valor) {

    }
}
