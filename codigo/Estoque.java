package codigo;
import java.util.LinkedList;
import java.util.Scanner;

public class Estoque {
    private static Estoque estoqueUnico;
    private LinkedList<Sapato> estoque;
    Scanner leitura;

    private Estoque(){
        estoque = new LinkedList<>();
        leitura = new Scanner(System.in);
    }

    public static Estoque getIntance(){ //Padrão de projeto Singleton
        if(estoqueUnico == null){
            estoqueUnico = new Estoque();
        }
        return estoqueUnico;
    }

    public void adicionarSapato(Sapato sapato){
        estoque.add(sapato);
        System.out.println("Sapato adicionado! \n\n");
    }

    public boolean removerSapato(int codigo){
        for (Sapato s : estoque) {
            if(s.getCodigo() == codigo){
                estoque.remove(s);
                return true;
            }
        }
        return false;
    }

    public void buscarSapato(){
        int metBusca;
        System.out.println("Escolha um metodo de busca:");
        System.out.println("[1] Codigo");
        System.out.println("[2] Tipo");
        System.out.println("[3] Marca");
        System.out.println("[4] Tamanho");
        System.out.println("[5] Faixa de Preco");
        System.out.println("[6] Todos");
        metBusca = Integer.parseInt(leitura.nextLine());
        
        if(metBusca == 1){
            buscarCodigo();
        }

        else if(metBusca == 2){
            buscarTipo();
        }

        else if(metBusca == 3){
            buscarMarca();
        }

        else if(metBusca == 4){
            buscarTamanho();
        }

        else if(metBusca == 5){
            buscarPreco();
        }

        else if(metBusca == 6){
            System.out.println(toString());
        }
    }

    public void buscarCodigo(){
        int codigo;
        System.out.print("Digite o codigo: ");
        codigo = Integer.parseInt(leitura.nextLine());
        System.out.println("Codigo     Tipo     Marca     Tamanho     Preco");
        for (Sapato s : estoque) {
            if(s.getCodigo() == codigo){
                System.out.println(s);
            }
        }
    }

    public void buscarTipo(){
        String tipo = "";
        int escolha;
        System.out.println("Escolha o tipo:");
        System.out.println("[1] Social");
        System.out.println("[2] Corrida");
        escolha = Integer.parseInt(leitura.nextLine());
        if(escolha == 1){
            tipo = "Social";
        }
        else if(escolha == 2){
            tipo = "Corrida";
        }
        System.out.println("Codigo     Tipo     Marca     Tamanho     Preco");
        for (Sapato s : estoque) {
            if(s.getTipo().equals(tipo)){
                System.out.println(s);
            }
        }
    }

    public void buscarMarca(){
        String marca;
        System.out.print("Digite a marca:  ");
        marca = leitura.nextLine();
        System.out.println("Codigo     Tipo     Marca     Tamanho     Preco");
        for (Sapato s : estoque) {
            if(s.getMarca().equals(marca)){
                System.out.println(s);
            }
        }
    }

    public void buscarTamanho(){
        int tamanho;
        System.out.print("Digite o tamanho: ");
        tamanho = Integer.parseInt(leitura.nextLine());
        System.out.println("Codigo     Tipo     Marca     Tamanho     Preco");
        for (Sapato s : estoque) {
            if(s.getTamanho() == tamanho){
                System.out.println(s);
            }
        }
    }


    public void buscarPreco(){
        double precoMinimo, precoMaximo;
        System.out.print("Digite o preco minimo: ");
        precoMinimo = Double.parseDouble(leitura.nextLine());
        System.out.print("Digite o preco maximo: ");
        precoMaximo = Double.parseDouble(leitura.nextLine());
        System.out.println("Codigo     Tipo     Marca     Tamanho     Preco");
        for (Sapato s : estoque) {
            if(s.getPreco() >= precoMinimo && s.getPreco() <= precoMaximo){
                System.out.println(s);
            }
        }
    }

    @Override
    public String toString(){
        String aux;
        aux = "Codigo     Tipo     Marca     Tamanho     Preco\n";
        for (Sapato s : estoque) {
            aux = aux + s + "\n";
        }
       return aux;
    }
    
}