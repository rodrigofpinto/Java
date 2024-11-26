package gestaoescolar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Aluno aluno1 = new Aluno("Rodrigo Pinto", "12345"); //Declara o primeiro aluno
        Aluno aluno2 = new Aluno("Maria Isabel", "54321");  //Declara o segundo aluno
        
        Aluno[] arrayAlunos = {aluno1, aluno2}; //Cria uma array com os dois alunos

        Scanner scanner = new Scanner(System.in); //Inicializa o scanner
        System.out.println("Escolha uma opção:"); //Pergunta qual a opção
        System.out.println("1 - Buscar aluno por número de matrícula");
        System.out.println("2 - Buscar aluno pelo índice no array");

        int opcao = scanner.nextInt(); //Input de valor inteiro

        switch (opcao) {
            case 1:
                System.out.print("Digite o número da matrícula do aluno: ");
                scanner.nextLine(); 
                String numeroMatricula = scanner.nextLine();  
                Aluno.buscarPorNumero(arrayAlunos, numeroMatricula);  
                break;
            case 2:
                System.out.print("Digite o número do índice do aluno (1 para o primeiro aluno): ");
                int indice = scanner.nextInt() - 1; 
                Aluno.escolherPorIndice(arrayAlunos, indice); 
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
        
        scanner.close(); 
    }
}
