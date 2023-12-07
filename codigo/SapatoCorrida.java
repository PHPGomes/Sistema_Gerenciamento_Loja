package codigo;

/**
 * A classe SapatoCorrida representa um tipo especifico de sapato presete no estoque;
 * 
 * @author Pedro Henrique Pigozzi Gomes;
 * @author Victor Hugo Daia Lorenzato;
 */
public class SapatoCorrida extends Sapato {

    /**
     * @param tamanho Tamanho do sapato.
     * @param codigo Código identificador do sapato.
     * @param marca Marca do sapato.
     * @param preco Preço do sapato.
     */
    public SapatoCorrida(int tamanho, int codigo, String marca, double preco) {
        super(tamanho, codigo, marca, preco);
        setTipo("Corrida");
    }

}
