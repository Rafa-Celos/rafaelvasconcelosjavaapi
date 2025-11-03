package br.edu.infnet.rafaelvasconcelosjavaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RafaelvasconcelosjavaapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RafaelvasconcelosjavaapiApplication.class, args);

        System.out.println("Iniciando...");

        Scanner entrada = new Scanner(System.in);
        Conta conta = new Conta();

        System.out.println("Informe o nome do titular da conta: ");
        conta.nome = entrada.nextLine();

        System.out.println("Informe o número da conta: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Número de conta invalido");
            entrada.next();
        } else {
            int numeroConta = entrada.nextInt();
            if (numeroConta <= 0) {
                System.out.println("Número de conta não pode ser zero ou negativo");
            } else {
                conta.conta = numeroConta;
            }
        }

        int opcao = 0;
        do {
            System.out.println("Informe o tipo de conta: [1] Poupança ou [2] Corrente: ");
            String tipoConta = entrada.next();

            if (tipoConta.equals("1")) {
                conta.poupanca = true;
                System.out.println("Conta poupança.");
                opcao = 1;
            } else if (tipoConta.equals("2")) {
                conta.poupanca = false;
                System.out.println("Conta corrente.");
                opcao = 1;
            } else {
                System.out.println("Tipo de conta invalida");
            }
        } while (opcao == 0);


        System.out.println("Informe o valor do deposito: ");
        if (!entrada.hasNextDouble()) {
            System.out.println("Valor de depósito inválido");
            entrada.next();
        } else {
            double valorDeposito = entrada.nextDouble();
            if (valorDeposito <= 0) {
                System.out.println("Valor de depósito não pode ser zero ou negativo");
            } else {
                conta.valorDeposito = valorDeposito;
            }
        }

        System.out.println("Informe o valor do saque: ");
        if  (!entrada.hasNextDouble()) {
            System.out.println("Valor de saque inválido");
            entrada.next();
        } else {
            conta.valorSaque = entrada.nextDouble();
        }

        conta.exibirExtrato();

        System.out.println("Finalizando...");

    }
}
