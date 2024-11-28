package veterinario;

public class Consultas {
	String nome;
	String cor;
	String raca;
	String dataNascimento;
	
	public Consultas(String nome, String cor, String raca, String dataNascimento) {
		this.nome = nome;
		this.cor = cor;
		this.raca = raca;
		this.dataNascimento = dataNascimento;
	}
	
	void listarDetalhesAnimal() {
		System.out.println("Nome: " + nome + "\nCor: " + cor + "\nRaça: " + raca + "\nData de Nascimento: " + dataNascimento);
	}
}
