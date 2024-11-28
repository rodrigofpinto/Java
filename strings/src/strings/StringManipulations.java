package strings;

public class StringManipulations {

    // Método para verificar se uma string contém uma substring
    public static boolean containsSubstring(String str, String sub) {
        return str.contains(sub); // Verifica se a string 'str' contém a substring 'sub'. Retorna true ou false
    }

    // Método para inverter uma string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str); // Cria um StringBuilder com o conteúdo da string original
        return reversed.reverse().toString(); // Inverte o StringBuilder e converte de volta para string
    }

    // Método para contar o número de ocorrências de uma substring em uma string
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(sub, index)) != -1) { // Busca a substring a partir do índice atual
            count++; // Incrementa o contador a cada vez que a substring é encontrada
            index += sub.length(); // Avança o índice para continuar a busca após a substring encontrada
        }
        return count; // Retorna o número de ocorrências da substring
    }

    // Método para substituir todas as ocorrências de uma substring por outra
    public static String replaceSubstring(String str, String target, String replacement) {
        return str.replace(target, replacement); // Substitui todas as ocorrências de 'target' por 'replacement'
    }

    // Método para dividir uma string em partes com base em um delimitador
    public static String[] splitString(String str, String delimiter) {
        return str.split(delimiter); // Divide a string 'str' usando o delimitador fornecido e retorna um array de substrings
    }

    // Método para verificar se uma string começa com uma determinada substring
    public static boolean startsWith(String str, String prefix) {
        return str.startsWith(prefix); // Verifica se a string 'str' começa com a substring 'prefix'
    }

    // Método para verificar se uma string termina com uma determinada substring
    public static boolean endsWith(String str, String suffix) {
        return str.endsWith(suffix); // Verifica se a string 'str' termina com a substring 'suffix'
    }

    // Método para converter uma string para letras minúsculas
    public static String toLowerCase(String str) {
        return str.toLowerCase(); // Converte todos os caracteres da string para minúsculas
    }

    // Método para converter uma string para letras maiúsculas
    public static String toUpperCase(String str) {
        return str.toUpperCase(); // Converte todos os caracteres da string para maiúsculas
    }

    // Método para remover espaços em branco no início e no fim da string
    public static String trimString(String str) {
        return str.trim(); // Remove os espaços em branco do início e do fim da string
    }

    // Método para verificar se uma string é um palíndromo (lê-se igual de frente para trás)
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str); // Inverte a string e armazena o resultado
        return str.equals(reversed); // Compara a string original com a invertida e retorna true se forem iguais
    }

    // Método para comparar duas strings lexicograficamente
    public static int compareStrings(String str1, String str2) {
        return str1.compareTo(str2); // Compara 'str1' com 'str2'. Retorna 0 se forem iguais, um valor negativo se 'str1' for menor e um valor positivo se 'str1' for maior
    }

    // Método para substituir a primeira ocorrência de uma substring por outra
    public static String replaceFirst(String str, String target, String replacement) {
        return str.replaceFirst(target, replacement); // Substitui a primeira ocorrência de 'target' por 'replacement'
    }

    // Método principal para testar os métodos de manipulação de strings
    public static void main(String[] args) {
        String str = "Hello World!";

        // Testando containsSubstring
        System.out.println("Contém 'World'? " + containsSubstring(str, "World")); // Retorna true, pois 'World' está em 'Hello World!'

        // Testando reverseString
        System.out.println("Inverso de 'Hello World!': " + reverseString(str)); // Retorna '!dlroW olleH'

        // Testando countOccurrences
        System.out.println("Ocorrências de 'o': " + countOccurrences(str, "o")); // Retorna 2, pois 'o' aparece 2 vezes em 'Hello World!'

        // Testando replaceSubstring
        System.out.println("Substituir 'World' por 'Java': " + replaceSubstring(str, "World", "Java")); // Retorna 'Hello Java!'

        // Testando splitString
        String[] parts = splitString(str, " ");
        System.out.println("Dividido por espaço: ");
        for (String part : parts) {
            System.out.println(part); // Retorna duas partes: "Hello" e "World!"
        }

        // Testando startsWith
        System.out.println("Começa com 'Hello'? " + startsWith(str, "Hello")); // Retorna true, pois 'Hello World!' começa com 'Hello'

        // Testando endsWith
        System.out.println("Termina com '!': " + endsWith(str, "!")); // Retorna true, pois 'Hello World!' termina com '!'

        // Testando toLowerCase
        System.out.println("Para minúsculas: " + toLowerCase(str)); // Retorna 'hello world!'

        // Testando toUpperCase
        System.out.println("Para maiúsculas: " + toUpperCase(str)); // Retorna 'HELLO WORLD!'

        // Testando trimString
        String strWithSpaces = "   Hello World!   ";
        System.out.println("Remover espaços: '" + trimString(strWithSpaces) + "'"); // Retorna 'Hello World!'

        // Testando isPalindrome
        String palindrome = "madam";
        System.out.println("É palíndromo? " + isPalindrome(palindrome)); // Retorna true, pois 'madam' é um palíndromo

        // Testando compareStrings
        System.out.println("Comparar 'apple' e 'banana': " + compareStrings("apple", "banana")); // Retorna um valor negativo, pois 'apple' vem antes de 'banana'

        // Testando replaceFirst
        System.out.println("Substituir a primeira ocorrência de 'o' por '0': " + replaceFirst(str, "o", "0")); // Retorna 'Hell0 World!'
    }
}
