package gestaoescolar;

public class Aluno {
    private String nome;
    private String numero_matricula;

    public Aluno(String nome, String numero) {
        this.nome = nome;
        this.numero_matricula = numero;
    }

    public void exibirInformacoes() {
        System.out.println("Informações do Aluno:");
        System.out.println("Nome: " + nome);
        System.out.println("Número de Matrícula: " + numero_matricula);
    }

    public static void buscarPorNumero(Aluno[] arrayAlunos, String numero) {
        boolean alunoEncontrado = false;

        for (Aluno aluno : arrayAlunos) {
            if (aluno.numero_matricula.equals(numero)) {
                aluno.exibirInformacoes();
                alunoEncontrado = true;
                break;
            }
        }

        if (!alunoEncontrado) {
            System.out.println("Erro: Aluno com número de matrícula " + numero + " não encontrado.");
        }
    }

    public static void escolherPorIndice(Aluno[] arrayAlunos, int indice) {
        if (indice >= 0 && indice < arrayAlunos.length) {
            arrayAlunos[indice].exibirInformacoes();
        } else {
            System.out.println("Erro: Índice de aluno inválido!");
        }
    }
}
