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

    public double atualizaSaldo(){
        LocalDate dataHoje = LocalDate.now();
        double taxa = (this.getSaldo() * getTaxaJuros())/100;
        double a = 0;
        if(dataHoje.isBefore(this.getData())){
            a = this.getSaldo() + taxa;
        }
        return a;
    }

    public void sacar(double valor) {
        this.setSaldo(getSaldo() - 5);
    }
}
