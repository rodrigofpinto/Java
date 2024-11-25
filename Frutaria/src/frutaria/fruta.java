package frutaria;

public class fruta {
	String nome;
	int quantidade;
	double preco;
	
	public fruta(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	void listarFrutas() {
		System.out.println("\nFruta: " + nome + 
				"\nQuantidade: " + quantidade + 
				"\nPreço: " + preco + ";"
				);
	}
}
