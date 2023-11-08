package codigo;
import java.util.LinkedList; 

public class CentralVendas {
    private RelacaoFuncionarios relacaoFuncionarios;
    private Estoque estoque;

    public CentralVendas(){
        relacaoFuncionarios = new RelacaoFuncionarios();
        estoque = Estoque.getIntance();
    }

    
    
}
