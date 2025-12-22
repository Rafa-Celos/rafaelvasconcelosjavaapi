package br.edu.infnet.rafaelvasconcelosjavaapi;

public final class Cliente extends Pessoa {


    private double renda;
    private int idCliente;
    private boolean clienteAtivo;
    private ContaComum conta;

    public Cliente(String nome) {
        super(nome);
    }

    public Cliente(String nome, String cpf, double renda) {
        super(nome, cpf);
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
    public Cliente(String nome, String cpf, double renda, ContaComum conta) {
        this(nome, cpf, renda);
        this.conta = conta;
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

    public void setConta(ContaComum conta) {
        this.conta = conta;
    }

    @Override
    public void imprimir() {
        super.imprimir();
    }

    @Override
    public String toString() {
        return
                super.toString() +
                "\nRenda: R$ " + getRenda() + "\n" +
                (getRenda() > 5000 ? "Empréstimo permitido." : "") +
                "\nID do cliente: " + getIdCliente() +
                (conta != null ? conta.toString() : "\nSem conta cadastrada");
    }


}
