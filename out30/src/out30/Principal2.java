package out30;

public class Principal2 {
	int x = 10;
	final double PI = 3.14;
	
	public static void main(String[] args) {
		Principal2 meuObj = new Principal2();
		meuObj.x = 50;
		//meuObj.PI = 25; // vai dar erro, é final
		System.out.println(meuObj.x);
		System.out.println(meuObj.PI);
	}
}
//experimente remover final