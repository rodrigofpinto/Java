package scanner;

import java.util.Scanner;

public class InputExemplo {
    public static void main(String[] args) {
        // Criar um objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // 1. Entrada de String
        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine(); // Lê uma linha completa
        System.out.println("O nome digitado foi: " + nome);

        // 2. Entrada de Inteiro
        System.out.print("Digite a sua idade: ");
        int idade = scanner.nextInt(); // Lê um número inteiro
        System.out.println("A idade digitada foi: " + idade);

        // 3. Entrada de Número Decimal
        System.out.print("Digite o seu peso: ");
        double peso = scanner.nextDouble(); // Lê um número decimal
        System.out.println("O peso digitado foi: " + peso);

        // Limpar o buffer (caso precise usar nextLine após nextInt ou nextDouble)
        scanner.nextLine();

        // 4. Entrada de Único Caractere
        System.out.print("Digite uma letra: ");
        char letra = scanner.next().charAt(0); // Lê a primeira letra da entrada
        System.out.println("A letra digitada foi: " + letra);

        // 5. Entrada de Booleano
        System.out.print("Está a estudar? (true/false): ");
        boolean estaEstudando = scanner.nextBoolean(); // Lê true ou false
        System.out.println("Resposta: " + estaEstudando);

        // 6. Entrada de Vários Valores (Separados por Espaços)
        System.out.print("Digite dois números separados por espaço: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println("Os números digitados foram: " + num1 + " e " + num2);

        // Encerrar o scanner
        scanner.close();
    }
}

