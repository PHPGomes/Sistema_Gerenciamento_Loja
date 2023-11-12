package codigo;

import java.util.Scanner;

public class Gerenciador {
   private GerenciadorEstoque gerenciadorEstoque;
   private CentralVendas centralVendas;
   private Scanner leitura;
    

   public Gerenciador(){
        gerenciadorEstoque =  GerenciadorEstoque.getInstance();
        centralVendas = new CentralVendas();  
        leitura = new Scanner(System.in);     
   }
    

    public void inciar(){
        String escolha = "";
        while (!escolha.equals("3")) {
            while(!escolha.equals("1")  && !escolha.equals("2")){
                System.out.println("[1] Gerenciar estoque");
                System.out.println("[2] Realizar vendas");
                System.out.println("[3] Sair");
                escolha = leitura.nextLine();
                }
            execEscolha(escolha);
            escolha = "";
            }
    }

    private void execEscolha(String escolha){
        if(escolha.equals("1")){
            gerenciadorEstoque.iniciar();
        }
        else if(escolha.equals("2")){
            centralVendas.inciar();
        }

    }
}

