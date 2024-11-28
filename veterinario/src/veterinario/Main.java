package veterinario;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//Cria os objetos
		Consultas consulta1 = new Consultas ("Oreo", "Preto/Branco", "Rafeiro", "20/03/2004");
		
		
		consulta1.listarDetalhesAnimal();	
		}
}
