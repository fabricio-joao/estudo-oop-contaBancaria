package aplicativo;

import entidades.*;
import excecao.ExcecaoDominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dataformatada =   DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            Cliente c = new Cliente("334", 1000.0, "José Lopez", 994 );

            if(c.validacao(987)){
                System.out.print("Opeação: 1- Conta Corrente; 2- Conta Popança: ");
                int conta = scan.nextInt();
                scan.nextLine();
                switch (conta) {
                    case 1:
                        System.out.println("Deseja fazer emprestimos: [S/N] ");
                        String dado = scan.nextLine();
                        if(dado.equalsIgnoreCase("s")){
                            ContaCorrente cc = new ContaCorrente("667", c.getSaldo(), 1100);//Limite do emprestimo setado
                            System.out.println("Entre com valor do emprestimo: ");
                            double emprestimo = scan.nextDouble(); //valor do emprestimo
                            cc.emprestimoLimite(emprestimo);
                            cc.setCliente(c);
                            System.out.println(cc);

                        } else {
                            ContaCorrente cc = new ContaCorrente("667", c.getSaldo(), 1100);
                            cc.depositar(200);
                            cc.sacar(50.0);
                            cc.setCliente(c);
                            System.out.println(cc);
                        }
                        break;
                    case 2:
                        ContaCorrente cc = new ContaCorrente("667", c.getSaldo(), 1100);
                        System.out.print("Entre com data: (dd/MM/yyyy): ");
                        LocalDate data = LocalDate.parse(scan.next(), dataformatada);
                        ContaPoupanca cp = new ContaPoupanca(cc.getAgencia(), cc.getSaldo(), 10, data);
                        cp.atualizaSaldo();
                        cp.setCliente(c);
                        System.out.println(cp);
                        break;

                    default:
                        System.out.print("Opção incorreta ");
                }
            } else {
                System.out.println("Senha incorreta");
            }
            scan.close();
        }
        catch (ExcecaoDominio e){
            System.out.println(e.getMessage());
        }
    }
}
