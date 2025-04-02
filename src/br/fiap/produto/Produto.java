package br.fiap.produto;

import br.fiap.fornecedor.Fornecedor;

public class Produto {
    private String nome;
    private int quantidadeEstoque;
    private double valorUnitario;
    private Fornecedor fornecedor;

    public Produto(String nome, Fornecedor fornecedor, double valorUnitario, int quantidadeEstoque) {
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
