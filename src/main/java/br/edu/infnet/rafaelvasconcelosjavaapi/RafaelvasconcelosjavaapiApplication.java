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


        int numeroConta;
        boolean numeroValido = false;
        while (!numeroValido) {
            System.out.println("Informe o número da conta: ");

            if (!entrada.hasNextInt()) {
                System.out.println("Número de conta invalido");
                entrada.next();
                continue;
            }
            numeroConta = entrada.nextInt();

            if (numeroConta <= 0) {
                System.out.println("Número de conta não pode ser zero ou negativo");
            } else {
                conta.conta = numeroConta;
                numeroValido = true;
            }
        }
        /*
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
         */

        for(int tentativas = 0; tentativas < 3; tentativas++) {
            System.out.println("Informe o tipo de conta: [1] Poupança ou [2] Corrente: ");
            String tipoConta = entrada.next();

            if (tipoConta.equals("1")) {
                conta.poupanca = true;
                System.out.println("Conta poupança.");
                break;
            } else if (tipoConta.equals("2")) {
                conta.poupanca = false;
                System.out.println("Conta corrente.");
                break;
            } else if (tentativas == 2) {
                System.out.println("Você não digitou um tipo de conta válida, o programa será encerrado.");
                System.exit(0);
            } else {
                System.out.println("Tipo de conta inválida, tente novamente.");
            }
        }

        /*
        int opcaoTipoConta = 0;
        do {
            System.out.println("Informe o tipo de conta: [1] Poupança ou [2] Corrente: ");
            String tipoConta = entrada.next();

            if (tipoConta.equals("1")) {
                conta.poupanca = true;
                System.out.println("Conta poupança.");
                opcaoTipoConta = 0;
            } else if (tipoConta.equals("2")) {
                conta.poupanca = false;
                System.out.println("Conta corrente.");
                opcaoTipoConta = 0;
            } else {
                System.out.println("Tipo de conta invalida, tente novamente.");
                opcaoTipoConta = opcaoTipoConta + 1;
                if (opcaoTipoConta == 3) {
                    System.out.println("Você não digitou um tipo de conta válido, o programa será encerrado.");
                    System.exit(0);
                }
            }
        } while (opcaoTipoConta != 0);

         */

        int opcao = 0;

        do {
            System.out.println("\nDigite uma opção: ");
            System.out.println("[1] - Depositar");
            System.out.println("[2] - Sacar");
            System.out.println("[3] - Exibir extrato");
            System.out.println("[0] - Sair");

            if (entrada.hasNextInt()) {
                opcao = entrada.nextInt();
                entrada.nextLine();
            } else {
                System.out.println("Opção inválida, digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor do deposito: ");
                    if (!entrada.hasNextDouble()) {
                        System.out.println("Valor de depósito inválido");
                        entrada.next();
                    } else {
                        double valorDeposito = entrada.nextDouble();
                        if (valorDeposito <= 0) {
                            System.out.println("Valor de depósito não pode ser zero ou negativo.");
                        } else {
                            conta.valorDeposito += valorDeposito;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Informe o valor do saque: ");
                    if (!entrada.hasNextDouble()) {
                        System.out.println("Valor de saque inválido");
                        entrada.next();
                    } else {
                        conta.valorSaque = entrada.nextDouble();
                    }
                    break;
                case 3: conta.exibirExtrato();
                    break;
                case 0:
                    System.out.println("Encerrando.");
                    break;
                default:
                    System.out.println("Opção invalida, digite uma opção válida.");
            }

        } while (opcao != 0);


        entrada.close();
        System.out.println("Finalizando...");

    }
}
