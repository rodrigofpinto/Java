package arrays;

import java.util.Arrays;

public class ArrayManipulations {

    // Método para encontrar o maior valor em um array
    public static int findMax(int[] array) {
        int max = array[0]; // Começa com o primeiro elemento como o maior
        for (int i = 1; i < array.length; i++) { // Itera do segundo elemento até o final
            if (array[i] > max) { // Se encontrar um valor maior, atualiza max
                max = array[i];
            }
        }
        return max; // Retorna o maior valor encontrado
    }

    // Método para calcular a soma de todos os elementos de um array
    public static int sumArray(int[] array) {
        int sum = 0; // Inicializa a soma como 0
        for (int num : array) { // Itera sobre cada elemento do array
            sum += num; // Soma o valor de cada elemento à variável sum
        }
        return sum; // Retorna a soma total dos elementos
    }

    // Método para inverter os elementos de um array
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length]; // Cria um novo array para armazenar os elementos invertidos
        for (int i = 0; i < array.length; i++) { // Itera sobre o array original
            reversed[i] = array[array.length - 1 - i]; // Atribui os valores de trás para frente no novo array
        }
        return reversed; // Retorna o array invertido
    }

    // Método para verificar se um array contém um valor específico
    public static boolean contains(int[] array, int value) {
        for (int num : array) { // Itera sobre os elementos do array
            if (num == value) { // Se o valor encontrado for igual ao procurado
                return true; // Retorna true, indicando que o valor foi encontrado
            }
        }
        return false; // Se o valor não for encontrado, retorna false
    }

    // Método para calcular a média dos valores em um array
    public static double average(int[] array) {
        int sum = 0; // Inicializa a soma como 0
        for (int num : array) { // Itera sobre todos os elementos do array
            sum += num; // Soma os valores dos elementos
        }
        return (double) sum / array.length; // Retorna a média dividindo a soma pelo número de elementos
    }

    // Método para contar quantas vezes um valor específico aparece no array
    public static int countOccurrences(int[] array, int value) {
        int count = 0; // Inicializa o contador como 0
        for (int num : array) { // Itera sobre todos os elementos do array
            if (num == value) { // Se o número for igual ao valor procurado
                count++; // Incrementa o contador
            }
        }
        return count; // Retorna o número de vezes que o valor aparece no array
    }

    // Método para remover todos os valores iguais a um valor específico de um array
    public static int[] removeValue(int[] array, int value) {
        int count = 0; // Inicializa o contador de elementos que são diferentes do valor
        for (int num : array) {
            if (num != value) { // Conta os elementos que são diferentes do valor
                count++;
            }
        }
        int[] result = new int[count]; // Cria um novo array com o tamanho adequado
        int index = 0;
        for (int num : array) {
            if (num != value) { // Adiciona ao novo array os elementos diferentes do valor
                result[index++] = num;
            }
        }
        return result; // Retorna o novo array sem os valores removidos
    }

    // Método para encontrar o índice de um valor em um array
    public static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) { // Itera sobre os índices do array
            if (array[i] == value) { // Se encontrar o valor no índice
                return i; // Retorna o índice onde o valor foi encontrado
            }
        }
        return -1; // Se o valor não for encontrado, retorna -1
    }

    // Método para verificar se o array está vazio
    public static boolean isEmpty(int[] array) {
        return array.length == 0; // Retorna true se o array não contiver elementos, caso contrário, false
    }

    // Método para duplicar os elementos de um array
    public static int[] duplicateArray(int[] array) {
        int[] duplicate = new int[array.length]; // Cria um novo array com o mesmo tamanho
        for (int i = 0; i < array.length; i++) { // Itera sobre todos os elementos do array
            duplicate[i] = array[i]; // Copia os elementos para o novo array
        }
        return duplicate; // Retorna o novo array duplicado
    }

    // Método para combinar dois arrays em um único array
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int[] merged = new int[array1.length + array2.length]; // Cria um novo array que pode armazenar ambos os arrays
        System.arraycopy(array1, 0, merged, 0, array1.length); // Copia todos os elementos do primeiro array
        System.arraycopy(array2, 0, merged, array1.length, array2.length); // Copia todos os elementos do segundo array
        return merged; // Retorna o array combinado
    }

    // Método para testar os métodos de manipulação de arrays
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // Testando o método findMax
        System.out.println("Maior valor: " + findMax(numbers)); // Retorna 5, o maior valor no array

        // Testando o método sumArray
        System.out.println("Soma dos elementos: " + sumArray(numbers)); // Retorna 15, a soma de 1 + 2 + 3 + 4 + 5

        // Testando o método reverseArray
        int[] reversed = reverseArray(numbers); // Retorna um array invertido: {5, 4, 3, 2, 1}
        System.out.print("Array invertido: ");
        for (int num : reversed) {
            System.out.print(num + " ");
        }

        // Testando o método contains
        System.out.println("\nArray contém o valor 3? " + contains(numbers, 3)); // Retorna true

        // Testando o método average
        System.out.println("Média dos elementos: " + average(numbers)); // Retorna 3.0, a média de (1 + 2 + 3 + 4 + 5) / 5

        // Testando o método countOccurrences
        System.out.println("Ocorrências do valor 2: " + countOccurrences(numbers, 2)); // Retorna 1

        // Testando o método removeValue
        int[] removed = removeValue(numbers, 3); // Retorna {1, 2, 4, 5}, removendo o valor 3
        System.out.print("Array sem o valor 3: ");
        for (int num : removed) {
            System.out.print(num + " ");
        }

        // Testando o método indexOf
        System.out.println("\nÍndice do valor 4: " + indexOf(numbers, 4)); // Retorna 3

        // Testando o método isEmpty
        System.out.println("O array está vazio? " + isEmpty(numbers)); // Retorna false, pois o array contém elementos

        // Testando o método duplicateArray
        int[] duplicate = duplicateArray(numbers); // Retorna uma cópia exata do array {1, 2, 3, 4, 5}
        System.out.print("Array duplicado: ");
        for (int num : duplicate) {
            System.out.print(num + " ");
        }

        // Testando o método mergeArrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] merged = mergeArrays(array1, array2); // Retorna {1, 2, 3, 4, 5, 6}
        System.out.print("\nArrays combinados: ");
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }
}
