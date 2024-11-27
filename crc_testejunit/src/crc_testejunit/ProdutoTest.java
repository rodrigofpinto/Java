// Declara o pacote onde esta classe de teste está localizada.
package crc_testejunit;

// Importa o JUnit para permitir o uso de anotações e ferramentas de teste.
import org.junit.jupiter.api.Test;

// Importa métodos estáticos para facilitar a escrita de asserções, como assertEquals.
import static org.junit.jupiter.api.Assertions.*;

// Define a classe de teste para a classe Produto.
public class ProdutoTest {

    // Define um método de teste para verificar a criação de um objeto Produto.
    @Test
    public void testCriarProduto() {
        // Cria um objeto Produto com nome e preço.
        Produto produto = new Produto("Notebook", 3000.00);

        // Verifica se o nome do produto criado é "Notebook".
        assertEquals("Notebook", produto.getNome());

        // Verifica se o preço do produto criado é 3000.00.
        assertEquals(3000.00, produto.getPreco());
    }

    // Define um método de teste para verificar a alteração do preço de um produto.
    @Test
    public void testAlterarPrecoProduto() {
        // Cria um objeto Produto com nome e preço inicial.
        Produto produto = new Produto("Mouse", 50.00);

        // Altera o preço do produto usando o método setPreco.
        produto.setPreco(60.00);

        // Verifica se o preço do produto foi alterado corretamente para 60.00.
        assertEquals(60.00, produto.getPreco());
    }
}
