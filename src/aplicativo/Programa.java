package aplicativo;

import entidades.Conta;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Sistema Bancário: ");

        System.out.print("Entre com títular: ");
        String nome = scan.nextLine();

        System.out.print("Entre com número conta: ");
        int numero = scan.nextInt();
        scan.nextLine();

        System.out.print("Entre com Agência: ");
        String ag = scan.nextLine();

        System.out.print("Entre com saldo: ");
        double saldo = scan.nextDouble();

        Conta c = new Conta(nome, numero, ag, saldo);
        System.out.print(c);
        scan.close();
    }
}
