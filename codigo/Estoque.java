package codigo;

import java.util.LinkedList;

public class Estoque {
    private static Estoque estoqueUnico;
    private LinkedList<Sapato> estoque;

    private Estoque() {
        estoque = new LinkedList<>();
    }

    public static Estoque getIntance() { // Padrão de projeto Singleton
        if (estoqueUnico == null) {
            estoqueUnico = new Estoque();
        }
        return estoqueUnico;
    }

    public int getTamanhoEstoque() {
        return estoque.size();
    }

    public void adicionarSapato(Sapato sapato) {
        estoque.add(sapato);
    }

    public boolean removerSapato(int codigo) {
        for (Sapato s : estoque) {
            if (s.getCodigo() == codigo) {
                estoque.remove(s);
                return true;
            }
        }
        return false;
    }


    public String buscarCodigo(int codigo) {
        for (Sapato s : estoque) {
            if (s.getCodigo() == codigo) {
                return s.toString();
            }
        }
        return "0";
    }


    public String compararCodigoPosicao(int codigo, int posicao) {
        if (estoque.get(posicao).getCodigo() == codigo) {
            return estoque.get(posicao).toString();
        }
        return "0";
    }

    public Sapato getSapato(int codigo) { // retorno um clone de sapato para não quebra o encapsulamento
        Sapato s2;
        for (Sapato s : estoque) {
            if (s.getCodigo() == codigo) {

                if (s.getTipo().equals("Corrida")) {
                    s2 = new SapatoCorrida(s.getTamanho(), s.getCodigo(), s.getMarca(), s.getPreco());
                } else {
                    s2 = new SapatoSocial(s.getTamanho(), s.getCodigo(), s.getMarca(), s.getPreco());
                }
                return s2;
            }
        }
        return null;
    }

    public String getSapatoPosicao(int pos) {
        return estoque.get(pos).toString();
    }


    public String compararMarcaPosicao(int pos , String Marca){
        if(estoque.get(pos).getMarca().equals(Marca)){
            return estoque.get(pos).toString();
        }
        return "0";
    }

    public boolean existeMarca(String marca){
        for (Sapato s : estoque) {
            if(s.getMarca().equals(marca)){
                return true;
            }
        }
        return false;
    }

    public String getComparaSapatoPosicaoTipo(int c, String tipo){
        if(estoque.get(c).getTipo().equals(tipo)){
            return estoque.get(c).toString();
        }
        return "0";
    }



    public String compararPrecoPorPosicao(int pos, double precoMaximo, double precoMinimo){
        if(estoque.get(pos).getPreco() >= precoMinimo && estoque.get(pos).getPreco() <= precoMaximo ){
            return estoque.get(pos).toString();
        }
        return "0";
    }

    public boolean temCodigo(int codigo){
        for (Sapato s : estoque) {
            if(s.getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        String aux;
        aux = "Codigo     Tipo     Marca     Tamanho     Preco\n";
        for (Sapato s : estoque) {
            aux = aux + s + "\n";
        }
        return aux;
    }

}