// Declara o pacote onde a classe Cliente está localizada.
package crc_testejunit;

// Define a classe Cliente, representando um cliente com nome e email.
public class Cliente {
    // Atributos privados para armazenar o nome e o email do cliente.
    private String nome;
    private String email;

    // Construtor da classe Cliente para inicializar os atributos.
    public Cliente(String nome, String email) {
        this.nome = nome; // Define o nome do cliente.
        this.email = email; // Define o email do cliente.
    }

    // Método para o cliente fazer um pedido.
    // Recebe um Produto e uma quantidade como parâmetros.
    public Pedido fazerPedido(Produto produto, int quantidade) {
        // Cria e retorna um novo objeto Pedido associado ao cliente atual.
        return new Pedido(this, produto, quantidade);
    }

    // Getter para obter o nome do cliente.
    public String getNome() {
        return nome;
    }

    // Setter para alterar o nome do cliente.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para obter o email do cliente.
    public String getEmail() {
        return email;
    }

    // Setter para alterar o email do cliente.
    public void setEmail(String email) {
        this.email = email;
    }
}
