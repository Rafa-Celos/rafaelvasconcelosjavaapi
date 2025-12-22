package br.edu.infnet.rafaelvasconcelosjavaapi;

import br.edu.infnet.rafaelvasconcelosjavaapi.model.domain.Conta;
import interfaces.Impresso;
import org.springframework.lang.NonNull;

public class ContaComum extends Conta implements Impresso{

    public enum TipoConta {
        POUPANCA,
        CORRENTE
    }
    public TipoConta tipoConta;

    public ContaComum() {
    }

    public ContaComum(int conta) {
        this.conta = conta;
    }

    public ContaComum(int conta, TipoConta tipoConta) {
        this(conta);
        this.tipoConta = tipoConta;
    }

    public int getConta() {
        return super.getConta();
    }

    public void setConta(int conta) {
        super.setConta(conta);
    }

    public double getSaldo() {
        return super.getSaldo();
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    protected boolean isContaAtiva() {
        return contaAtiva;
    }

    public void setContaAtiva(boolean contaAtiva) {
        super.setContaAtiva(contaAtiva);
    }

    @Override
    public double calcularSaldo() {
        System.out.print("Saldo conta comum: R$ ");
        return getSaldo();
    }

    // Método sobrecarregado
    public void verificarEmprestimo(@NonNull Cliente cliente) {
        verificarEmprestimo(cliente.getRenda());
    }

    public void verificarEmprestimo(double renda) {
    if (renda > 5000) {
        System.out.println("Empréstimo permitido.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0 && !this.isContaAtiva())
        {
            System.out.println("Valor de deposito inválido ou conta inativa.");
            return;
        }
        this.saldo += valor;
        System.out.printf("R$ %.2f depositado com sucesso.%n", valor);
    }

    @Override
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
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        return

                "\nNúmero da conta: " + getConta() +
                "\nTipo de conta:  " + definirTipoConta() +
                "\nSaldo atual: R$ " + getSaldo() +
                "\n=---------------------------------------------------------=";

    }
}