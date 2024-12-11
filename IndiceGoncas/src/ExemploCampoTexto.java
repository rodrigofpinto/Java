// 4. Exemplo de JTextField
// Este exemplo pode ser salvo em um arquivo chamado "ExemploCampoTexto.java"
import javax.swing.*;

public class ExemploCampoTexto {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo de Campo de Texto");
        JTextField campoTexto = new JTextField("Digite algo aqui..."); // Cria um campo de texto

        janela.add(campoTexto); // Adiciona o campo de texto à janela
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}