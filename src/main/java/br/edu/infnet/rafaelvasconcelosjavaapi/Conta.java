package br.edu.infnet.rafaelvasconcelosjavaapi;

public class Conta {

    private int conta;
    private double saldo;
    public enum TipoConta {
        POUPANCA,
        CORRENTE
    }
    private TipoConta tipoConta;


    public Conta() {
    }

    public Conta(int conta) {
        this.conta = conta;
    }

    public Conta(int conta, TipoConta tipoConta) {
        this(conta);
        this.tipoConta = tipoConta;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void verificarEmprestimo(Cliente cliente) {
        verificarEmprestimo(cliente.getRenda());
    }

    public void verificarEmprestimo(double renda) {
    if (renda > 5000) {
        System.out.println("Empréstimo permitido.");
        }
    }

    public void depositar(double valor) {
        if (valor <= 0)
        {
            System.out.println("Valor de deposito inválido");
            return;
        }
        this.saldo += valor;
        System.out.printf("R$ %.2f depositado com sucesso.%n", valor);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor do saque deve ser maior que zero.");
            return;
        } if (valor > this.saldo) {
            System.out.println("Saldo insuficiente.");
            System.out.printf("Saldo atual: R$ %.2f%n", this.saldo);
            return;
        }
        this.saldo -= valor;
        System.out.printf("R$ %.2f retirado com sucesso.%n", valor);
    }

    private String definirTipoConta() {
        return tipoConta.name();
    }


    @Override
    public String toString() {

        return

                "\nNúmero da conta: " + getConta() +
                "\nTipo de conta:  " + definirTipoConta() +
                "\nSaldo atual: R$ " + getSaldo() +
                "\n=---------------------------------------------------------=";

    }


    /*
    Utilizar um construtor para fazer uma modificação e utilizá-lo nas chamadas.
    Ex.: public Funcionario(String nome){
            this();
            this.nome = nome.toUpperCase();

            ou fazer no getNome (pode inclusive usar na classe)
     */

}