package servicos;

import entidades.Cliente;
import entidades.Etiqueta;
import excecao.ExcecaoDominio;

import java.time.LocalDate;

public class ServicosTransacoes {
    private TaxasImpostos tx;

    public ServicosTransacoes(TaxasImpostos tx) {
        this.tx = tx;
    }

    public void deposito(Cliente c, double valor) throws ExcecaoDominio {
        if(valor < 0){
            throw new ExcecaoDominio("Operação deposito indíponivel, valor inadequado: $" + valor);
        } else {
            c.setSaldo (c.getSaldo() + valor);
            c.setEtiqueta(new Etiqueta(c.getSaldo(), c.getTitular(),c.getAgencia()));
        }
    }

    public void sacar(Cliente c, double valor) throws ExcecaoDominio {
        if(valor < 0 || valor > c.getSaldo()){
            throw new ExcecaoDominio("Operação saque indíponivel, valor inadequado: $" + valor);
        } else {
            c.setSaldo(c.getSaldo() - valor);
            c.setEtiqueta(new Etiqueta(c.getSaldo(), c.getTitular(),c.getAgencia()));
        }
    }

    public void emprestimoLimite(Cliente c, double valor) throws ExcecaoDominio {
        if(valor > c.getContaCorrente().getLimiteEmprestimo()){
            throw new ExcecaoDominio("Operação emprestimo indíponivel, valor inadequado: $" + valor);
        } else {
            c.setSaldo (c.getSaldo() + valor);
            c.setEtiqueta(new Etiqueta(c.getSaldo(), c.getTitular(),c.getAgencia()));
        }
    }

    public void atualizaSaldo(Cliente c){
        LocalDate dataHoje = LocalDate.now();
        LocalDate data = c.getContaPoupanca().getData();
        if(dataHoje.isBefore(data)){
            c.setSaldo(c.getSaldo() + tx.taxas(c.getSaldo()));
            c.setEtiqueta(new Etiqueta(c.getSaldo(), c.getTitular(),c.getAgencia()));
        } else {
            c.setSaldo(c.getSaldo());
            c.setEtiqueta(new Etiqueta(c.getSaldo(), c.getTitular(),c.getAgencia()));
        }
    }
}
