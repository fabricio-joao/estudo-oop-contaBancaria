package entidades;

import excecao.ExcecaoDominio;

public class ContaCorrente extends Conta {

    private double LimiteEmprestimo;
    private Cliente cliente;

    public ContaCorrente(String agencia, double saldo, double limiteEmprestimo) {
        super(agencia, saldo);
        LimiteEmprestimo = limiteEmprestimo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getLimiteEmprestimo() {
        return LimiteEmprestimo;
    }

    public void setLimiteEmprestimo(double limiteEmprestimo) {
        LimiteEmprestimo = limiteEmprestimo;
    }

    public void emprestimoLimite(double valor){
        if(valor < this.getLimiteEmprestimo()){
            this.setSaldo((this.getSaldo() + valor));
        } else {
            System.out.println("\nServiço indisponivel");
        }
    }

    @Override
    public void depositar(double valor) throws ExcecaoDominio {
        if(valor < 0){
            throw new ExcecaoDominio("Operação indisponivel");
        } else {
            this.setSaldo(this.getSaldo() + valor);
        }
    }

    @Override
    public void sacar(double valor) throws ExcecaoDominio {
        if(valor < 0 || valor > this.getSaldo()){
            throw new ExcecaoDominio("Operação indisponivel");
        } else {
            this.setSaldo(this.getSaldo() - valor);
        }
    }

    public String toString() {
        String info = "Titular: " + this.getCliente().getTitular();
        info += "\nAgencia: " + this.getAgencia();
        info += "\nSaldo : " + this.getSaldo();
        return info;
    }
}
