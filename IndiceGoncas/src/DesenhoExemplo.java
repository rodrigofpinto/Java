// 6. Desenhando um círculo e uma linha
// Este exemplo pode ser salvo em um arquivo chamado "DesenhoExemplo.java"
import javax.swing.*;
import java.awt.*;

public class DesenhoExemplo extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(50, 50, 150, 50); // Desenha uma linha
        g.drawOval(100, 100, 50, 50); // Desenha um círculo
    }

    public static void main(String[] args) {
        JFrame janela = new JFrame("Desenho de Linha e Círculo");
        janela.add(new DesenhoExemplo()); // Adiciona o painel de desenho
        janela.setSize(300, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}