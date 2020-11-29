package exportador;

/**
 *
 * @author Jamylle
 */
public class Produto {
    private static int ultimoId = 0;

    private int id;
    private String descricao;
    private String marca;
    private String modelo;
    private double preco;
    
    public Produto() {
        this.id = ++ultimoId;
    }
    
    public Produto(String descricao, String marca, String modelo, double preco) {
        this();
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
