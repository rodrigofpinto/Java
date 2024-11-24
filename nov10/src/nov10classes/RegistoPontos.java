package nov10classes;
 
//Classe responsável por registar ações que resultam na atribuição de pontos a um utilizador
public class RegistoPontos {
 
//Instância de CalculadoraBonus para calcular os bónus associados às ações
private CalculadoraBonus bonus;
 
//Construtor que recebe uma instãncia de CalculadoraBonus para inicializar o objeto
public RegistoPontos(CalculadoraBonus cb) {
	this.bonus = cb;
}
 
//Método para registar a ação de fazer um comentário
//Adiciona pontos ao utilizador com base num multiplicador de bónus
public void fazerComentario(Utilizador u) {
	int multiplicador = bonus.bonus(u); //Calcula o multiplicador de bónus
	u.adicionarPontos(3 * multiplicador); //Adiciona pontos multiplicados ao utilizador
}
 
//Método para registar a ação de criar um tópico
//Adiciona mais ponos devido à importância de criar novos tópicos
public void criarTopico(Utilizador u) {
	int multiplicador = bonus.bonus(u); //Calcula o multiplicador de bónus
	u.adicionarPontos(5 * multiplicador); //Adiciona pontos multiplicados ao utilizador
}
 
//Método para registar a ação de dar um "like"
//Adiciona uma pequena quantidade de pontos ao utilizador
public void darLike(Utilizador u) {
	int multiplicador = bonus.bonus(u); //Calcula o multiplicador de bonus
	u.adicionarPontos(1 * multiplicador); //Adiciona pontos mutliplicados ao utilizador
}
}
 