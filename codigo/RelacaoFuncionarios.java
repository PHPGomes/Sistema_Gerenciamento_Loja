package codigo;

import java.util.LinkedList;

/**
 * A classe RelacaoFuncionarios representa uma coleção de funcionários e fornece operações relacionadas a eles.
 * Pode ser utilizada para gerenciar e consultar informações sobre os funcionários.
 * 
 * @author Pedro Henrique Pigozzi Gomes;
 * @author Victor Hugo Daia Lorenzato;
 */
public class RelacaoFuncionarios {
    
    /** Lista encadeada que armazena os objetos do tipo Funcionario. */
    LinkedList<Funcionario> listaFuncionarios;

    /**
     * Construtor padrão que inicializa a lista de funcionários como uma LinkedList vazia.
     */
    public RelacaoFuncionarios() {
        listaFuncionarios = new LinkedList<>();
    }

    /**
     * Adiciona um novo funcionário à lista.
     *
     * @param funcionario O funcionário a ser adicionado.
     */
    public void adicionarFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    /**
     * Demite um funcionário com base no nome.
     *
     * @param nome O nome do funcionário a ser demitido.
     * @return true se o funcionário foi demitido com sucesso, false se o funcionário não foi encontrado.
     */
    public boolean demitirFuncionario(String nome) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getNome().equals(nome)) {
                listaFuncionarios.remove(f);
                return true;
            }
        }
        return false; // funcionario não encontrado
    }

    /**
     * Retorna o número total de funcionários na lista.
     *
     * @return O número total de funcionários.
     */
    public int numFuncionarios() {
        return listaFuncionarios.size();
    }

    /**
     * Obtém o nome de um funcionário na posição especificada da lista.
     *
     * @param p A posição do funcionário na lista.
     * @return O nome do funcionário na posição especificada.
     */
    public String getNomeFuncionarioPos(int p) {
        return listaFuncionarios.get(p).getNome();
    }

    /**
     * Busca um funcionário pelo nome.
     *
     * @param nome O nome do funcionário a ser buscado.
     * @return O objeto Funcionario correspondente ao nome especificado, ou null se não encontrado.
     */
    public Funcionario buscarFuncionario(String nome) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getNome().equals(nome)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Obtém o nome do produto em uma posição específica da lista de produtos vendidos por um funcionário.
     *
     * @param pFuncionario A posição do funcionário na lista.
     * @param pProduto A posição do produto na lista de produtos vendidos pelo funcionário.
     * @return O nome do produto na posição especificada.
     */
    public String getProdutoPosFuncionario(int pFuncionario, int pProduto) {
        return listaFuncionarios.get(pFuncionario).getProdutoPos(pProduto);
    }

    /**
     * Obtém o relatório de valor vendido por um funcionário na posição especificada.
     *
     * @param p A posição do funcionário na lista.
     * @return O relatório de valor vendido pelo funcionário na posição especificada.
     */
    public String getRelatorioValorVendidoFuncionarioPos(int p) {
        return listaFuncionarios.get(p).relatorioValorVendido();
    }

    /**
     * Obtém o número total de produtos vendidos por um funcionário na posição especificada.
     *
     * @param c A posição do funcionário na lista.
     * @return O número total de produtos vendidos pelo funcionário na posição especificada.
     */
    public int getNumProdutosFuncionarioPos(int c) {
        return listaFuncionarios.get(c).getNumProdutosVendidos();
    }

    /**
     * Verifica se um funcionário com o nome especificado existe na lista.
     *
     * @param nome O nome do funcionário a ser verificado.
     * @return true se o funcionário existe na lista, false caso contrário.
     */
    public boolean tem(String nome) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}