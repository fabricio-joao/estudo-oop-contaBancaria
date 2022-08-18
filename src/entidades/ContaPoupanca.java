package entidades;

import java.time.LocalDate;

public class ContaPoupanca extends Conta{
    private double taxaJuros;
    private LocalDate data;

    public ContaPoupanca(String titular, int numConta, String agencia, double saldo, double taxaJuros, LocalDate data) {
        super(titular, numConta, agencia, saldo);
        this.taxaJuros = taxaJuros;
        this.data = data;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void atualizaSaldo(){
        LocalDate dataHoje = LocalDate.now();
        double taxa = (this.getSaldo() * getTaxaJuros())/100;
        if(dataHoje.isBefore(this.getData())){
            this.setSaldo(this.getSaldo() + taxa);
        }

    }

    @Override
    public void depositar(double valor) {

    }

    public void sacar(double valor) {
        this.setSaldo(getSaldo() - 5);
    }
}
