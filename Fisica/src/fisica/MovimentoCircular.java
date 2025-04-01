package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;

public class MovimentoCircular extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;

    // Definições iniciais de parâmetros para o movimento circular
    private double angulo = 0; // Ângulo inicial em radianos
    private double velocidadeAngular = 0; // Velocidade inicial de rotação
    private final int RAIO = 100; // Raio da órbita (distância do centro ao ponto de movimento)
    private final double ACELERACAO = 0.005; // Taxa de aceleração ao pressionar as teclas de direção
    private final double ATRITO = 0.99; // Redução gradual de velocidade a cada atualização (simula o atrito)
    private Timer timer; // Timer que controlará o movimento e a atualização do painel

    public MovimentoCircular() {
        // Configuração do painel para escutar eventos de teclado
        setFocusable(true); // Permite que o painel receba eventos de teclado

        // Configuração do KeyListener para capturar as teclas pressionadas
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Se pressionar a tecla para a direita, aumenta a velocidade angular (rotação no sentido horário)
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    velocidadeAngular += ACELERACAO;
                }
                // Se pressionar a tecla para a esquerda, diminui a velocidade angular (rotação no sentido anti-horário)
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    velocidadeAngular -= ACELERACAO;
                }
            }
        });

        // Criação do timer que chama o método actionPerformed a cada 16ms (aproximadamente 60FPS)
        timer = new Timer(1, this);
        timer.start(); // Inicia o timer
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // A cada atualização, a velocidade angular diminui um pouco devido ao atrito
        velocidadeAngular *= ATRITO;
        // Atualiza o ângulo com a velocidade angular
        angulo += velocidadeAngular;
        // Solicita a atualização da tela (redesenho do painel)
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        // Redesenha o conteúdo do painel
        super.paintComponent(g);

        // Configura a cor de fundo para preto
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight()); // Preenche o fundo com preto

        // Calcula o centro do painel
        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;

        // Calcula a posição do objeto que se move ao longo do círculo
        int x = centroX + (int) (RAIO * Math.cos(angulo));
        int y = centroY + (int) (RAIO * Math.sin(angulo));

        // Desenha a órbita (círculo)
        g.setColor(Color.WHITE);
        g.drawOval(centroX - RAIO, centroY - RAIO, RAIO * 2, RAIO * 2);

        // Desenha o objeto (ponto vermelho) na posição calculada
        g.setColor(Color.RED);
        g.fillOval(x - 10, y - 10, 20, 20); // Ponto vermelho de 20x20px
    }

    public static void main(String[] args) {
        // Criação do JFrame para exibir o painel com o movimento circular
        JFrame frame = new JFrame("Movimento circular");
        MovimentoCircular panel = new MovimentoCircular();
        frame.add(panel); // Adiciona o painel ao JFrame
        frame.setSize(400, 400); // Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento de fechamento da janela
        frame.setVisible(true); // Exibe a janela
    }
}
