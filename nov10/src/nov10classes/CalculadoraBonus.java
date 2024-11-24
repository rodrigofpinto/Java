package nov10classes;

//Classe responsável por calcular os bonús atribuídos a um utilizador
public class CalculadoraBonus {

//Atributo que define o bónus diário padrão
public int bonusDia = 1;

//Método que calcula o multiplicador de bónus com base no estado VIP do utilizador
public int bonus(Utilizador u) {
	int multiplicador = bonusDia; //Inicializa o multiplicador com o bónus do dia
	if (u.isVip()) { //Se o utilizador for VIP, multiplica o bónus por 5
		multiplicador *= 5;
	}
	return multiplicador; //retorna o multiplicador final
}
}