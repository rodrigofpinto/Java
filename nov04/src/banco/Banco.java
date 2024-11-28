// Declara o pacote onde a classe está localizada.
package banco;

// Importa a classe ArrayList, que será usada para armazenar as contas ativas.
import java.util.ArrayList;

/**
 * Classe Banco que representa um banco e gere múltiplas contas ativas.
 * Permite registrar novas contas, apresentar números das contas ativas,
 * e obter o saldo total de todas as contas.
 */
public class Banco {
    // Atributo privado que armazena uma lista de contas correntes ativas.
    private ArrayList<ContaCorrente> contasAtivas = new ArrayList<>();

    // Método para registrar uma nova conta no banco.
    public void registarConta(ContaCorrente conta) {
        // Adiciona a conta passada como parâmetro ao ArrayList de contas ativas.
        contasAtivas.add(conta);
    }

    // Método para apresentar os números das contas atualmente ativas no banco.
    public void apresentarNumerosContas() {
        System.out.println("Contas ativas:");

        // Utiliza um loop 'for-each' para percorrer todas as contas no ArrayList.
        for (ContaCorrente conta : contasAtivas) {
            // A cada iteração, imprime o número da conta utilizando o método getNumeroConta().
            System.out.println("Conta: " + conta.getNumeroConta());
        }
    }

    // Método para calcular e retornar o saldo total de todas as contas no banco.
    public double obterSaldoTotal() {
        double saldoTotal = 0; // Inicializa o saldo total como zero.

        // Itera sobre todas as contas no ArrayList.
        for (ContaCorrente conta : contasAtivas) {
            // Soma o saldo de cada conta ao saldo total.
            saldoTotal += conta.getSaldo();
        }

        // Retorna o saldo total calculado.
        return saldoTotal;
    }
}
