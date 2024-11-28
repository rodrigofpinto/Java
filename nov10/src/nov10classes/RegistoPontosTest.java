package nov10classes;

import static org.junit.jupiter.api.Assertions.*; // Importa métodos estáticos como assertEquals para facilitar os testes.
import org.junit.jupiter.api.BeforeEach; // Anotação para executar métodos antes de cada teste.
import org.junit.jupiter.api.Test; // Anotação para marcar métodos de teste.

/**
 * Classe de teste para a classe RegistoPontos.
 * Essa classe verifica se os métodos de RegistoPontos estão atribuindo
 * os pontos corretamente a usuários normais e VIPs.
 */
public class RegistoPontosTest {

    // Declaração de variáveis que serão usadas nos testes.
    private RegistoPontos registoPontos;
    private Utilizador utilizador;
    private CalculadoraBonus calculadoraBonus;

    /**
     * Método setup inicializa os objetos necessários para os testes antes de cada execução.
     */
    @BeforeEach
    public void setup() {
        calculadoraBonus = new CalculadoraBonus(); // Cria uma instância de CalculadoraBonus.
        registoPontos = new RegistoPontos(calculadoraBonus); // Cria uma instância de RegistoPontos.
        utilizador = new Utilizador(); // Cria uma instância de Utilizador.
        utilizador.setNome("João"); // Configura o nome do utilizador.
        utilizador.setPontos(0); // Inicializa os pontos como 0.
        utilizador.setVip(false); // Define o utilizador como não VIP.
    }

    /**
     * Testa se fazer um comentário atribui 3 pontos para um utilizador normal.
     */
    @Test
    public void testFazerComentarioUtilizadorNormal() {
        registoPontos.fazerComentario(utilizador); // Faz o utilizador comentar.
        assertEquals(3, utilizador.getPontos(), 
            "O utilizador normal deveria ter 3 pontos após fazer um comentário.");
    }

    /**
     * Testa se criar um tópico atribui 5 pontos para um utilizador normal.
     */
    @Test
    public void testCriarTopicoUtilizadorNormal() {
        registoPontos.criarTopico(utilizador); // Faz o utilizador criar um tópico.
        assertEquals(5, utilizador.getPontos(), 
            "O utilizador normal deveria ter 5 pontos após criar um tópico.");
    }

    /**
     * Testa se dar um "like" atribui 1 ponto para um utilizador normal.
     */
    @Test
    public void testDarLikeUtilizadorNormal() {
        registoPontos.darLike(utilizador); // Faz o utilizador dar um "like".
        assertEquals(1, utilizador.getPontos(), 
            "O utilizador normal deveria ter 1 ponto após dar um 'like'.");
    }

    /**
     * Testa se fazer um comentário atribui 15 pontos para um utilizador VIP.
     */
    @Test
    public void testFazerComentarioUtilizadorVip() {
        utilizador.setVip(true); // Define o utilizador como VIP.
        registoPontos.fazerComentario(utilizador); // Faz o utilizador comentar.
        assertEquals(15, utilizador.getPontos(), 
            "O utilizador VIP deveria ter 15 pontos após fazer um comentário.");
    }

    /**
     * Testa se criar um tópico atribui 25 pontos para um utilizador VIP.
     */
    @Test
    public void testCriarTopicoUtilizadorVip() {
        utilizador.setVip(true); // Define o utilizador como VIP.
        registoPontos.criarTopico(utilizador); // Faz o utilizador criar um tópico.
        assertEquals(25, utilizador.getPontos(), 
            "O utilizador VIP deveria ter 25 pontos após criar um tópico.");
    }

    /**
     * Testa se dar um "like" atribui 5 pontos para um utilizador VIP.
     */
    @Test
    public void testDarLikeUtilizadorVip() {
        utilizador.setVip(true); // Define o utilizador como VIP.
        registoPontos.darLike(utilizador); // Faz o utilizador dar um "like".
        assertEquals(5, utilizador.getPontos(), 
            "O utilizador VIP deveria ter 5 pontos após dar um 'like'.");
    }
}
