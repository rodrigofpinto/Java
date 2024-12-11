// 3. Exemplo de JLabel
// Este exemplo pode ser salvo em um arquivo chamado "ExemploRotulo.java"
import javax.swing.*;

public class ExemploRotulo {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo de Rótulo");
        JLabel rotulo = new JLabel("Este é um rótulo."); // Cria um rótulo

        janela.add(rotulo); // Adiciona o rótulo à janela
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}