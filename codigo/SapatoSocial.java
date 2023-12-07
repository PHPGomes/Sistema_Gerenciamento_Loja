package codigo;

/**
 * A classe SapatoSocial representa um tipo especifico de sapato presete no estoque;
 * 
 * @author Pedro Henrique Pigozzi Gomes;
 * @author Victor Hugo Daia Lorenzato;
 */
public class SapatoSocial extends Sapato {

    /**
     * @param tamanho Tamanho do sapato.
     * @param codigo Código identificador do sapato.
     * @param marca Marca do sapato.
     * @param preco Preço do sapato.
     */
    public SapatoSocial(int tamanho, int codigo, String marca, double preco) {
        super(tamanho, codigo, marca, preco);
        setTipo("Social");
    }
}
