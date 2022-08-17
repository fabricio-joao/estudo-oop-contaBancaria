package aplicativo;

import entidades.Conta;
import entidades.ContaCorrente;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /*System.out.println("Sistema Bancário: ");

        System.out.print("Entre com títular: ");
        String nome = scan.nextLine();

        System.out.print("Entre com número conta: ");
        int numero = scan.nextInt();
        scan.nextLine();

        System.out.print("Entre com Agência: ");
        String ag = scan.nextLine();*/


        //Conta c = new Conta(nome, numero, ag, 1000.0);
        ContaCorrente cc = new ContaCorrente("João", 3411, "8752", 1000.0, 2000.0);
        cc.depositar(200);
        cc.sacar(50.0);
        cc.emprestimoLimite(1000);
        System.out.print(cc);
        scan.close();
    }
}
