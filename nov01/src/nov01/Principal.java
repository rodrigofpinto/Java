package nov01;

public class Principal {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		//Confira os valores usando os stters
		pessoa.setNome("José");
		pessoa.setIdade(25);
		
		//Acede aos valores usando os getters
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Idade: " + pessoa.getIdade());
	}

}

class Pessoa {
	//Variáveis privadas
	private String nome; 
	private int idade;
	
	//Getter para nome
	public String getNome() {
		return nome;
	}
	//Setter para nome
	public void setNome() {
		this.nome = nome;
	}
	//Getter para idade
	public int getIdade() {
		return idade;
	}
	//Setter para idade
	public int setIdade(int idade) {
		if (idade > 17) {
			this.idade =
		}
	}
	
}
