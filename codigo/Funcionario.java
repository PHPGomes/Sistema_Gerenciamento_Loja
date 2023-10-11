package codigo;
import java.util.LinkedList;

public class Funcionario {
    private String nome;
    private double valorVendas;
    private LinkedList<Sapato> vendas;

    public Funcionario(String nome){
        this.nome = nome;
        vendas = new LinkedList<>();
        valorVendas = 0.00f;
    }

    public String getNome() {
        return nome;
    }

    public double getValorVendas() {
        valorVendas = calcularTotalVendas();


        return valorVendas;
    }

    private double calcularTotalVendas(){
        double soma = 0.00f;
        for (Sapato s : vendas) {
        //    soma += s.getPreco(); // Adicionar essa função ao sapato! getPreco() e pedir na criação do estoque e ao filtro para dar para buscar por preço
        }
        return soma;
    }
}
