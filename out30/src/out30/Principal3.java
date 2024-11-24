package out30;

public class Principal3 {
	//Method static
	static void meuMetodoStatic() {
		System.out.println("Métodos static podem ser chamados sem criar objetos");
	}
	//Method public
	public void meuMetodoPublic() {
		System.out.println("Métodos públicos têm de ser chamados criando objetos");
	}
	public static void main(String[] args) {
		meuMetodoStatic(); //Call method static
		
		Principal3 meuObj = new Principal3(); //Cria um objeto da classe Principal
		meuObj.meuMetodoPublic(); //Call method public
	}

}
