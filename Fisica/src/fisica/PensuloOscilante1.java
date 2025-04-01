package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PensuloOscilante1 extends JPanel implements ActionListener, KeyListener {

    private double angulo = Math.toRadians(30); // Ângulo inicial (em radianos)
    private double anguloVelocidade = 0; // Velocidade angular inicial
    private final double gravidade = 9.8; // Aceleração devido à gravidade (m/s²)
    private final double comprimento = 150; // Comprimento do pêndulo (em pixels)
    private final double amortecimento = 0.995; // Amortecimento para simular resistência do ar
    private Timer timer;

    public PensuloOscilante1() {
        setBackground(Color.BLACK); // Cor de fundo preta
        setFocusable(true);
        addKeyListener(this); // Adiciona KeyListener para capturar teclas
        timer = new Timer(16, this); // Atualiza a cada 16ms (~60 FPS)
        timer.start(); // Inicia a simulação
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Calcula a aceleração angular com base na Lei do Pêndulo
        double aceleracaoAngular = - (gravidade / comprimento) * Math.sin(angulo);

        // Atualiza a velocidade angular
        anguloVelocidade += aceleracaoAngular;

        // Aplica o amortecimento
        anguloVelocidade *= amortecimento;

        // Atualiza o ângulo com a velocidade angular
        angulo += anguloVelocidade;

        repaint(); // Atualiza a tela
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Posição do ponto fixo
        int pontoFixoX = getWidth() / 2;
        int pontoFixoY = 50;

        // Calcula a posição da massa com base no ângulo
        int massaX = pontoFixoX + (int) (comprimento * Math.sin(angulo));
        int massaY = pontoFixoY + (int) (comprimento * Math.cos(angulo));

        // Desenha o ponto fixo
        g.setColor(Color.WHITE);
        g.fillOval(pontoFixoX - 5, pontoFixoY - 5, 10, 10);

        // Desenha a haste do pêndulo
        g.setColor(Color.WHITE);
        g.drawLine(pontoFixoX, pontoFixoY, massaX, massaY);

        // Desenha a massa do pêndulo
        g.setColor(Color.RED);
        g.fillOval(massaX - 15, massaY - 15, 30, 30);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // Diminui o ângulo em 2 graus ao pressionar a seta para a esquerda
            angulo -= Math.toRadians(2);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // Aumenta o ângulo em 2 graus ao pressionar a seta para a direita
            angulo += Math.toRadians(2);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // Reinicia o movimento do pêndulo quando a tecla espaço for pressionada
            anguloVelocidade = 0; // Reseta a velocidade
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Não precisamos fazer nada aqui
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não precisamos fazer nada aqui
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulação do Pêndulo");
        PensuloOscilante1 painel = new PensuloOscilante1();
        frame.add(painel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
