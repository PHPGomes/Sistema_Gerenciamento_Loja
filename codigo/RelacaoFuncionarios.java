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




}
