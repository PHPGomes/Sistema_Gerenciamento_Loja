package codigo;

import java.util.LinkedList;

/**
 * A classe Funcionario representa um funcionário que realiza vendas de sapatos.
 * Cada funcionário possui um nome e uma lista de sapatos vendidos.
 * 
 * Funcionários podem adicionar vendas, calcular o valor total das vendas, gerar relatórios e fornecer informações sobre suas vendas.
 * 
 * @author Pedro Henrique Pigozzi Gomes;
 * @author Victor Hugo Daia Lorenzato;
 */
public class Funcionario {

    /** Nome do funcionário. */
    private String nome;

    /** Lista de sapatos vendidos pelo funcionário. */
    private LinkedList<Sapato> vendas;

    /**
     * Construtor que inicializa um objeto Funcionario com o nome fornecido.
     *
     * @param nome O nome do funcionário.
     */
    public Funcionario(String nome) {
        this.nome = nome;
        vendas = new LinkedList<>();
    }

    /**
     * Obtém o nome do funcionário.
     *
     * @return O nome do funcionário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o valor total das vendas realizadas pelo funcionário.
     *
     * @return O valor total das vendas.
     */
    public double getValorVendas() {
        return calcularTotalVendas();
    }

    /**
     * Adiciona uma venda de sapato à lista de vendas do funcionário.
     *
     * @param s O sapato vendido a ser adicionado.
     */
    public void adiconarVenda(Sapato s) {
        vendas.add(s);
    }

    /**
     * Calcula o valor total das vendas realizadas pelo funcionário.
     *
     * @return O valor total das vendas.
     */
    private double calcularTotalVendas() {
        double soma = 0.00f;
        for (Sapato s : vendas) {
            soma += s.getPreco();
        }
        return soma;
    }

    /**
     * Gera um relatório do valor total vendido pelo funcionário.
     *
     * @return Uma string contendo o relatório do valor total vendido.
     */
    public String relatorioValorVendido() {
        String aux = String.format("Total de vendas R$%.2f\n\n", getValorVendas());
        return aux;
    }

    /**
     * Obtém o número total de produtos vendidos pelo funcionário.
     *
     * @return O número total de produtos vendidos.
     */
    public int getNumProdutosVendidos() {
        return vendas.size();
    }

    /**
     * Obtém a representação em string de um produto vendido na posição especificada da lista.
     *
     * @param c A posição do produto vendido na lista.
     * @return A representação em string do produto vendido na posição especificada.
     */
    public String getProdutoPos(int c) {
        return vendas.get(c).toString();
    }

    /**
     * Retorna uma representação em string do objeto Funcionario.
     *
     * @return Uma string contendo o nome do funcionário.
     */
    @Override
    public String toString() {
        return getNome();
    }

}