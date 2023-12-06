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

    public int getTamanhoEstoque(){
        return estoque.size();
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
        
        
        if(metBusca == 2){
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

    public String buscarCodigo(int codigo){

        for (Sapato s : estoque) {
            if(s.getCodigo() == codigo){
                return s.toString();
            }
        }
        return "0";
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


    public void gerarRelatorio(){
        System.out.println("Relatorio Do Estoque:");
        if(estoque.size() == 0){
            System.out.println("O Estoque esta vazio");
        }
        
        else if(estoque.size() == 1){
            System.out.println("Atualmente o estoque tem um total de 1 item\n");
            System.out.println(toString()); 
        }

        else{
            System.out.printf("Atualmente o estoque tem um total de %d itens\n\n",estoque.size());
            System.out.println(toString()); 
        }
    }

    public Sapato getSapato(int codigo){ //retorno um clone de sapato para não quebra o encapsulamento
        Sapato s2;
        for (Sapato s : estoque) {
            if (s.getCodigo() == codigo) {

                if(s.getTipo().equals("Corrida")){
                    s2 = new SapatoCorrida(s.getTamanho(), s.getCodigo(), s.getMarca(), s.getPreco());
                }
                else{
                    s2 = new SapatoSocial(s.getTamanho(), s.getCodigo(), s.getMarca(), s.getPreco());
                }
                return s2;
            }
        }
        return null;
    }

    public String getSapatoPosicao(int pos){
        Sapato s = estoque.get(pos);
        return s.toString();
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