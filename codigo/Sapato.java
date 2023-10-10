package codigo;
public class Sapato {

    private int tamanho;
    private int codigo;
    private String marca;
    private String tipo;

    public Sapato(int tamanho, int codigo, String marca) {
        this.tamanho = tamanho;
        this.codigo = codigo;
        this.marca = marca;
    }

    public int getTamanho(){
        return tamanho;
    }
  
    public int getCodigo(){
        return codigo;
    }

    public String getMarca(){
        return marca;
    }
    
    public String getTipo(){
        return tipo;
    }

    protected void setTipo(String tipo){
        this.tipo = tipo;
    }

    @Override 
    public String toString(){
        String aux;
        aux = String.format("%5d%10s%10s%12d",codigo, tipo,marca,tamanho);
        return aux;
    }
}
