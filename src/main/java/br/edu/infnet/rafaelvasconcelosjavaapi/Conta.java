package br.edu.infnet.rafaelvasconcelosjavaapi;

public class Conta {
    public String nome;
    public int conta;
    public double valorDeposito;
    public double valorSaque;
    public boolean poupanca;

    private double realizarDeposito() {
        return valorDeposito;
    }

    private double realizarSaque() {
        if (valorSaque < 0 || valorSaque > valorDeposito) {
            System.out.println("Saldo inválido, negativo ou insuficiente");
            return 0;
        } if (valorSaque == 0) {
            return 0;
        }
        return valorSaque;
    }

    private double calcularSaldo() {
        return valorDeposito - realizarSaque();
    }

    private String definirTipoConta(boolean poupanca) {
        if (poupanca) {
            return "Poupança";
        }
        else {
            return "Corrente";
        }
    }

    public void exibirExtrato() {

        System.out.println("Exibindo o extrato: \n");
        System.out.println("Nome do titular: " + nome);
        System.out.println("Número da conta: " + conta);
        System.out.println("Tipo de conta:  " + definirTipoConta(poupanca));
        System.out.println("\nValor do deposito: R$ " + realizarDeposito());
        System.out.println("Valor da saque: R$ " + valorSaque);
        System.out.println("Valor do saldo: R$ " + calcularSaldo());
        System.out.println("=---------------------------------------------------------=");
    }
}