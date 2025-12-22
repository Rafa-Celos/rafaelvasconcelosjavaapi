package br.edu.infnet.rafaelvasconcelosjavaapi;

import java.util.ArrayList;
import java.util.List;

public final class Funcionario extends Pessoa {

    private int idFuncionario;
    private final List<Integer> contasEncerradas = new ArrayList<Integer>();

    public Funcionario(String nome) {
        super(nome);
    }

    public Funcionario(String nome, String cpf, int idFuncionario) {
        super(nome);
        this.cpf = cpf;
        this.idFuncionario = idFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public List<Integer> getContasEncerradas() {
        return contasEncerradas;
    }

    public void encerrarConta(int numeroConta) {
        contasEncerradas.add(numeroConta);
        System.out.println("Conta " + numeroConta + " encerrada com sucesso.");
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setCpf(String cpf) {
        super.setCpf(cpf);
    }

    @Override
    public String getCpf() {
        return super.getCpf();
    }

    @Override
    public void imprimir() {
        if (contasEncerradas.isEmpty()) {
            System.out.println("Nenhuma conta encerrada.");
        } else {
            exibirContasEncerradas();
        }
        System.out.println(this.toString());
    }

    public void exibirContasEncerradas() {
        for(Integer c : contasEncerradas){
            System.out.println(c);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nID do funcionário: " + idFuncionario;
    }
}
