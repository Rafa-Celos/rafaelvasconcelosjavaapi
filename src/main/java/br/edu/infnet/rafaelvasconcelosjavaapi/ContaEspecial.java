package br.edu.infnet.rafaelvasconcelosjavaapi;

import br.edu.infnet.rafaelvasconcelosjavaapi.model.domain.Conta;

public class ContaEspecial extends Conta {

    private final double chequeEspecial = 1000;


    @Override
    public double calcularSaldo() {
        System.out.print("Cheque especial: R$ ");
        return getSaldo() + chequeEspecial;
    }

    @Override
    protected boolean isContaAtiva() {
        return contaAtiva;
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
        } if (valor > (this.saldo + chequeEspecial)) {
            System.out.println("Limite do cheque especial excedido.");
            return;
        }
        this.saldo -= valor;
        System.out.printf("R$ %.2f retirado com sucesso.%n", valor);
    }
}
