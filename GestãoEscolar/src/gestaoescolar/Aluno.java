// Declara o pacote onde a classe está localizada.
package gestaoescolar;

// Define a classe Aluno, que representa os alunos de um sistema de gestão escolar.
public class Aluno {
    // Declara os atributos privados da classe.
    private String nome;                // Nome do aluno.
    private String numero_matricula;    // Número de matrícula do aluno.

    // Construtor da classe Aluno para inicializar os atributos.
    public Aluno(String nome, String numero) {
        this.nome = nome;                     // Define o nome do aluno.
        this.numero_matricula = numero;       // Define o número de matrícula do aluno.
    }

    // Método para exibir as informações do aluno no console.
    public void exibirInformacoes() {
        System.out.println("Informações do Aluno:");   // Exibe um cabeçalho informativo.
        System.out.println("Nome: " + nome);          // Exibe o nome do aluno.
        System.out.println("Número de Matrícula: " + numero_matricula); // Exibe o número de matrícula.
    }

    // Método estático para buscar um aluno no array pelo número de matrícula.
    public static void buscarPorNumero(Aluno[] arrayAlunos, String numero) {
        boolean alunoEncontrado = false; // Flag para indicar se o aluno foi encontrado.

        // Itera sobre o array de alunos.
        for (Aluno aluno : arrayAlunos) {
            // Verifica se o número de matrícula do aluno atual é igual ao número buscado.
            if (aluno.numero_matricula.equals(numero)) {
                aluno.exibirInformacoes(); // Exibe as informações do aluno encontrado.
                alunoEncontrado = true;   // Define a flag como verdadeiro.
                break;                    // Encerra o loop, pois o aluno já foi encontrado.
            }
        }

        // Se nenhum aluno foi encontrado, exibe uma mensagem de erro.
        if (!alunoEncontrado) {
            System.out.println("Erro: Aluno com número de matrícula " + numero + " não encontrado.");
        }
    }

    // Método estático para buscar um aluno no array pelo índice.
    public static void escolherPorIndice(Aluno[] arrayAlunos, int indice) {
        // Verifica se o índice está dentro dos limites do array.
        if (indice >= 0 && indice < arrayAlunos.length) {
            arrayAlunos[indice].exibirInformacoes(); // Exibe as informações do aluno no índice.
        } else {
            // Caso o índice seja inválido, exibe uma mensagem de erro.
            System.out.println("Erro: Índice de aluno inválido!");
        }
    }
}
