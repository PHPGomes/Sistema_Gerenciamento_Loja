package codigo;

import java.util.Scanner;

public class Gerenciador {
   private GerenciadorEstoque gerenciadorEstoque;
   private CentralVendas centralVendas;
   private Scanner leitura;
   private String escolha;
    

   public Gerenciador(){
        gerenciadorEstoque =  GerenciadorEstoque.getInstance();
        centralVendas = new CentralVendas();  
        leitura = new Scanner(System.in);     
   }
    

    public void inciar(){
        escolha = "";
        while (!escolha.equals("3")) {
            while(!escolha.equals("1")  && !escolha.equals("2") && !escolha.equals("3")){
                System.out.println("[1] Gerenciar estoque");
                System.out.println("[2] Realizar vendas");
                System.out.println("[3] Sair");
                escolha = leitura.nextLine();
                }
            execEscolha(escolha);
            
            }
    }

    private void execEscolha(String opc){
        if(opc.equals("1")){
            escolha = "";
            gerenciadorEstoque.iniciar();
            
            
        }
        else if(opc.equals("2")){
            escolha = "";
            centralVendas.inciar();
            
            
        }

    }
}

