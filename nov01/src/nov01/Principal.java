package nov01;

public class Principal {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        
        // Configura os valores usando os setters
        pessoa.setNome("José");
        pessoa.setIdade(25);
        
        // Acessa os valores usando os getters
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
    }
}

class Pessoa {
    // Variáveis privadas
    private String nome; 
    private int idade;
    
    // Getter para nome
    public String getNome() {
        return nome;
    }
    // Setter para nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    // Getter para idade
    public int getIdade() {
        return idade;
    }
    // Setter para idade
    public void setIdade(int idade) {
        if (idade > 17) {
            this.idade = idade;
        } else {
            System.out.println("Idade inválida! Deve ser maior que 17.");
        }
    }
}
