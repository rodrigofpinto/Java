package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class JogoDesvio extends JPanel implements ActionListener {
    private static final int LARGURA = 800, ALTURA = 600;
    private static final int TAMANHO_QUADRADO = 30;
    private static final int VELOCIDADE_QUADRADOS_CAIENDO = 5;
    private static final int VELOCIDADE_JOGADOR = 10;
    private static final int NUM_QUADRADOS = 5;

    private int jogadorX = LARGURA / 2 - TAMANHO_QUADRADO / 2;
    private ArrayList<Rectangle> quadradosCaiendo = new ArrayList<>();
    private Timer timer;

    public JogoDesvio() {  
        setPreferredSize(new Dimension(LARGURA, ALTURA));  // Define o tamanho do painel para o jogo (LARGURA x ALTURA)
        setBackground(Color.BLACK); // Define a cor de fundo do painel como preto
        setFocusable(true);  // Torna o painel focado para receber eventos de teclado

        // Adiciona um ouvinte de teclado (key listener) para capturar as teclas pressionadas
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Detecta quando uma tecla é pressionada
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    jogadorX -= VELOCIDADE_JOGADOR; // Move o jogador para a esquerda
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    jogadorX += VELOCIDADE_JOGADOR; // Move o jogador para a direita
                }

                // Impede o jogador de sair da tela
                if (jogadorX < 0) jogadorX = 0;
                if (jogadorX > LARGURA - TAMANHO_QUADRADO) jogadorX = LARGURA - TAMANHO_QUADRADO;
            }
        });

        // Inicializa o timer para atualizar o jogo a cada 20 milissegundos (50 FPS)
        timer = new Timer(20, this);
        timer.start();  // Inicia o timer

        // Criação inicial dos quadrados caindo
        for (int i = 0; i < NUM_QUADRADOS; i++) {
            adicionarQuadradoCaiendo();  // Adiciona os quadrados que começam a cair
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Mover os quadrados que estão caindo
        for (Rectangle quadrado : quadradosCaiendo) {
            quadrado.y += VELOCIDADE_QUADRADOS_CAIENDO; // Faz cada quadrado cair na tela

            // Se o quadrado passar do fundo da tela, reinicia sua posição fora da tela
            if (quadrado.y > ALTURA) {
                quadrado.y = -TAMANHO_QUADRADO; // Coloca o quadrado fora da tela no topo
                quadrado.x = new Random().nextInt(LARGURA - TAMANHO_QUADRADO); // Nova posição aleatória em X
            }
        }

        // Verificar colisões entre o jogador e os quadrados que estão caindo
        for (Rectangle quadrado : quadradosCaiendo) {
            if (quadrado.intersects(new Rectangle(jogadorX, ALTURA - TAMANHO_QUADRADO, TAMANHO_QUADRADO, TAMANHO_QUADRADO))) {
                // Se o jogador colidir com um quadrado, reinicia o jogo
                reiniciarJogo();
                break;  // Interrompe o loop de colisões, pois o jogo já foi reiniciado
            }
        }

        // Repaint da tela para mostrar as atualizações
        repaint(); // Atualiza a tela
    }


    // Método para adicionar quadrados caindo com posição aleatória fora da tela
    private void adicionarQuadradoCaiendo() {
        // Gera uma posição aleatória fora da tela para o quadrado
        int posX = new Random().nextInt(LARGURA - TAMANHO_QUADRADO); // Posição aleatória em X
        int posY = -TAMANHO_QUADRADO - new Random().nextInt(ALTURA); // Garante que o quadrado inicie fora da tela (topo)
        quadradosCaiendo.add(new Rectangle(posX, posY, TAMANHO_QUADRADO, TAMANHO_QUADRADO)); // Adiciona à lista
    }


    // Método para reiniciar o jogo
    private void reiniciarJogo() {
        jogadorX = LARGURA / 2 - TAMANHO_QUADRADO / 2; // Reposiciona o jogador no centro
        quadradosCaiendo.clear(); // Limpa a lista de quadrados caindo
        for (int i = 0; i < NUM_QUADRADOS; i++) {
            adicionarQuadradoCaiendo(); // Adiciona novamente os quadrados caindo
        }
    }


    // Método para desenhar os elementos na tela
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Chama o método da classe mãe para garantir a limpeza da tela

        // Desenha o jogador (quadrado verde)
        g.setColor(Color.GREEN);
        g.fillRect(jogadorX, ALTURA - TAMANHO_QUADRADO, TAMANHO_QUADRADO, TAMANHO_QUADRADO);

        // Desenha os quadrados caindo (quadrados vermelhos)
        g.setColor(Color.RED);
        for (Rectangle quadrado : quadradosCaiendo) {
            g.fillRect(quadrado.x, quadrado.y, quadrado.width, quadrado.height);
        }
    }


    // Método principal para inicializar e exibir o jogo
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo de Desvio"); // Cria a janela do jogo
        JogoDesvio gamePanel = new JogoDesvio(); // Cria a instância do painel de jogo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura a ação ao fechar a janela
        frame.add(gamePanel);  // Adiciona o painel do jogo na janela
        frame.pack();  // Ajusta o tamanho da janela ao conteúdo
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true);  // Torna a janela visível
    }
}


