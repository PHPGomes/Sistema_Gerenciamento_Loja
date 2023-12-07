package codigo;

import java.util.LinkedList;

/**
 * Representa um singleton de estoque de sapatos.
 */
public class Estoque {
    private static Estoque estoqueUnico;
    private LinkedList<Sapato> estoque;

    /**
     * Construtor privado que inicializa a lista de estoque.
     */
    private Estoque() {
        estoque = new LinkedList<>();
    }

    /**
     * Obtém a única instância da classe Estoque (singleton).
     *
     * @return A instância única da classe Estoque.
     */
    public static Estoque getIntance() {
        if (estoqueUnico == null) {
            estoqueUnico = new Estoque();
        }
        return estoqueUnico;
    }

    /**
     * Obtém o tamanho atual do estoque.
     *
     * @return O tamanho atual do estoque.
     */
    public int getTamanhoEstoque() {
        return estoque.size();
    }

    /**
     * Adiciona um sapato ao estoque.
     *
     * @param sapato O sapato a ser adicionado.
     */
    public void adicionarSapato(Sapato sapato) {
        estoque.add(sapato);
    }

    /**
     * Remove um sapato do estoque com base no código.
     *
     * @param codigo O código do sapato a ser removido.
     * @return true se o sapato foi removido com sucesso, false caso contrário.
     */
    public boolean removerSapato(int codigo) {
        for (Sapato s : estoque) {
            if (s.getCodigo() == codigo) {
                estoque.remove(s);
                return true;
            }
        }
        return false;
    }


/**
 * Busca um sapato no estoque com base no código.
 *
 * @param codigo O código do sapato a ser buscado.
 * @return Uma representação em string do sapato encontrado ou "0" se não encontrado.
 */
public String buscarCodigo(int codigo) {
    for (Sapato s : estoque) {
        if (s.getCodigo() == codigo) {
            return s.toString();
        }
    }
    return "0";
}

/**
 * Compara o código de um sapato em uma posição específica do estoque.
 *
 * @param codigo   O código a ser comparado.
 * @param posicao  A posição do sapato no estoque.
 * @return Uma representação em string do sapato se o código for igual, caso contrário, retorna "0".
 */
public String compararCodigoPosicao(int codigo, int posicao) {
    if (estoque.get(posicao).getCodigo() == codigo) {
        return estoque.get(posicao).toString();
    }
    return "0";
}

/**
 * Obtém um clone de um sapato do estoque com base no código.
 * Este método é utilizado para evitar quebrar o encapsulamento original.
 *
 * @param codigo O código do sapato a ser obtido.
 * @return Um clone do sapato encontrado ou null se não encontrado.
 */
public Sapato getSapato(int codigo) {
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

/**
 * Obtém uma representação em string do sapato em uma posição específica do estoque.
 *
 * @param pos A posição do sapato no estoque.
 * @return Uma representação em string do sapato na posição especificada.
 */
public String getSapatoPosicao(int pos) {
    return estoque.get(pos).toString();
}

/**
 * Compara a marca de um sapato em uma posição específica do estoque.
 *
 * @param pos   A posição do sapato no estoque.
 * @param marca A marca a ser comparada.
 * @return Uma representação em string do sapato se a marca for igual, caso contrário, retorna "0".
 */
public String compararMarcaPosicao(int pos, String marca) {
    if (estoque.get(pos).getMarca().equals(marca)) {
        return estoque.get(pos).toString();
    }
    return "0";
}

/**
 * Verifica se há pelo menos um sapato no estoque com a marca especificada.
 *
 * @param marca A marca a ser verificada.
 * @return true se existe pelo menos um sapato com a marca especificada, false caso contrário.
 */
public boolean existeMarca(String marca) {
    for (Sapato s : estoque) {
        if (s.getMarca().equals(marca)) {
            return true;
        }
    }
    return false;
}

/**
 * Compara o tipo de um sapato em uma posição específica do estoque.
 *
 * @param c    A posição do sapato no estoque.
 * @param tipo O tipo a ser comparado.
 * @return Uma representação em string do sapato se o tipo for igual, caso contrário, retorna "0".
 */
public String getComparaSapatoPosicaoTipo(int c, String tipo) {
    if (estoque.get(c).getTipo().equals(tipo)) {
        return estoque.get(c).toString();
    }
    return "0";
}

/**
 * Compara o preço de um sapato em uma posição específica do estoque com limites definidos.
 *
 * @param pos          A posição do sapato no estoque.
 * @param precoMaximo  O preço máximo permitido.
 * @param precoMinimo  O preço mínimo permitido.
 * @return Uma representação em string do sapato se o preço estiver dentro dos limites, caso contrário, retorna "0".
 */
public String compararPrecoPorPosicao(int pos, double precoMaximo, double precoMinimo) {
    if (estoque.get(pos).getPreco() >= precoMinimo && estoque.get(pos).getPreco() <= precoMaximo) {
        return estoque.get(pos).toString();
    }
    return "0";
}

/**
 * Verifica se há pelo menos um sapato no estoque com o código especificado.
 *
 * @param codigo O código a ser verificado.
 * @return true se existe pelo menos um sapato com o código especificado, false caso contrário.
 */
public boolean temCodigo(int codigo) {
    for (Sapato s : estoque) {
        if (s.getCodigo() == codigo) {
            return true;
        }
    }
    return false;
}


    /**
     * Substitui o método padrão toString para exibir os sapatos no estoque.
     *
     * @return Uma representação em string do estoque de sapatos.
     */
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