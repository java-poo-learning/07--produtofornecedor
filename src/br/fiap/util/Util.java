package br.fiap.util;
import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;


public class Util {
    private Produto [] produto = new Produto[5];
    private Fornecedor [] fornecedor = new Fornecedor[5];
    private int idxProduto = 0;
    private int idxFornecedor = 0;

    //método para exibir o menu de opcoes
    public void menu() {
        int opcao;
        String msg = "1.Cadastrar produto\n2. Pesquisar produto\n" +
                "3.Pesquisar fornecedor\n4. Finalizar";
        while(true) {
            opcao = parseInt(showInputDialog(msg));
            if (opcao == 4) {
                return;
            }
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisarFornecedor();
                    break;
                default:
                    showInputDialog(null, "Opcao inválida");

            }
        }

    }

    private void pesquisar() {
        Fornecedor fornecedor = pesquisarFornecedor();
        String msg = " ";
        if (fornecedor != null) {
            msg += "Fornecedor : " + fornecedor.getNome() + "\n";
            msg += "CNPJ: " + fornecedor.getCnpj() + "\n";
            showMessageDialog(null, msg);
        }
    }

    private void cadastrarProduto() {
       String nome;
       int quantidadeEstoque;
       double valorUnitario;

        Fornecedor fornecedor = pesquisarFornecedor();
        if (fornecedor==null){
            fornecedor=cadastrarFornecedor();
        }
        nome = showInputDialog("Nome do produto:");
        quantidadeEstoque =parseInt(showInputDialog("Quantidade em estoque"));
        valorUnitario=parseDouble(showInputDialog("Valor unitário:"));
        produto[idxProduto++] = new Produto(nome, fornecedor, valorUnitario, quantidadeEstoque);

    }

    private Fornecedor cadastrarFornecedor(){
        Fornecedor fornecedor = null;
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor: "));
        String nome = showInputDialog("Nome do fornecedor: ");
        fornecedor = new Fornecedor(nome, cnpj);
        this.fornecedor [idxFornecedor++] = fornecedor;
        return fornecedor;



    }
    private void pesquisarProduto() {
        DecimalFormat df = new DecimalFormat("0.00");
        String msg = "Produto não cadastrado";
        String nome = showInputDialog("Nome do produto");
        for (int i = 0; i < idxProduto; i++) {

            if (produto[i].getNome().equalsIgnoreCase(nome)) {
                msg = "";
                msg+= "Nome do produto: " + nome + "\n";
                msg+= "Valor unitario: " + df.format(produto[i].getValorUnitario()) + "\n";
                msg+= "Nome do fornecedor " + produto[i].getFornecedor().getNome() + "\n";

            }
        }
        showMessageDialog(null, msg);


    }
    private Fornecedor pesquisarFornecedor() {
        long cnpj= parseLong(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i < idxFornecedor; i++) {
            if (fornecedor [i].getCnpj() == cnpj) {
                return fornecedor [i];

            }
        }
        showInputDialog(null, "CNPJ" + cnpj + " não cadastrado");
        return null;

    }
}
