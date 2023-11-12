package codigo;
import java.util.LinkedList;

public class RelacaoFuncionarios {
    LinkedList<Funcionario> listaFuncionarios;

    public RelacaoFuncionarios(){
        listaFuncionarios = new LinkedList<>();
        adicionarFuncionario(new Funcionario("pedro")); //para testes
        adicionarFuncionario(new Funcionario("gomes")); //para testes
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

    public void relatorioFuncionarios(){
        System.out.println("Relatorio dos funcionarios:");
        for (Funcionario f : listaFuncionarios) {
            f.getRelatorio();
            System.out.println("\n");
        }
    }

}
