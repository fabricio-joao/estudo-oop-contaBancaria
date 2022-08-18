package entidades;

public class ContaCorrente extends Conta {

    private double emprestimo;

    public ContaCorrente(String titular, int numConta, String agencia, double saldo, double emprestimo) {
        super(titular, numConta, agencia, saldo);
        this.emprestimo = emprestimo;
    }

    public double getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(double emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void emprestimoLimite(double valor){
        if(valor < this.getEmprestimo()){
            this.setSaldo((this.getSaldo() + valor) - 10);
        } else {
            System.out.println("\nServiço indisponivel");
        }
    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public void sacar(double valor) {
        this.setSaldo(this.getSaldo() - valor);
    }
}
