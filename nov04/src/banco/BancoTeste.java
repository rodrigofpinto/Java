package banco;

import static org.junit.jupiter.api.Assertions.assertEquals; // Importa o método para verificar igualdade nos testes.
import org.junit.jupiter.api.BeforeEach; // Importa a anotação para configurar o estado antes de cada teste.
import org.junit.jupiter.api.Test; // Importa a anotação para identificar métodos de teste.

class BancoTeste {
	
	private Banco banco; // Instância da classe Banco que será testada.
	private ContaCorrente conta1, conta2; // Instâncias de contas correntes para os testes.

	@BeforeEach
	public void setUp() {
		// Inicializa o banco e as contas antes de cada teste.
		banco = new Banco();
		conta1 = new ContaCorrente("123456", 100.0); // Cria uma conta com saldo inicial de 100.
		conta2 = new ContaCorrente("456789", 50.0);  // Cria uma conta com saldo inicial de 50.
		
		// Registra as contas no banco.
		banco.registarConta(conta1);
		banco.registarConta(conta2);
	}
	
	@Test
	public void testObterSaldoTotal() {		
		// Verifica se o saldo total calculado pelo banco está correto.
		double saldoEsperado = 100.0 + 50.0; // Soma dos saldos iniciais das duas contas.
		assertEquals(saldoEsperado, banco.obterSaldoTotal(), "O saldo total do banco não está correto.");
	}
	
	@Test
	public void testRegistrarConta() {
		// Verifica se uma nova conta é registrada corretamente.
		ContaCorrente novaConta = new ContaCorrente("789012", 200.0); // Cria uma nova conta.
		banco.registarConta(novaConta); // Registra a nova conta no banco.

		// Verifica se o saldo total do banco inclui o saldo da nova conta.
		double saldoEsperado = 100.0 + 50.0 + 200.0; // Soma dos saldos das três contas.
		assertEquals(saldoEsperado, banco.obterSaldoTotal(), "O saldo total não foi atualizado corretamente após registrar uma nova conta.");
	}
}
