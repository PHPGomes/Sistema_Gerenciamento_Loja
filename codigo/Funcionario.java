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

    public String relatorioValorVendido(){
        String aux = String.format("Total de vendas R$%.2f\n\n",getValorVendas());
        return aux;
    }

    public int getNumProdutosVendidos(){
        return vendas.size();
    }

    public String getProdutoPos(int c){
        return vendas.get(c).toString();
    }



    @Override
    public String toString() {
        return getNome();
    }

}
