package codigo;

import java.util.Scanner;

public class GerenciadorEstoque {
    private static GerenciadorEstoque gerenciadorUnico;
    private int variavel;
    private Estoque estoque;
    private Scanner leitura;

    private GerenciadorEstoque() {
        leitura = new Scanner(System.in);
        estoque = Estoque.getIntance();
    }

    public static GerenciadorEstoque getInstance() { // Padrão de projeto Singleton
        if (gerenciadorUnico == null) {
            gerenciadorUnico = new GerenciadorEstoque();
        }
        return gerenciadorUnico;
    }

    public int getTamanhoEstoque() {
        return estoque.getTamanhoEstoque();
    }

    public String getSapatoPosicao(int posicao) {
        return estoque.getSapatoPosicao(posicao);
    }

    public String compararCodigoPosicao(int codigo, int posicao){
        return estoque.compararCodigoPosicao(codigo, posicao);
    }

    private void lerEscolha() {
        variavel = Integer.parseInt(leitura.nextLine());
        if (variavel != 1 && variavel != 2 && variavel != 3 && variavel != 4 && variavel != 5) {
            System.out.println("Escolha não compativel!\nDigite novamente: ");
            lerEscolha();
        }
    }

    private void execEscolha(int escolha) {

        if (variavel == 2) { // remover sapato
            boolean removido;
            System.out.print("Digite o codigo do produto: ");
            int codigo = Integer.parseInt(leitura.nextLine());
            removido = estoque.removerSapato(codigo);
            if (removido) {
                System.out.println("Sapato removido!\n\n");
            } else {
                System.out.println("Sapato nao encontrado!\n\n");
            }
        }

        else if (variavel == 3) { // buscar sapato
            estoque.buscarSapato();
        }

        else if (variavel == 4) {
            estoque.gerarRelatorio();// gerar relatorio
        }
    }

    public String buscarCodigo(int codigo) {
        return estoque.buscarCodigo(codigo);
    }

    public void removerSapato(int codigo) {
        estoque.removerSapato(codigo);
        estoque.gerarRelatorio();
    }

    public void adicionarSapato(int tamanho, int codigo, double preco, String tipo, String marca) {

        if (tipo.equals("1")) {
            estoque.adicionarSapato(new SapatoSocial(tamanho, codigo, marca, preco));
        }

        else if (tipo.equals("2")) {
            estoque.adicionarSapato(new SapatoCorrida(tamanho, codigo, marca, preco));
        }

        estoque.gerarRelatorio();

    }

    public boolean existeMarca(String marca){
        return estoque.existeMarca(marca);
    }

    public String compararMarcaPosicao(int pos , String Marca){
        return estoque.compararMarcaPosicao(pos , Marca);
    }

    public String getComparaSapatoPosicaoTipo(int c, String tipo){
        return estoque.getComparaSapatoPosicaoTipo(c,tipo);
    }

}
