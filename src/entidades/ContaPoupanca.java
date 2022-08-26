package entidades;

import excecao.ExcecaoDominio;

import java.time.LocalDate;
public class ContaPoupanca extends Conta{
    private double taxaJuros;
    private LocalDate data;

    public ContaPoupanca(String agencia, double saldo, double taxaJuros, LocalDate data) {
        super(agencia, saldo);
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

}

