package br.edu.infnet.rafaelvasconcelosjavaapi;

public class Cliente {

    private String nome;
    private String cpf;
    private double renda;
    private int idCliente;
    private boolean clienteAtivo;
    private Conta conta;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, String cpf) {
        this(nome);
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf, double renda) {
        this(nome, cpf);
        this.renda = renda;
    }

    public Cliente(String nome, String cpf, double renda, int idCliente) {
        this(nome, cpf, renda);
        this.idCliente = idCliente;
    }

    public Cliente(String nome, String cpf, double renda, int idCliente, boolean clienteAtivo) {
        this(nome, cpf, renda, idCliente);
        this.clienteAtivo = clienteAtivo;
    }
    public Cliente(String nome, String cpf, double renda, Conta conta) {
        this(nome, cpf, renda);
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        if (renda <= 0 || !clienteAtivo) {
            System.out.println("Cliente inelegível para realizar operações financeiras.\nFinalizando o programa.\n");
            System.exit(0);
        }
        this.renda = renda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isClienteAtivo() {
        return clienteAtivo;
    }

    public void setClienteAtivo(boolean clienteAtivo) {
        this.clienteAtivo = clienteAtivo;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return
                "\nExibindo o extrato:\n\n" +
                "Cliente: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nRenda: R$ " + getRenda() + "\n" +
                (getRenda() > 5000 ? "Empréstimo permitido." : "") +
                "\nID do cliente: " + getIdCliente() +
                (conta != null ? conta.toString() : "\nSem conta cadastrada");
    }
}
