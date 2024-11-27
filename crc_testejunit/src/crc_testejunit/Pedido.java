// Declara o pacote onde a classe Pedido está localizada.
package crc_testejunit;

// Define a classe Pedido, representando um pedido feito por um cliente.
public class Pedido {
    // Declaração dos atributos da classe Pedido.
    // "final" significa que esses valores não podem ser alterados após serem definidos no construtor.
    private final Cliente cliente;  // O cliente que fez o pedido.
    private final Produto produto;  // O produto incluído no pedido.
    private final int quantidade;   // A quantidade do produto no pedido.

    // Construtor da classe Pedido para inicializar os atributos.
    public Pedido(Cliente cliente, Produto produto, int quantidade) {
        this.cliente = cliente;         // Define o cliente do pedido.
        this.produto = produto;         // Define o produto do pedido.
        this.quantidade = quantidade;   // Define a quantidade do produto no pedido.
    }

    // Método para calcular o valor total do pedido.
    public double calcularTotal() {
        // Retorna o preço do produto multiplicado pela quantidade.
        return produto.getPreco() * quantidade;
    }

    // Getter para obter o cliente associado ao pedido.
    public Cliente getCliente() {
        return cliente;
    }

    // Getter para obter o produto associado ao pedido.
    public Produto getProduto() {
        return produto;
    }

    // Getter para obter a quantidade do produto no pedido.
    public int getQuantidade() {
        return quantidade;
    }
}
