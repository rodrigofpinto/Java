package out30;
 
//a classe não pode ser utilizada para criar objetos (para aceder a uma classe abstrata, tem que ser herdada de outra classe)
//classe principal é Segunda
abstract class Abstracta {
public String nome = "José";
public String apelido = "Sousa";
public String email = "josedsousa@epb.pt";
public int idade = 17;
 
public abstract void estudar (); // métudo abstract
}
 
//Subclass (herda de Abstracta)
class Estudante1 extends Abstracta {
public int anoFormacao = 2018;
 
public void estudar() {
	System.out.println("Estudar todo o dia");
}
}