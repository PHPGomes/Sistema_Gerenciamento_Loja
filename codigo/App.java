package codigo;
public class App{
    public static void main(String[] args) {
        GerenciadorEstoque gerenciadorEstoque =  GerenciadorEstoque.getInstance();
        gerenciadorEstoque.iniciar();
    }
}