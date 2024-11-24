package calculadora_classes;

//Classe principal
public class Main {
 public static void main(String[] args) {
     Calculadora calculadora = new Calculadora(); // Criar uma instância da Calculadora
     
     int soma = calculadora.somar(5, 3); // Chama o método somar
     int subtracao = calculadora.subtrair(10, 4); // Chama o método subtrair
     
     System.out.println("Soma: " + soma); // Exibe os resultados
     System.out.println("Subtração: " + subtracao);
 }
}

//Classe complementar
class Calculadora {
 // Método para somar
 public int somar(int a, int b) {
     return a + b;
 }

 // Método para subtrair
 public int subtrair(int a, int b) {
     return a - b;
 }
 
 public double dividir(double a, double b) {
	 if (a == 0 || b == 0) {
		 throw new ArithmeticException("Não é permitido dividir por 0.");
	 } else {
		 return a / b;
	 }
	 
 }
}

