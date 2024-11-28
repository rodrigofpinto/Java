package numericos;

public class NumericManipulations {

    // Método para calcular o fatorial de um número
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Número deve ser não-negativo.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Método para calcular a soma de uma sequência de números (soma dos primeiros 'n' números)
    public static int sumOfNumbers(int n) {
        return (n * (n + 1)) / 2; // Fórmula da soma dos 'n' primeiros números naturais
    }

    // Método para verificar se um número é primo
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para calcular o Máximo Divisor Comum (MDC) de dois números
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Método para calcular o Mínimo Múltiplo Comum (MMC) de dois números
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Método para calcular a média de uma sequência de números
    public static double average(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

    // Método para calcular a soma dos quadrados de uma sequência de números
    public static int sumOfSquares(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num * num;
        }
        return sum;
    }

    // Método para verificar se um número é perfeito
    public static boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    // Método para calcular a raiz quadrada de um número (valor aproximado)
    public static double sqrt(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Número deve ser não-negativo.");
        }
        return Math.sqrt(num);
    }

    // Método para calcular a potência de um número (base^exponente)
    public static double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    // Método para arredondar um número para o inteiro mais próximo
    public static long round(double num) {
        return Math.round(num);
    }

    // Método para verificar se um número é um número de Armstrong
    public static boolean isArmstrongNumber(int num) {
        int sum = 0, temp = num, digits = 0;
        while (temp != 0) {
            temp /= 10;
            digits++;
        }
        temp = num;
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == num;
    }

    // Método para converter um número de base 10 para binário
    public static String toBinary(int num) {
        return Integer.toBinaryString(num);
    }

    // Método para converter um número de binário para base 10
    public static int toDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static void main(String[] args) {
        // Testando os métodos
        System.out.println("Fatorial de 5: " + factorial(5));
        System.out.println("Soma dos primeiros 10 números: " + sumOfNumbers(10));
        System.out.println("É 7 primo? " + isPrime(7));
        System.out.println("MDC de 24 e 36: " + gcd(24, 36));
        System.out.println("MMC de 24 e 36: " + lcm(24, 36));
        System.out.println("Média de 1, 2, 3, 4, 5: " + average(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Soma dos quadrados de 1, 2, 3: " + sumOfSquares(new int[]{1, 2, 3}));
        System.out.println("O número 28 é perfeito? " + isPerfectNumber(28));
        System.out.println("Raiz quadrada de 16: " + sqrt(16));
        System.out.println("2^3: " + power(2, 3));
        System.out.println("Arredondar 5.7: " + round(5.7));
        System.out.println("Número 153 é um número de Armstrong? " + isArmstrongNumber(153));
        System.out.println("Número 10 em binário: " + toBinary(10));
        System.out.println("Binário 1010 em decimal: " + toDecimal("1010"));
    }
}

