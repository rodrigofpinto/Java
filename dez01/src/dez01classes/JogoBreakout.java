package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JogoBreakout extends JPanel implements ActionListener {
    // Definições de tamanho da tela, paddle e bola
    private static final int LARGURA = 800, ALTURA = 600;
    private static final int LARGURA_PADDLE = 100, ALTURA_PADDLE = 20;
    private static final int TAMANHO_BOLA = 20;
    private static final int NUMERO_DE_LINHAS = 5, NUMERO_DE_COLUNAS = 8;

    // Posições da bola
    private int bolaX = LARGURA / 2, bolaY = ALTURA - 50;
    private int bolaDX = -2, bolaDY = -2;

    // Posições da barra (paddle) do jogador
    private int paddleX = LARGURA / 2 - LARGURA_PADDLE / 2;
    private int paddleDY = 0;

    // Blocos para destruição
    private boolean[][] blocos = new boolean[NUMERO_DE_LINHAS][NUMERO_DE_COLUNAS];

    // Timer para atualização de tela
    private Timer timer;

    // Variáveis para controle do jogo
    private boolean jogoEmAndamento = false;
    private int pontos = 0;

    // Componentes da interface
    private JButton iniciarButton;
    private JLabel fimJogoLabel;

    // Construtor da classe JogoBreakout
    public JogoBreakout() {
        // Define o tamanho do painel e a cor de fundo
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        setBackground(Color.BLACK);
        setLayout(null); // Usar layout nulo para posicionar componentes manualmente

        // Botão "Clique aqui para começar"
        iniciarButton = new JButton("Clique aqui para começar");
        iniciarButton.setBounds(LARGURA / 2 - 150, ALTURA / 2 - 20, 300, 40);
        iniciarButton.setFont(new Font("Arial", Font.PLAIN, 18));
        iniciarButton.addActionListener(e -> iniciarJogo());
        add(iniciarButton);

        // Label para mostrar a pontuação final
        fimJogoLabel = new JLabel("", SwingConstants.CENTER);
        fimJogoLabel.setBounds(0, ALTURA / 2 - 30, LARGURA, 40);
        fimJogoLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        fimJogoLabel.setForeground(Color.WHITE);
        fimJogoLabel.setVisible(false);
        add(fimJogoLabel);

        // Permite que o painel tenha foco para capturar eventos do teclado
        setFocusable(true);

        // Adiciona os listeners para as teclas de movimento
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Controle do movimento da barra (paddle)
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddleDY = -5; // Mover para a esquerda
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddleDY = 5; // Mover para a direita
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Quando a tecla é solta, para o movimento
                if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddleDY = 0;
                }
            }
        });
    }

    // Inicia o jogo
    private void iniciarJogo() {
        jogoEmAndamento = true;
        pontos = 0; // Reinicia a pontuação
        iniciarButton.setVisible(false); // Esconde o botão de iniciar
        fimJogoLabel.setVisible(false); // Esconde a label de fim de jogo
        reiniciarBola(); // Reinicia a bola
        inicializarBlocos(); // Reinicia os blocos
        timer = new Timer(1000 / 60, this); // 60 quadros por segundo
        timer.start();
    }

    // Método chamado a cada ciclo do timer (60 FPS)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jogoEmAndamento) return;

        // Atualiza a posição da bola e a barra
        moverBola();
        moverPaddle();
        verificarColisoes();

        // Repaint da tela para mostrar as atualizações
        repaint();
    }

    // Método para mover a bola
    private void moverBola() {
        // Atualiza a posição da bola com base na direção (velocidade)
        bolaX += bolaDX;
        bolaY += bolaDY;

        // Colisão com as paredes superior e inferior
        if (bolaY <= 0) {
            bolaDY = -bolaDY; // Rebater a bola
        }

        // Colisão com as paredes laterais
        if (bolaX <= 0 || bolaX >= LARGURA - TAMANHO_BOLA) {
            bolaDX = -bolaDX; // Rebater a bola
        }

        // Se a bola cair no chão, reinicia sua posição
        if (bolaY >= ALTURA - TAMANHO_BOLA) {
            fimDeJogo();
        }
    }

    // Método para mover a barra (paddle)
    private void moverPaddle() {
        paddleX += paddleDY;

        // Impede a barra de sair da tela
        if (paddleX < 0) paddleX = 0;
        if (paddleX > LARGURA - LARGURA_PADDLE) paddleX = LARGURA - LARGURA_PADDLE;
    }

    // Método para verificar colisões entre a bola e os blocos ou a barra
    private void verificarColisoes() {
        // Colisão com a barra (paddle)
        if (bolaY + TAMANHO_BOLA >= ALTURA - 50 && bolaY + TAMANHO_BOLA <= ALTURA - 30 &&
            bolaX + TAMANHO_BOLA >= paddleX && bolaX <= paddleX + LARGURA_PADDLE) {
            bolaDY = -bolaDY; // Rebater a bola
        }

        // Colisão com os blocos
        for (int i = 0; i < NUMERO_DE_LINHAS; i++) {
            for (int j = 0; j < NUMERO_DE_COLUNAS; j++) {
                if (blocos[i][j]) {
                    int blocoX = j * (LARGURA / NUMERO_DE_COLUNAS);
                    int blocoY = i * 30;
                    // Verifica se a bola colide com um bloco
                    if (bolaX + TAMANHO_BOLA >= blocoX && bolaX <= blocoX + LARGURA / NUMERO_DE_COLUNAS &&
                        bolaY + TAMANHO_BOLA >= blocoY && bolaY <= blocoY + 30) {
                        bolaDY = -bolaDY; // Rebater a bola
                        blocos[i][j] = false; // Destruir o bloco
                        pontos += 10; // Aumenta a pontuação
                    }
                }
            }
        }
    }

    // Método para reiniciar a bola quando ela cai no chão
    private void reiniciarBola() {
        bolaX = LARGURA / 2 - TAMANHO_BOLA / 2; // Reinicia a posição da bola no centro
        bolaY = ALTURA - 50;
        bolaDX = -2; // Reseta a direção da bola
        bolaDY = -2;
    }

    // Método para inicializar os blocos
    private void inicializarBlocos() {
        for (int i = 0; i < NUMERO_DE_LINHAS; i++) {
            for (int j = 0; j < NUMERO_DE_COLUNAS; j++) {
                blocos[i][j] = true; // Todos os blocos começam visíveis
            }
        }
    }

    // Método que é chamado quando o jogador perde
    private void fimDeJogo() {
        jogoEmAndamento = false;
        timer.stop(); // Para o timer

        // Exibe a pontuação final
        fimJogoLabel.setText("Perdeu com " + pontos + " pontos");
        fimJogoLabel.setVisible(true);

        // Adiciona botão "Jogar novamente"
        JButton jogarNovamenteButton = new JButton("Jogar novamente");
        jogarNovamenteButton.setBounds(LARGURA / 2 - 100, ALTURA / 2 + 20, 200, 40);
        jogarNovamenteButton.addActionListener(e -> reiniciarJogo());
        add(jogarNovamenteButton);
        repaint();
    }

    // Método para reiniciar o jogo
    private void reiniciarJogo() {
        // Reinicia a interface gráfica
        removeAll();
        pontos = 0;
        jogoEmAndamento = false;
        inicializarBlocos();
        repaint();
        iniciarJogo();
    }

    // Método para desenhar os elementos na tela
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!jogoEmAndamento) {
            return; // Não desenha nada se o jogo não estiver em andamento
        }

        // Desenha a barra (paddle)
        g.setColor(Color.WHITE);
        g.fillRect(paddleX, ALTURA - 30, LARGURA_PADDLE, ALTURA_PADDLE);

        // Desenha a bola
        g.fillRect(bolaX, bolaY, TAMANHO_BOLA, TAMANHO_BOLA);

        // Desenha os blocos
        for (int i = 0; i < NUMERO_DE_LINHAS; i++) {
            for (int j = 0; j < NUMERO_DE_COLUNAS; j++) {
                if (blocos[i][j]) {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * (LARGURA / NUMERO_DE_COLUNAS), i * 30, LARGURA / NUMERO_DE_COLUNAS, 30);
                }
            }
        }
    }

    // Método principal para inicializar e exibir o jogo
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo Breakout");
        JogoBreakout gamePanel = new JogoBreakout(); // Cria o painel do jogo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o jogo ao fechar a janela
        frame.add(gamePanel); // Adiciona o painel do jogo à janela
        frame.pack(); // Ajusta o tamanho da janela ao tamanho do painel
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true); // Torna a janela visível
    }
}
