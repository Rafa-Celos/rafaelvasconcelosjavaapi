package br.edu.infnet.rafaelvasconcelosjavaapi;

import br.edu.infnet.rafaelvasconcelosjavaapi.model.domain.Conta;
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
        ContaComum conta = new ContaComum();

        Conta[] c = new Conta[2];
        c[0] = conta;
        c[1] = new ContaEspecial();


        System.out.println("Bem vindo ao sistema de gerenciamento de contas.");

        int operacao;
        final int MAX_ID = 10000;
        final int MAX_TENTATIVAS = 3;

        System.out.println("Informe o tipo de operação que deseja realizar:");
        System.out.println("[1] - Administrar sistema");
        System.out.println("[2] - Operar conta");

        while (!entrada.hasNextInt()) {
            System.out.println("Opção inválida. Digite 1 ou 2.");
            entrada.next();
        }
        operacao = entrada.nextInt();
        entrada.nextLine();

        if (operacao == 1) {

            System.out.println("Informe o nome do funcionário:");
            String nomeFuncionario = entrada.nextLine();

            System.out.println("Informe o CPF do funcionário:");
            String cpfFuncionario = entrada.nextLine();

            int idFuncionario = new Random().nextInt(MAX_ID);
            Funcionario funcionario = new Funcionario(nomeFuncionario, cpfFuncionario, idFuncionario);

            int opcaoAdmin;

            do {
                System.out.println("\nMenu administrativo:");
                System.out.println("[1] - Encerrar conta");
                System.out.println("[0] - Sair");

                opcaoAdmin = Integer.parseInt(entrada.nextLine());

                if (opcaoAdmin == 1) {

                    int numeroConta;
                    while (true) {
                        System.out.println("Informe o número da conta (5 dígitos):");
                        String entradaConta = entrada.nextLine();

                        if (entradaConta.length() == 5) {
                            numeroConta = Integer.parseInt(entradaConta);
                            break;
                        }
                        System.out.println("Número de conta inválido.");
                    }

                    System.out.println("Confirma o encerramento da conta " + numeroConta + "? (S/N)");
                    String confirmacao = entrada.nextLine();

                    if (confirmacao.equalsIgnoreCase("S")) {
                        funcionario.encerrarConta(numeroConta);
                    } else {
                        System.out.println("Operação cancelada.");
                    }
                }

            } while (opcaoAdmin != 0);

            System.out.println("\nContas encerradas:");
            funcionario.imprimir();

            System.out.println("\nSistema administrativo encerrado.");
            System.exit(0);

        } else if (operacao == 2) {

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
            id = gerador.nextInt(MAX_ID);
            cliente.setIdCliente(id);


            for (int tentativas = 0; tentativas < MAX_TENTATIVAS; tentativas++) {
                System.out.println("Informe o tipo de conta: [1] Poupança ou [2] Corrente: ");
                String tipoConta = entrada.next();

                if (tipoConta.equals("1")) {
                    conta.setTipoConta(ContaComum.TipoConta.POUPANCA);
                    System.out.println("Conta poupança.");
                    break;
                } else if (tipoConta.equals("2")) {
                    conta.setTipoConta(ContaComum.TipoConta.CORRENTE);
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
                System.out.println("[3] - Consultar saldo");
                System.out.println("[4] - Exibir extrato");
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
                        for (Conta contas : c) {
                            System.out.println(contas.calcularSaldo());
                        }
                        break;
                    case 4:
                        System.out.println(cliente.toString());
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção invalida, digite uma opção válida.");
                }

            } while (opcao != 0);


            entrada.close();
            System.out.println("Finalizando...");

        }
    }
}
