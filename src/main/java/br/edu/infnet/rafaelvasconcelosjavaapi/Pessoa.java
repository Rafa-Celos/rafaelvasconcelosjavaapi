package br.edu.infnet.rafaelvasconcelosjavaapi;

import interfaces.Impresso;

public class Pessoa implements Impresso {
    protected String nome;
    protected String cpf;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public String toString() {
        return "\nExibindo o extrato:\n" +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf();
    }


}
