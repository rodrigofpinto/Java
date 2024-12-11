// 2. Exemplo de JButton
// Este exemplo pode ser salvo em um arquivo chamado "ExemploBotao.java"
import javax.swing.*;

public class ExemploBotao {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo de Botão");
        JButton botao = new JButton("Clique aqui"); // Cria um botão

        janela.add(botao); // Adiciona o botão à janela
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}