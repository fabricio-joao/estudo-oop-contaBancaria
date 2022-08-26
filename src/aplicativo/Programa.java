package aplicativo;

import entidades.*;
import excecao.ExcecaoDominio;
import servicos.ServicosTransacoes;
import servicos.TaxasBrasil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ExcecaoDominio {

        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            Cliente c = new Cliente("443", 300, "Luiz Costa");
            //System.out.print("Entre com a senha: ");
            //int senha = scan.nextInt();
            if (c.validacao(123)) { //SENHA:123
                System.out.print("Opeação: 1- Conta Corrente; 2- Conta Popança: ");
                int conta = scan.nextInt();
                scan.nextLine();
                switch (conta) {
                    case 1:
                        System.out.println("Deseja fazer emprestimos: [S/N] ");
                        String dado = scan.nextLine();
                        if (dado.equalsIgnoreCase("s")) {
                            ContaCorrente cc = new ContaCorrente(c.getAgencia(), c.getSaldo(),1000);
                            c.setContaCorrente(cc);
                            c.setEtiqueta(new Etiqueta(c.getSaldo(), c.getTitular(), c.getAgencia()));
                            ServicosTransacoes st = new ServicosTransacoes(new TaxasBrasil());
                            System.out.print("Entre com valor do emprestimo: ");
                            double emprestimo = scan.nextDouble(); //valor do emprestimo
                            st.emprestimoLimite(c, emprestimo);
                            st.deposito(c, 100);
                            st.sacar(c, 50);
                            System.out.println(c.getEtiqueta());
                        } else {
                            ContaCorrente cc = new ContaCorrente(c.getAgencia(), c.getSaldo(), 1000);
                            c.setContaCorrente(cc);
                            c.setEtiqueta(new Etiqueta(c.getSaldo(), c.getTitular(), c.getAgencia()));
                            ServicosTransacoes st = new ServicosTransacoes(new TaxasBrasil());
                            st.deposito(c, 100);
                            st.sacar(c, 30);
                            System.out.println(c.getEtiqueta());
                        }
                        break;
                    case 2:
                        System.out.print("Entre com data: (dd/MM/yyyy): ");
                        LocalDate data = LocalDate.parse(scan.next(), dataformatada);
                        ContaPoupanca cp = new ContaPoupanca(c.getAgencia(), c.getSaldo(), 10, data);
                        c.setContaPoupanca(cp);
                        c.setEtiqueta(new Etiqueta(c.getSaldo(), c.getTitular(), c.getAgencia()));
                        ServicosTransacoes st = new ServicosTransacoes(new TaxasBrasil());
                        System.out.print("Depositar [D] ou sacar [S]: ");
                        String op = scan.next();
                        if(op.equalsIgnoreCase("D")){
                            st.deposito(c, 10);
                            System.out.println(c.getEtiqueta());
                        } else if (op.equalsIgnoreCase("S")){
                            st.sacar(c, 10);
                            System.out.println(c.getEtiqueta());
                        } else {
                            throw new ExcecaoDominio("Opção incorreta");
                        }

                        System.out.print("Consultar saldo poupança: [S/N]: ");
                        String consulta = scan.next();
                        if(consulta.equalsIgnoreCase("S")){
                            st.atualizaSaldo(c);
                            System.out.println(c.getEtiqueta());
                        } else if (consulta.equalsIgnoreCase("N")) {
                            System.out.println(c.getEtiqueta());
                        } else {
                            throw new ExcecaoDominio("Opção incorreta");
                        }
                        break;
                    default:
                        System.out.print("Opção incorreta ");
                }
            } else {
                System.out.println("Senha incorreta");
            }
            scan.close();
        } catch (ExcecaoDominio e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Valor de entrada inválido");
        }
    }
}


