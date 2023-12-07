package codigo;

/**
 * A classe CentralVendas representa o sistema central de vendas que gerencia funcionários, estoque e operações de venda.
 * 
 * Ela interage com a classe RelacaoFuncionarios para realizar operações relacionadas aos funcionários,
 * e com a classe Estoque para operações relacionadas ao estoque de sapatos.
 * 
 * Essa classe permite contratar e demitir funcionários, gerar relatórios de vendas e realizar operações de venda associando produtos aos funcionários.
 * 
 * @author Pedro Henrique Pigozzi Gomes;
 * @author Victor Hugo Daia Lorenzato;
 */
public class CentralVendas {

    /** Relação de funcionários no sistema. */
    private RelacaoFuncionarios relacaoFuncionarios;

    /** Estoque de sapatos disponíveis para venda. */
    private Estoque estoque;

    /**
     * Construtor que inicializa uma instância de CentralVendas, criando uma relação de funcionários e obtendo uma instância do estoque.
     */
    public CentralVendas() {
        relacaoFuncionarios = new RelacaoFuncionarios();
        estoque = Estoque.getIntance();
    }

    /**
     * Contrata um novo funcionário com o nome fornecido.
     *
     * @param nome O nome do novo funcionário a ser contratado.
     */
    public void contratarFuncionario(String nome) {
        relacaoFuncionarios.adicionarFuncionario(new Funcionario(nome));
    }

    /**
     * Demite um funcionário com o nome fornecido.
     *
     * @param nome O nome do funcionário a ser demitido.
     */
    public void demitirFuncionario(String nome) {
        relacaoFuncionarios.demitirFuncionario(nome);
    }

    /**
     * Obtém o número total de funcionários na central de vendas.
     *
     * @return O número total de funcionários.
     */
    public int numFuncionarios() {
        return relacaoFuncionarios.numFuncionarios();
    }

    /**
     * Obtém o nome do funcionário na posição especificada na lista de funcionários.
     *
     * @param p A posição do funcionário na lista.
     * @return O nome do funcionário na posição especificada.
     */
    public String getNomeFuncionarioPos(int p) {
        return relacaoFuncionarios.getNomeFuncionarioPos(p);
    }

    /**
     * Obtém o relatório do valor total vendido por um funcionário na posição especificada na lista.
     *
     * @param p A posição do funcionário na lista.
     * @return O relatório do valor total vendido pelo funcionário na posição especificada.
     */
    public String getRelatorioValorVendidoFuncionarioPos(int p) {
        return relacaoFuncionarios.getRelatorioValorVendidoFuncionarioPos(p);
    }

    /**
     * Obtém o número total de produtos vendidos por um funcionário na posição especificada na lista.
     *
     * @param c A posição do funcionário na lista.
     * @return O número total de produtos vendidos pelo funcionário na posição especificada.
     */
    public int getNumProdutosFuncionarioPos(int c) {
        return relacaoFuncionarios.getNumProdutosFuncionarioPos(c);
    }

    /**
     * Obtém a representação em string de um produto vendido por um funcionário na posição especificada na lista.
     *
     * @param pFuncionario A posição do funcionário na lista.
     * @param pProduto A posição do produto na lista de vendas do funcionário.
     * @return A representação em string do produto vendido.
     */
    public String getProdutoPosFuncionario(int pFuncionario, int pProduto) {
        return relacaoFuncionarios.getProdutoPosFuncionario(pFuncionario, pProduto);
    }

    /**
     * Verifica se um funcionário com o nome fornecido está na central de vendas.
     *
     * @param nome O nome do funcionário a ser verificado.
     * @return true se o funcionário está na central de vendas, false caso contrário.
     */
    public boolean tem(String nome){
        return relacaoFuncionarios.tem(nome);
    }

    /**
     * Busca um funcionário com o nome fornecido na lista de funcionários.
     *
     * @param nome O nome do funcionário a ser buscado.
     * @return O objeto Funcionario correspondente ao nome fornecido, ou null se não encontrado.
     */
    private Funcionario buscarFuncionario(String nome) {
        return relacaoFuncionarios.buscarFuncionario(nome);
    }

    /**
     * Realiza uma venda associando um sapato ao funcionário com o nome fornecido.
     *
     * @param codigo O código do sapato a ser vendido.
     * @param nome O nome do funcionário que realizará a venda.
     */
    public void realizarVenda(int codigo, String nome){
        associarVenda(codigo, buscarFuncionario(nome));
    }

    /**
     * Associa uma venda ao funcionário, removendo o sapato do estoque.
     *
     * @param codigo O código do sapato a ser associado à venda.
     * @param f O funcionário que realizará a venda.
     */
    private void associarVenda(int codigo, Funcionario f) {
        f.adiconarVenda(estoque.getSapato(codigo));
        estoque.removerSapato(codigo);
    }

}
