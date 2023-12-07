package codigo;

/**
 * A classe GerenciadorEstoque é responsável por gerenciar operações relacionadas ao estoque de sapatos.
 * É implementada como um singleton para garantir uma única instância do gerenciador de estoque.
 * 
 * O gerenciador de estoque utiliza a classe Estoque para realizar operações no estoque de sapatos.
 * 
 * @author Pedro Henrique Pigozzi Gomes;
 * @author Victor Hugo Daia Lorenzato;
 */
public class GerenciadorEstoque {

    /** Instância única do GerenciadorEstoque (Singleton). */
    private static GerenciadorEstoque gerenciadorUnico;

    /** Referência para a instância única da classe Estoque. */
    private Estoque estoque;

    /**
     * Construtor privado para garantir que apenas uma instância seja criada (Singleton).
     * Inicializa a instância do estoque.
     */
    private GerenciadorEstoque() {
        estoque = Estoque.getIntance();
    }

    /**
     * Obtém a instância única do GerenciadorEstoque.
     *
     * @return A instância única do GerenciadorEstoque.
     */
    public static GerenciadorEstoque getInstance() { 
        if (gerenciadorUnico == null) {
            gerenciadorUnico = new GerenciadorEstoque();
        }
        return gerenciadorUnico;
    }

    /**
     * Obtém o tamanho total do estoque de sapatos.
     *
     * @return O tamanho total do estoque.
     */
    public int getTamanhoEstoque() {
        return estoque.getTamanhoEstoque();
    }

    /**
     * Obtém a representação em string de um sapato na posição especificada do estoque.
     *
     * @param posicao A posição do sapato no estoque.
     * @return A representação em string do sapato na posição especificada.
     */
    public String getSapatoPosicao(int posicao) {
        return estoque.getSapatoPosicao(posicao);
    }

    /**
     * Compara o código de um sapato na posição especificada do estoque com um código fornecido.
     *
     * @param codigo O código a ser comparado.
     * @param posicao A posição do sapato no estoque.
     * @return Uma string indicando a comparação.
     */
    public String compararCodigoPosicao(int codigo, int posicao){
        return estoque.compararCodigoPosicao(codigo, posicao);
    }

    /**
     * Busca um sapato no estoque com base no código fornecido.
     *
     * @param codigo O código do sapato a ser buscado.
     * @return Uma string representando o sapato com o código fornecido, ou null se não encontrado.
     */
    public String buscarCodigo(int codigo) {
        return estoque.buscarCodigo(codigo);
    }

    /**
     * Remove um sapato do estoque com base no código fornecido.
     *
     * @param codigo O código do sapato a ser removido.
     */
    public void removerSapato(int codigo) {
        estoque.removerSapato(codigo);
    }

    /**
     * Adiciona um novo sapato ao estoque com base nos parâmetros fornecidos.
     *
     * @param tamanho O tamanho do sapato.
     * @param codigo O código do sapato.
     * @param preco O preço do sapato.
     * @param tipo O tipo do sapato (1 para SapatoSocial, 2 para SapatoCorrida).
     * @param marca A marca do sapato.
     */
    public void adicionarSapato(int tamanho, int codigo, double preco, String tipo, String marca) {
        if (tipo.equals("1")) {
            estoque.adicionarSapato(new SapatoSocial(tamanho, codigo, marca, preco));
        } else if (tipo.equals("2")) {
            estoque.adicionarSapato(new SapatoCorrida(tamanho, codigo, marca, preco));
        }
    }

    /**
     * Verifica se existe algum sapato com a marca especificada no estoque.
     *
     * @param marca A marca a ser verificada.
     * @return true se existe algum sapato com a marca, false caso contrário.
     */
    public boolean existeMarca(String marca){
        return estoque.existeMarca(marca);
    }

    /**
     * Compara a marca de um sapato na posição especificada do estoque com uma marca fornecida.
     *
     * @param pos A posição do sapato no estoque.
     * @param Marca A marca a ser comparada.
     * @return Uma string indicando a comparação.
     */
    public String compararMarcaPosicao(int pos , String Marca){
        return estoque.compararMarcaPosicao(pos , Marca);
    }

    /**
     * Obtém a comparação de um sapato na posição especificada do estoque com base no tipo fornecido.
     *
     * @param c A posição do sapato no estoque.
     * @param tipo O tipo do sapato.
     * @return Uma string indicando a comparação.
     */
    public String getComparaSapatoPosicaoTipo(int c, String tipo){
        return estoque.getComparaSapatoPosicaoTipo(c,tipo);
    }

    /**
     * Compara o preço de um sapato na posição especificada do estoque com um intervalo de preços.
     *
     * @param pos A posição do sapato no estoque.
     * @param precoMaximo O preço máximo a ser comparado.
     * @param precoMinimo O preço mínimo a ser comparado.
     * @return Uma string representando ou um objeto do tipo sapato ou "0" representando
     *  que o sapato não se encaixa nos parametros de preço
     */
    public String compararPrecoPorPosicao(int pos, double precoMaximo, double precoMinimo){
        return estoque.compararPrecoPorPosicao( pos, precoMaximo, precoMinimo);
    }

    /**
     * Verifica se existe algum sapato com o código especificado no estoque.
     *
     * @param codigo O código a ser verificado.
     * @return true se existe algum sapato com o código, false caso contrário.
     */
    public boolean temCodigo(int codigo){
        return estoque.temCodigo(codigo);
    }
}
