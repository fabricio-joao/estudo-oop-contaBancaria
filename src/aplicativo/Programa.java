package aplicativo;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dataformatada =   DateTimeFormatter.ofPattern("dd/MM/yyyy");
        /*System.out.println("Sistema Bancário: ");

        System.out.print("Entre com títular: ");
        String nome = scan.nextLine();

        System.out.print("Entre com número conta: ");
        int numero = scan.nextInt();
        scan.nextLine();

        System.out.print("Entre com Agência: ");
        String ag = scan.nextLine();*/



        ContaCorrente cc = new ContaCorrente("Maria", 3411, "8752", 1000.0, 2000.0);
        cc.depositar(200);
        //cc.sacar(50.0);
        //cc.emprestimoLimite(1000);
        //System.out.println("Conta corrente: " + cc);*/

        System.out.println();
        System.out.print("Entre com data: (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(scan.next(), dataformatada);
       ContaPoupanca cp = new ContaPoupanca("João", 3411, "8752", 1000.0, 10, data);
        //cp.atualizaSaldo();
        Conta c = new Conta("João", 3411, "8752", 1000.0);
        c.setCp(cp);
        c.setCc(cc);
        System.out.println(c);
        scan.close();
    }
}
