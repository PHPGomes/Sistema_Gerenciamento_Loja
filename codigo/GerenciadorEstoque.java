package codigo;
import java.util.Scanner;

public class GerenciadorEstoque {
    private static GerenciadorEstoque gerenciadorUnico;
    private int variavel;
    private Estoque estoque;
    private Scanner leitura;


    private GerenciadorEstoque(){
        leitura = new Scanner(System.in);
        estoque = Estoque.getIntance();
    }

    public static GerenciadorEstoque getInstance(){ //Padrão de projeto Singleton
        if(gerenciadorUnico == null){
            gerenciadorUnico = new GerenciadorEstoque();
        }
        return gerenciadorUnico;
    }
    
    public void iniciar(){
        variavel = 0;
        while(variavel != 5){
            exibirMenu();
            lerEscolha();
            execEscolha(variavel);
        }  
    }


    private void exibirMenu(){
        System.out.println("Escolha uma opcao:");
        System.out.println("[1] Adicionar Sapato");
        System.out.println("[2] Remover Sapato");
        System.out.println("[3] Buscar Sapato");
        System.out.println("[4] Gerar Relatorio Do Estoque");
        System.out.println("[5] Sair");
    }

    private void lerEscolha(){
        variavel = Integer.parseInt(leitura.nextLine());
        if(variavel != 1 && variavel != 2 && variavel != 3 && variavel != 4 && variavel != 5){
            System.out.println("Escolha não compativel!\nDigite novamente: ");
            lerEscolha();
        }
    }

    private void execEscolha(int escolha){
        if(variavel == 1){ // adicionar sapato
            adicionarSapato();
        }

        else if(variavel == 2){ // remover sapato
            boolean removido;
            System.out.print("Digite o codigo do produto: ");
            int codigo = Integer.parseInt(leitura.nextLine());
            removido = estoque.removerSapato(codigo);
            if(removido){
                System.out.println("Sapato removido!\n\n");
            }
            else{
                System.out.println("Sapato nao encontrado!\n\n");
            }
        }

        else if(variavel == 3){ //buscar sapato
            estoque.buscarSapato();
        }

        else if(variavel == 4){
            estoque.gerarRelatorio();//gerar relatorio
        }
    }

    public void adicionarSapato(){
        int tamanho, codigo;
        double preco;
        String tipo, marca;
        System.out.print("\nDigite a marca: ");
        marca = leitura.nextLine();
        System.out.print("\nDigite o tamanho: ");
        tamanho = Integer.parseInt(leitura.nextLine());
        System.out.print("\nDigite o preco: ");
        preco = Double.parseDouble(leitura.nextLine());
        System.out.print("\nDigite o codigo do produto: ");
        codigo = Integer.parseInt(leitura.nextLine());
        System.out.println("\nEscolha o tipo do produto:");
        System.out.println("[1] Sapato Social");
        System.out.println("[2] Sapato de Corrida");
        tipo = leitura.nextLine();

        if(tipo.equals("1")){
            estoque.adicionarSapato(new SapatoSocial(tamanho, codigo, marca,preco));
        }

        else if(tipo.equals("2")){
            estoque.adicionarSapato(new SapatoCorrida(tamanho, codigo, marca,preco));
        }
    }

    

}
