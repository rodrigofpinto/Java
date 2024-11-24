package out30;


class Veiculo {
	protected String marca = "Ford";
	
	public void buzina( ) {
		System.out.println("Fom, fom!");
	}
}

// vai dar erro, não pode herdar da class Final VeiculO
class Descapotaveis extends Veiculo {
	private String nomeModelo ="Mustang";
	
	public static void main(String[] args) {
		Descapotaveis meuCarro = new Descapotaveis();
		meuCarro.buzina();
		System.out.println(meuCarro.marca + " " + meuCarro.nomeModelo);
	}
}
