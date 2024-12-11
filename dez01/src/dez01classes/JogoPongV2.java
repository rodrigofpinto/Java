package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JogoPongV2 extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	// Definições de tamanho da tela, paddles e bola
    private static final int LARGURA = 800, ALTURA = 600;
    private static final int LARGURA_PADDLE = 20, ALTURA_PADDLE = 100;
    private static final int TAMANHO_BOLA = 20;

    // Posições iniciais da bola e movimentos
    private int bolaX = LARGURA / 2, bolaY = ALTURA / 2;
    private int bolaDX = -3, bolaDY = 3;

    // Posições das barras (paddles) dos jogadores
    private int jogador1Y = ALTURA / 2 - ALTURA_PADDLE / 2;
    private int jogador2Y = ALTURA / 2 - ALTURA_PADDLE / 2;

    // Velocidade de movimento das barras dos jogadores
    private int jogador1DY = 0, jogador2DY = 0;
    private int velocidadeBarra = 5; // Velocidade inicial das barras

    // Pontuação dos jogadores
    private int pontosJogador1 = 0;
    private int pontosJogador2 = 0;

    // Timer para atualização de tela
    private Timer timer;

    // Construtor da classe PongGame
    public JogoPongV2() {
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        setBackground(Color.BLACK);
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Controle do jogador 1 com as teclas W e S
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    jogador1DY = -velocidadeBarra; // Mover para cima
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    jogador1DY = velocidadeBarra; // Mover para baixo
                }

                // Controle do jogador 2 com as teclas ↑ e ↓
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jogador2DY = -velocidadeBarra; // Mover para cima
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jogador2DY = velocidadeBarra; // Mover para baixo
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Quando a tecla é solta, para o movimento
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                    jogador1DY = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jogador2DY = 0;
                }
            }
        });

        // Inicializa o timer para atualizar a tela a 240 FPS
        timer = new Timer(1000 / 240, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moverBola();
        moverPaddles();
        verificarColisoes();
        repaint();
    }

    private void moverBola() {
        bolaX += bolaDX;
        bolaY += bolaDY;

        if (bolaY <= 0 || bolaY >= ALTURA - TAMANHO_BOLA) {
            bolaDY = -bolaDY; // Rebater a bola
        }

        if (bolaX <= 0 || bolaX >= LARGURA - TAMANHO_BOLA) {
            bolaX = LARGURA / 2 - TAMANHO_BOLA / 2;
            bolaY = ALTURA / 2 - TAMANHO_BOLA / 2;
            bolaDX = -bolaDX;
            bolaDY = 3; // Reinicia a velocidade padrão
            velocidadeBarra = 5; // Reinicia a velocidade das barras
        }
    }

    private void moverPaddles() {
        jogador1Y += jogador1DY;
        jogador2Y += jogador2DY;

        if (jogador1Y < 0) jogador1Y = 0;
        if (jogador1Y > ALTURA - ALTURA_PADDLE) jogador1Y = ALTURA - ALTURA_PADDLE;
        if (jogador2Y < 0) jogador2Y = 0;
        if (jogador2Y > ALTURA - ALTURA_PADDLE) jogador2Y = ALTURA - ALTURA_PADDLE;
    }

    private void verificarColisoes() {
        if (bolaX <= LARGURA_PADDLE && bolaY + TAMANHO_BOLA >= jogador1Y && bolaY <= jogador1Y + ALTURA_PADDLE) {
            bolaDX = -bolaDX;
            pontosJogador1++; // Incrementa a pontuação do jogador 1
            aumentarVelocidade();
        }

        if (bolaX >= LARGURA - LARGURA_PADDLE - TAMANHO_BOLA && bolaY + TAMANHO_BOLA >= jogador2Y && bolaY <= jogador2Y + ALTURA_PADDLE) {
            bolaDX = -bolaDX;
            pontosJogador2++; // Incrementa a pontuação do jogador 2
            aumentarVelocidade();
        }
    }

    private void aumentarVelocidade() {
        if (Math.abs(bolaDX) < 10) {
            bolaDX += bolaDX > 0 ? 1 : -1;
        }
        if (Math.abs(bolaDY) < 10) {
            bolaDY += bolaDY > 0 ? 1 : -1;
        }
        if (velocidadeBarra < 15) {
            velocidadeBarra += 1; // Aumenta a velocidade das barras
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        // Desenhar as barras e a bola
        g.fillRect(0, jogador1Y, LARGURA_PADDLE, ALTURA_PADDLE);
        g.fillRect(LARGURA - LARGURA_PADDLE, jogador2Y, LARGURA_PADDLE, ALTURA_PADDLE);
        g.fillRect(bolaX, bolaY, TAMANHO_BOLA, TAMANHO_BOLA);

        // Exibir a pontuação
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Jogador 1: " + pontosJogador1, 50, 30);
        g.drawString("Jogador 2: " + pontosJogador2, LARGURA - 200, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo Pong V2");
        JogoPongV2 gamePanel = new JogoPongV2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
