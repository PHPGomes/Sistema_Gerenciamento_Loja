package codigo;

import java.util.Scanner;

public class CentralVendas {
    private RelacaoFuncionarios relacaoFuncionarios;
    private Estoque estoque;
    private Scanner leitura;

    public CentralVendas() {
        leitura = new Scanner(System.in);
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

    /*
     * if(escolha.equals("2")){
     * String nome;
     * int codigo;
     * System.out.println("Digite o nome do funcionario que realizou a venda");
     * nome = leitura.nextLine();
     * while(!relacaoFuncionarios.tem(nome)){
     * System.out.println("Funcionario nao encontrado");
     * System.out.
     * println("Digite o nome correto do funcionario que realizou a venda");
     * nome = leitura.nextLine();
     * }
     * System.out.println("Digite o codigo do produto");
     * codigo = Integer.parseInt(leitura.nextLine());
     * realizarVenda(codigo, buscarFuncionario(nome));
     * }
     */

    public boolean tem(String nome){
        return relacaoFuncionarios.tem(nome);
    }

    private Funcionario buscarFuncionario(String nome) {
        return relacaoFuncionarios.buscarFuncionario(nome);
    }

    private void exibirEstoque() {
        System.out.println("\nEstoque Disponivel:");
        System.out.println(estoque);
    }

    public void realizarVenda(int codigo, String nome){
        associarVenda(codigo, buscarFuncionario(nome));
    }

    private void associarVenda(int codigo, Funcionario f) {
        f.adiconarVenda(estoque.getSapato(codigo));// passar o sapato para o vendedor
        estoque.removerSapato(codigo);// tirar do estoque
    }

}
