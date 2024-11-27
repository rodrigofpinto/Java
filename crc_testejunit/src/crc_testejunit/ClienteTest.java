// Declara o pacote onde esta classe de teste está localizada.
package crc_testejunit;

// Importa o JUnit para usar anotações e métodos de teste.
import org.junit.jupiter.api.Test;

// Importa métodos estáticos para facilitar o uso de asserções, como assertEquals e assertNotNull.
import static org.junit.jupiter.api.Assertions.*;

// Define a classe de teste para a classe Cliente.
public class ClienteTest {

    // Método de teste para verificar a criação de um cliente.
    @Test
    public void testCriarCliente() {
        // Cria um objeto Cliente com nome e email.
        Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");

        // Verifica se o nome do cliente corresponde ao valor esperado.
        assertEquals("João Silva", cliente.getNome());

        // Verifica se o email do cliente corresponde ao valor esperado.
        assertEquals("joao.silva@email.com", cliente.getEmail());
    }

    // Método de teste para verificar a funcionalidade de fazer um pedido.
    @Test
    public void testFazerPedido() {
        // Cria um objeto Cliente com nome e email.
        Cliente cliente = new Cliente("Maria Oliveira", "maria@email.com");

        // Cria um objeto Produto com nome e preço.
        Produto produto = new Produto("Teclado", 100.00);

        // O cliente faz um pedido com o produto e a quantidade desejada.
        Pedido pedido = cliente.fazerPedido(produto, 2);

        // Verifica se o pedido foi criado (não é nulo).
        assertNotNull(pedido);

        // Verifica se o cliente associado ao pedido é o mesmo cliente criado.
        assertEquals(cliente, pedido.getCliente());

        // Verifica se o produto associado ao pedido é o mesmo produto criado.
        assertEquals(produto, pedido.getProduto());

        // Verifica se a quantidade do pedido é igual ao valor esperado.
        assertEquals(2, pedido.getQuantidade());
    }
}
