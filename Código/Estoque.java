package Código;
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
        System.out.println("[5] Todos");
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
            System.out.println(toString());
        }
    }

    public void buscarCodigo(){
        int codigo;
        System.out.println("Digite o codigo:");
        codigo = Integer.parseInt(leitura.nextLine());
        System.out.println("Codigo     Tipo     Marca     Tamanho");
        for (Sapato s : estoque) {
            if(s.getCodigo() == codigo){
                System.out.println(s.toString());
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
        System.out.println("Codigo     Tipo     Marca     Tamanho");
        for (Sapato s : estoque) {
            if(s.getTipo().equals(tipo)){
                System.out.println(s.toString());
            }
        }
    }

    public void buscarMarca(){
        String marca;
        System.out.println("Digite a marca:");
        marca = leitura.nextLine();
        System.out.println("Codigo     Tipo     Marca     Tamanho");
        for (Sapato s : estoque) {
            if(s.getMarca().equals(marca)){
                System.out.println(s.toString());
            }
        }
    }

    public void buscarTamanho(){
        int tamanho;
        System.out.println("Digite o tamanho:");
        tamanho = Integer.parseInt(leitura.nextLine());
        System.out.println("Codigo     Tipo     Marca     Tamanho");
        for (Sapato s : estoque) {
            if(s.getTamanho() == tamanho){
                System.out.println(s.toString());
            }
        }
    }


    @Override
    public String toString(){
        String aux;
        aux = "Codigo     Tipo     Marca     Tamanho\n";
        for (Sapato s : estoque) {
            aux = aux + s + "\n";
        }
       return aux;
    }
    
}