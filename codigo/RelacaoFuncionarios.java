package codigo;
import java.util.LinkedList;

public class RelacaoFuncionarios {
    LinkedList<Funcionario> listaFuncionarios;

    public RelacaoFuncionarios(){
        listaFuncionarios = new LinkedList<>();

    }

    public void adicionarFuncionario(Funcionario funcionario){
        listaFuncionarios.add(funcionario);
    }    

    public boolean demitirFuncionario(String nome){
        for (Funcionario f : listaFuncionarios) {
            if(f.getNome().equals(nome)){
                listaFuncionarios.remove(f);
                return true;
            }
        }
        return false;  //funcionario não encontrado
    }

    public int numFuncionarios(){
        return listaFuncionarios.size();
    }

    public String getNomeFuncionarioPos(int p){
        return listaFuncionarios.get(p).getNome();
    }

    public Funcionario buscarFuncionario(String nome){
        for (Funcionario f : listaFuncionarios) {
            if(f.getNome().equals(nome)){
                return f;
            }
        }
        return null;
    }

    public void exibirListaFuncionarios(){
        int num = 1;
        System.out.println("Lista funcionarios:");
        for (Funcionario f : listaFuncionarios) {
            System.out.printf("funcionario %d: ",num);
            System.out.println(f);
            num ++;
        }

    }

    public String getProdutoPosFuncionario(int pFuncionario, int pProduto){
        return listaFuncionarios.get(pFuncionario).getProdutoPos(pProduto);
    }
    

    public String getRelatorioValorVendidoFuncionarioPos(int p){
        return listaFuncionarios.get(p).relatorioValorVendido();
    }

    public int getNumProdutosFuncionarioPos(int c){
        return listaFuncionarios.get(c).getNumProdutosVendidos();
    }

    public boolean tem(String nome){
        for (Funcionario f : listaFuncionarios) {
            if(f.getNome().equals(nome)){
                return true;
            }
        }
        return false;

    }

}
