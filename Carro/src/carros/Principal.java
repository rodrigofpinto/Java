package carros;

public class Principal {
	public static void main(String[] args) {
		// Criar objetos da classe Carro; o construtor tem o mesmo nome da classe
		Carros carro1 = new Carros("Corsa", 10, 0);
		Carros carro2 = new Carros("Clio", 15, 0);
		Carros carro3 = new Carros("Corsa", 5, 0); // É outro objeto, com classe Carro
		
		carro1.acelerar(); // Chamada ao método acelarar() da classe Carros
		carro1.acelerar();
		carro1.acelerar();
		carro1.travar(); // chamada ao método travar() da classe Carros
		
		carro2.acelerar();
		carro2.acelerar();
		
		carro3.acelerar();
		
		//Imprime as informações dos carros
		carro1.imprimir();
		carro2.imprimir();
		System.out.println("Verifique que o valor de c3 não é alertado por c1, apesar de ambos serem Corsa");
		carro3.imprimir();
	}
}
