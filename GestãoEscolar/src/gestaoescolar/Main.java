// Declara o pacote onde a classe Main está localizada.
package gestaoescolar;

// Importa a classe Scanner para capturar entradas do teclado.
import java.util.Scanner;

// Classe principal onde a execução do programa começa.
public class Main {
    public static void main(String[] args) {
        // Criação de dois objetos do tipo Aluno.
        Aluno aluno1 = new Aluno("Rodrigo Pinto", "12345"); // Declara o primeiro aluno.
        Aluno aluno2 = new Aluno("Maria Isabel", "54321");  // Declara o segundo aluno.

        // Armazena os alunos em um array para facilitar a busca.
        Aluno[] arrayAlunos = {aluno1, aluno2};

        // Inicializa o Scanner para capturar entradas do teclado.
        Scanner scanner = new Scanner(System.in);

        // Exibe as opções disponíveis para o usuário.
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Buscar aluno por número de matrícula");
        System.out.println("2 - Buscar aluno pelo índice no array");

        // Captura a opção escolhida pelo usuário.
        int opcao = scanner.nextInt();

        // Usa um switch para executar ações com base na opção escolhida.
        switch (opcao) {
            // Caso 1: Buscar aluno pelo número de matrícula.
            case 1:
                System.out.print("Digite o número da matrícula do aluno: ");
                scanner.nextLine(); // Consome a quebra de linha deixada pelo nextInt.
                String numeroMatricula = scanner.nextLine();  // Lê o número de matrícula digitado pelo usuário.
                Aluno.buscarPorNumero(arrayAlunos, numeroMatricula);  // Chama o método estático para buscar o aluno.
                break;

            // Caso 2: Buscar aluno pelo índice no array.
            case 2:
                System.out.print("Digite o número do índice do aluno (1 para o primeiro aluno): ");
                int indice = scanner.nextInt() - 1; // Converte o número digitado para índice (1 = posição 0, etc.).
                Aluno.escolherPorIndice(arrayAlunos, indice); // Chama o método estático para exibir o aluno pelo índice.
                break;

            // Caso padrão: Opção inválida.
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }

        // Fecha o Scanner para liberar os recursos.
        scanner.close();
    }
}
