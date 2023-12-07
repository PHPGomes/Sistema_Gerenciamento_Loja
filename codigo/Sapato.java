package codigo;
/**
 * A classe Sapato representa o basico dos objetos sapato presete no estoque;
 * 
 * @author Pedro Henrique Pigozzi Gomes;
 * @author Victor Hugo Daia Lorenzato;
 */
public abstract class Sapato {

    private int tamanho;
    private int codigo;
    private double preco;
    private String marca;
    private String tipo;

    /**
     * @param tamanho Tamanho do sapato.
     * @param codigo Código identificador do sapato.
     * @param marca Marca do sapato.
     * @param preco Preço do sapato.
     */
    public Sapato(int tamanho, int codigo, String marca, double preco) {
        this.tamanho = tamanho;
        this.codigo = codigo;
        this.marca = marca;
        this.preco = preco;
    }

    /**
     * Obtém o tamanho do sapato.
     * @return O tamanho do sapato.
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Obtém o código identificador do sapato.
     *
     * @return O código identificador do sapato.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Obtém a marca do sapato.
     *
     * @return A marca do sapato.
     */
    public String getMarca() {
        return marca;
    }

    /**
     *Obtém o tipo específico do sapato.
     *
     * @return O tipo específico do sapato.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtém o preço do sapato.
     *
     * @return O preço do sapato.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o tipo específico do sapato.
     *
     * @param tipo O tipo específico do sapato.
     */
    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna uma representação em string do objeto Sapato.
     *
     * @return Uma string formatada com as informações já formatadas do sapato.
     */
    @Override
    public String toString() {
        String aux;
        aux = String.format("%5d%10s%10s%12d%7s%.2f", codigo, tipo, marca, tamanho, "R$", preco);
        return aux;
    }
}
