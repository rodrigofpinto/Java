package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.RenderingHints;

// Simulação de uma bola em queda livre com gravidade e atrito
public class GravidadeComAtrito2 extends JPanel {
    private static final long serialVersionUID = 1L;

    // Variáveis de posição e velocidade
    private double x = 50; // Posição inicial X
    private double y = 50; // Posição inicial Y
    private double velocidadeX = 100; // Velocidade horizontal inicial
    private double velocidadeY = 0; // Velocidade vertical inicial
    private final double gravidade = 500; // Aceleração da gravidade
    private final double atrito = 0.95; // Fator de atrito (reduz velocidade horizontal)
    private long ultimoTempo; // Controle de tempo para atualização da simulação
    private final int chao = 350; // Posição do chão no eixo Y
    private final double amortecimento = 0.8; // Redução da velocidade após colisão

    // Construtor da classe
    public GravidadeComAtrito2() {
        ultimoTempo = System.nanoTime(); // Captura o tempo inicial

        // Configuração do Timer para atualizar a cada 16ms (~60FPS)
        Timer timer = new Timer(16, e -> {
            long tempoAtual = System.nanoTime();
            double dt = (tempoAtual - ultimoTempo) / 1.0e9; // Tempo decorrido em segundos
            ultimoTempo = tempoAtual;

            // Aplica a gravidade à velocidade vertical
            velocidadeY += gravidade * dt;
            y += velocidadeY * dt;
            x += velocidadeX * dt;

            // Verifica colisão com o chão
            if (y > chao) {
                y = chao; // Mantém a bola no chão
                velocidadeY = -velocidadeY * amortecimento; // Inverte e reduz a velocidade (quique)

                // Se a velocidade for muito baixa, para a movimentação vertical
                if (Math.abs(velocidadeY) < 10) {
                    velocidadeY = 0;
                }
            }

            // Aplica o atrito à velocidade horizontal quando a bola está no chão
            if (y >= chao) {
                velocidadeX *= atrito;
                if (Math.abs(velocidadeX) < 0.1) {
                    velocidadeX = 0; // Para completamente se for muito pequeno
                }
            }

            repaint(); // Redesenha a tela
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define o fundo branco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Desenha a bola azul
        g2d.setColor(Color.BLUE);
        g2d.fillOval((int) Math.round(x), (int) Math.round(y), 20, 20);

        // Desenha o chão como um retângulo preto
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, chao + 20, getWidth(), 10);
    }

    public static void main(String[] args) {
        // Criação da janela
        JFrame frame = new JFrame("Gravidade Com Atrito");
        GravidadeComAtrito2 panel = new GravidadeComAtrito2();
        frame.add(panel);
        frame.setSize(400, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
