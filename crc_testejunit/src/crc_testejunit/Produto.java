// Declara o pacote onde a classe Produto está localizada.
package crc_testejunit;

// Define a classe Produto, que representa um item com nome e preço.
public class Produto {
    // Atributos privados para armazenar os dados do produto.
    private String nome;  // Nome do produto.
    private double preco; // Preço do produto.

    // Construtor da classe Produto para inicializar os atributos.
    public Produto(String nome, double preco) {
        this.nome = nome;   // Define o nome do produto.
        this.preco = preco; // Define o preço do produto.
    }

    // Getter para acessar o preço do produto.
    public double getPreco() {
        return preco;
    }

    // Setter para alterar o preço do produto.
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Getter para acessar o nome do produto.
    public String getNome() {
        return nome;
    }

    // Setter para alterar o nome do produto.
    public void setNome(String nome) {
        this.nome = nome;
    }
}
