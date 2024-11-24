package out30;

public class Segunda {
	//Java está estruturado em classes, classes falam umas com as outras a nao ser que estejam protejidas, 
	//classes podem dar heranças e herar, 
	//dentro das classes tem objetos, 
	//classe que nao pode criar objetos(abstracts)
	public static void main(String[] args) {
		Estudante1 meuObj = new Estudante1();
		System.out.println("Nome: " + meuObj.nome + " " + meuObj.apelido);
		System.out.println("Email: " + meuObj.email);
		System.out.println("Idade: " + meuObj.idade);
		System.out.println("Ano de formação: " + meuObj.anoFormacao);
		
		meuObj.estudar(); //chama método abstracto

	}

}
