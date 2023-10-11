package codigo;
import java.util.LinkedList;

public class Funcionario {
    private String nome;
    private LinkedList<Sapato> vendas;

    public Funcionario(String nome){
        this.nome = nome;
        vendas = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getValorVendas() {
        double valorVendas = calcularTotalVendas();
        return valorVendas;
    }

    private double calcularTotalVendas(){
        double soma = 0.00f;
        for (Sapato s : vendas) {
            soma += s.getPreco();
        }
        return soma;
    }

    private void getRelatorio(){
        System.out.printf("Relatorio funcionario/a %s\n",nome);
        System.out.printf("Total de vendas R$%.2f",getValorVendas());
    }
}
