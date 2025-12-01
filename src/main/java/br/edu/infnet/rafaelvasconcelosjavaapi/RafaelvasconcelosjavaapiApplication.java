package br.edu.infnet.rafaelvasconcelosjavaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class RafaelvasconcelosjavaapiApplication {

	public static void main(String[] args) {
        SpringApplication.run(RafaelvasconcelosjavaapiApplication.class, args);

        System.out.println("Iniciando...");

        Scanner entrada = new Scanner(System.in);
        Conta conta = new Conta();


        System.out.println("Informe o nome do titular da conta: ");
        String nomeCliente = entrada.nextLine();
        Cliente cliente = new Cliente(nomeCliente);

        System.out.println("Informe o CPF do titular da conta: ");
        String cpfCliente = entrada.nextLine();
        cliente.setCpf(cpfCliente);
        cliente.setClienteAtivo(true);

        double rendaCliente;
        System.out.println("Informe a renda do titular da conta: ");
        if (!entrada.hasNextDouble()) {
            System.out.println("Renda inválida.");
            entrada.next();
        } else {
            rendaCliente = entrada.nextDouble();
            cliente.setRenda(rendaCliente);
            conta.verificarEmprestimo(cliente);
        }


        int numeroConta;
        boolean numeroValido = false;
        while (!numeroValido) {
            System.out.println("Informe o número da conta com 5 dígitos: ");

            if (!entrada.hasNextInt()) {
                System.out.println("Número de conta invalido");
                entrada.next();
                continue;
            }

            numeroConta = entrada.nextInt();
            if (numeroConta <= 0) {
                System.out.println("Número de conta não pode ser zero ou negativo");
                continue;
            }

            String contaStr = String.valueOf(numeroConta);

            if (contaStr.length() != 5) {
                System.out.println("A conta deve ter exatamente 5 dígitos.");
                continue;
            }

            conta.setConta(numeroConta);
            numeroValido = true;

        }

        int id;
        Random gerador = new Random();
        id = gerador.nextInt(100000);
        cliente.setIdCliente(id);


        for(int tentativas = 0; tentativas < 3; tentativas++) {
            System.out.println("Informe o tipo de conta: [1] Poupança ou [2] Corrente: ");
            String tipoConta = entrada.next();

            if (tipoConta.equals("1")) {
                conta.setTipoConta(Conta.TipoConta.POUPANCA);
                System.out.println("Conta poupança.");
                break;
            } else if (tipoConta.equals("2")) {
                conta.setTipoConta(Conta.TipoConta.CORRENTE);
                System.out.println("Conta corrente.");
                break;
            } else if (tentativas == 2) {
                System.out.println("Você não digitou um tipo de conta válida, o programa será encerrado.");
                System.exit(0);
            } else {
                System.out.println("Tipo de conta inválida, tente novamente.");
            }
        }
        cliente.setConta(conta);

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
                        conta.depositar(entrada.nextDouble());
                    }
                    break;
                case 2:
                    System.out.println("Informe o valor do saque: ");
                    if (!entrada.hasNextDouble()) {
                        System.out.println("Valor de saque inválido");
                        entrada.next();
                    } else {
                        conta.sacar(entrada.nextDouble());
                    }
                    break;
                case 3:
                    System.out.println(cliente.toString());
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
