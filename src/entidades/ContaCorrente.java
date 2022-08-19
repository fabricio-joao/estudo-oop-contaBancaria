package entidades;

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
            System.out.println("\nServiço indisponivel ContaCorrente emprestimo limite()");
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor < 0){
            System.out.println("Operação indisponivel Conta Corrente depositar()");
        } else {
            this.setSaldo(this.getSaldo() + valor);
        }
    }

    @Override
    public void sacar(double valor) {
        if(valor < 0 || valor > this.getSaldo()){
            System.out.println("Operação indisponivel Conta Corrente sacar()");
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
