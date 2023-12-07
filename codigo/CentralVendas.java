package codigo;

import java.util.Scanner;

public class CentralVendas {
    private RelacaoFuncionarios relacaoFuncionarios;
    private Estoque estoque;

    public CentralVendas() {
        relacaoFuncionarios = new RelacaoFuncionarios();
        estoque = Estoque.getIntance();
    }

    public void contratarFuncionario(String nome) {
        relacaoFuncionarios.adicionarFuncionario(new Funcionario(nome));
        relacaoFuncionarios.exibirListaFuncionarios();
    }

    public void demitirFuncionario(String nome) {
        relacaoFuncionarios.demitirFuncionario(nome);
        relacaoFuncionarios.exibirListaFuncionarios();
    }

    public int numFuncionarios() {
        return relacaoFuncionarios.numFuncionarios();
    }

    public String getNomeFuncionarioPos(int p) {
        return relacaoFuncionarios.getNomeFuncionarioPos(p);
    }

    public String getRelatorioValorVendidoFuncionarioPos(int p) {
        return relacaoFuncionarios.getRelatorioValorVendidoFuncionarioPos(p);
    }

    public int getNumProdutosFuncionarioPos(int c) {
        return relacaoFuncionarios.getNumProdutosFuncionarioPos(c);
    }

    public String getProdutoPosFuncionario(int pFuncionario, int pProduto) {
        return relacaoFuncionarios.getProdutoPosFuncionario(pFuncionario, pProduto);
    }


    public boolean tem(String nome){
        return relacaoFuncionarios.tem(nome);
    }

    private Funcionario buscarFuncionario(String nome) {
        return relacaoFuncionarios.buscarFuncionario(nome);
    }

    
    public void realizarVenda(int codigo, String nome){
        associarVenda(codigo, buscarFuncionario(nome));
    }

    private void associarVenda(int codigo, Funcionario f) {
        f.adiconarVenda(estoque.getSapato(codigo));
        estoque.removerSapato(codigo);
    }

}
