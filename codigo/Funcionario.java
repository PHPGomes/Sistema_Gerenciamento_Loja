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
        return calcularTotalVendas();
    }

    public void adiconarVenda(Sapato s){
        vendas.add(s);
    }

    private double calcularTotalVendas(){
        double soma = 0.00f;
        for (Sapato s : vendas) {
            soma += s.getPreco();
        }
        return soma;
    }

    public void getRelatorio(){
        System.out.printf("Relatorio funcionario/a %s\n",nome);
        System.out.printf("Total de vendas R$%.2f\n",getValorVendas());
        System.out.println("Produtos vendidos: ");
        System.out.println("Codigo     Tipo     Marca     Tamanho     Preco\n");
        for (Sapato s : vendas) {
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        return getNome();
    }

}
