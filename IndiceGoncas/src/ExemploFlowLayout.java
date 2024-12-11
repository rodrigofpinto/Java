// 7. Exemplo de Layout: FlowLayout
// Este exemplo pode ser salvo em um arquivo chamado "ExemploFlowLayout.java"
import javax.swing.*;
import java.awt.*;

public class ExemploFlowLayout {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo FlowLayout");
        janela.setLayout(new FlowLayout()); // Define o layout como FlowLayout

        janela.add(new JButton("Botão 1")); // Adiciona botão
        janela.add(new JButton("Botão 2"));
        janela.add(new JButton("Botão 3"));

        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}