// Pacote onde o código está localizado, útil para organizar as classes no projeto.
package crc_testejunit;

// Importa o JUnit para usar as anotações e métodos de teste.
import org.junit.jupiter.api.Test;

// Importa métodos estáticos para facilitar a escrita de asserções, como assertEquals e assertNotNull.
import static org.junit.jupiter.api.Assertions.*;

// Declaração da classe de teste para a classe Pedido.
public class PedidoTest {

    // Define um método de teste para verificar a criação de um objeto Pedido.
    @Test
    public void testCriarPedido() {
        // Cria um cliente com nome e email.
        Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");

        // Cria um produto com nome e preço.
        Produto produto = new Produto("Notebook", 3000.00);

        // Cria um pedido com o cliente, produto e quantidade.
        Pedido pedido = new Pedido(cliente, produto, 1);

        // Verifica se o pedido não é nulo (foi criado corretamente).
        assertNotNull(pedido);

        // Verifica se o cliente associado ao pedido é o mesmo cliente criado.
        assertEquals(cliente, pedido.getCliente());

        // Verifica se o produto associado ao pedido é o mesmo produto criado.
        assertEquals(produto, pedido.getProduto());

        // Verifica se a quantidade do pedido é igual a 1.
        assertEquals(1, pedido.getQuantidade());
    }

    // Define um método de teste para verificar o cálculo do total do pedido.
    @Test
    public void testCalcularTotal() {
        // Cria um produto com nome e preço.
        Produto produto = new Produto("Mouse", 50.00);

        // Cria um cliente com nome e email.
        Cliente cliente = new Cliente("Ana Santos", "ana@email.com");

        // Cria um pedido com o cliente, produto e quantidade 3.
        Pedido pedido = new Pedido(cliente, produto, 3);

        // Calcula o total esperado (preço do produto multiplicado pela quantidade).
        double totalEsperado = 150.00; // 50.00 * 3

        // Verifica se o método calcularTotal retorna o valor esperado.
        assertEquals(totalEsperado, pedido.calcularTotal());
    }
}
