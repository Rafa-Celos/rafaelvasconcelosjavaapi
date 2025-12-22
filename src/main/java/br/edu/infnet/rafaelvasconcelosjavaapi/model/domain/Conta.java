package br.edu.infnet.rafaelvasconcelosjavaapi.model.domain;

public abstract class Conta {
    protected int conta;
    protected double saldo;
    protected boolean contaAtiva;


    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
    protected abstract boolean isContaAtiva();

    public abstract double calcularSaldo();

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setContaAtiva(boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
    }
}
