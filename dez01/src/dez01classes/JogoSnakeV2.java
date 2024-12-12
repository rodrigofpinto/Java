package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class JogoSnakeV2 extends JPanel implements ActionListener {
    // Constantes para o tamanho do jogo e das células
    private final int TAMANHO_CELULA = 25;
    private final int LARGURA = 800;
    private final int ALTURA = 600;
    private final int NUM_CELULAS_X = LARGURA / TAMANHO_CELULA;
    private final int NUM_CELULAS_Y = ALTURA / TAMANHO_CELULA;

    // Variáveis do jogo
    private LinkedList<Point> cobra = new LinkedList<>(); // Lista que armazena as posições da cobra
    private Point comida; // Posição atual da comida
    private boolean jogando = false; // Indica se o jogo está ativo
    private int direcao = KeyEvent.VK_RIGHT; // Direção inicial da cobra
    private int pontuacao = 0; // Pontuação do jogador

    // Componentes e controladores
    private Timer timer; // Controlador de tempo para movimentar a cobra periodicamente
    private JButton iniciarJogoButton; // Botão para iniciar o jogo
    private JLabel pontuacaoLabel; // Label para exibir a pontuação
    private JButton reiniciarJogoButton; // Botão para reiniciar o jogo

    public JogoSnakeV2() {
        // Configurações iniciais do painel
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        setBackground(Color.BLACK);
        setFocusable(true);

        // Inicialização dos componentes gráficos
        pontuacaoLabel = new JLabel("Pontuação: 0", JLabel.CENTER);
        pontuacaoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pontuacaoLabel.setForeground(Color.WHITE);
        pontuacaoLabel.setOpaque(false);

        iniciarJogoButton = new JButton("Clique aqui para começar");
        reiniciarJogoButton = new JButton("Jogar novamente");
        reiniciarJogoButton.setVisible(false);

        // Configuração da ação do botão "Iniciar Jogo"
        iniciarJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo();
            }
        });

        // Configuração da ação do botão "Reiniciar Jogo"
        reiniciarJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo();
            }
        });

        // Configuração do layout da interface
        setLayout(new BorderLayout());
        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Painel superior com a pontuação
        painelSuperior.setBackground(Color.BLACK);
        painelSuperior.add(pontuacaoLabel);
        add(painelSuperior, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(); // Painel central com o botão de início
        painelCentral.setOpaque(false);
        painelCentral.add(iniciarJogoButton);
        add(painelCentral, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(); // Painel inferior com o botão de reinício
        painelInferior.setOpaque(false);
        painelInferior.add(reiniciarJogoButton);
        add(painelInferior, BorderLayout.SOUTH);

        // Adiciona o ouvinte para controlar as teclas de direção
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!jogando) return; // Ignora teclas se o jogo não estiver ativo

                // Altera a direção com base na tecla pressionada
                if (e.getKeyCode() == KeyEvent.VK_UP && direcao != KeyEvent.VK_DOWN) {
                    direcao = KeyEvent.VK_UP;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && direcao != KeyEvent.VK_UP) {
                    direcao = KeyEvent.VK_DOWN;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT && direcao != KeyEvent.VK_RIGHT) {
                    direcao = KeyEvent.VK_LEFT;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && direcao != KeyEvent.VK_LEFT) {
                    direcao = KeyEvent.VK_RIGHT;
                }
            }
        });
    }

    public void iniciarJogo() {
        // Reinicia a cobra e coloca o primeiro segmento no centro
        cobra.clear();
        cobra.add(new Point(NUM_CELULAS_X / 2, NUM_CELULAS_Y / 2));

        gerarComida(); // Gera a posição inicial da comida
        pontuacao = 0; // Reinicia a pontuação
        jogando = true; // Ativa o estado do jogo

        // Configuração do temporizador para movimentar a cobra
        iniciarJogoButton.setVisible(false);
        reiniciarJogoButton.setVisible(false);
        timer = new Timer(100, this);
        timer.start();
    }

    public void reiniciarJogo() {
        // Reinicia as variáveis do jogo para os valores iniciais
        cobra.clear();
        cobra.add(new Point(NUM_CELULAS_X / 2, NUM_CELULAS_Y / 2));
        gerarComida();
        pontuacao = 0;
        direcao = KeyEvent.VK_RIGHT;
        jogando = true;

        reiniciarJogoButton.setVisible(false);
        iniciarJogoButton.setVisible(false);
        timer.start();
        repaint(); // Atualiza o desenho do painel
    }

    public void gerarComida() {
        // Gera uma nova posição aleatória para a comida
        Random random = new Random();
        comida = new Point(random.nextInt(NUM_CELULAS_X), random.nextInt(NUM_CELULAS_Y));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jogando) {
            return; // Não executa se o jogo não está ativo
        }

        Point cabeca = cobra.getFirst(); // Obtém a posição da cabeça da cobra
        Point novaCabeca = null;

        // Determina a nova posição da cabeça com base na direção
        switch (direcao) {
            case KeyEvent.VK_UP:
                novaCabeca = new Point(cabeca.x, cabeca.y - 1);
                break;
            case KeyEvent.VK_DOWN:
                novaCabeca = new Point(cabeca.x, cabeca.y + 1);
                break;
            case KeyEvent.VK_LEFT:
                novaCabeca = new Point(cabeca.x - 1, cabeca.y);
                break;
            case KeyEvent.VK_RIGHT:
                novaCabeca = new Point(cabeca.x + 1, cabeca.y);
                break;
        }

        // Verifica se a cobra comeu a comida
        if (novaCabeca.equals(comida)) {
            cobra.addFirst(novaCabeca); // Adiciona um novo segmento
            pontuacao++;
            gerarComida(); // Gera uma nova posição para a comida
        } else {
            cobra.addFirst(novaCabeca); // Move a cobra
            cobra.removeLast(); // Remove o último segmento
        }

        if (checarColisoes()) {
            jogando = false; // Termina o jogo se houver colisão
            timer.stop();
            reiniciarJogoButton.setVisible(true);
        }

        pontuacaoLabel.setText("Pontuação: " + pontuacao); // Atualiza a pontuação
        repaint(); // Redesenha o painel
    }

    public boolean checarColisoes() {
        Point cabeca = cobra.getFirst();

        // Verifica colisões com as bordas do painel
        if (cabeca.x < 0 || cabeca.x >= NUM_CELULAS_X || cabeca.y < 0 || cabeca.y >= NUM_CELULAS_Y) {
            return true;
        }

        // Verifica colisões com o próprio corpo
        for (int i = 1; i < cobra.size(); i++) {
            if (cobra.get(i).equals(cabeca)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (cobra.isEmpty()) {
            return; // Não desenha nada se o jogo ainda não começou
        }

        // Desenha a cobra
        g.setColor(Color.GREEN);
        for (Point ponto : cobra) {
        	//g.fillRect(x, y, largura, altura);
            g.fillRect(ponto.x * TAMANHO_CELULA, ponto.y * TAMANHO_CELULA, TAMANHO_CELULA, TAMANHO_CELULA);
        }

        // Desenha a comida
        if (comida != null) {
            g.setColor(Color.RED);
            g.fillRect(comida.x * TAMANHO_CELULA, comida.y * TAMANHO_CELULA, TAMANHO_CELULA, TAMANHO_CELULA);
        }

        // Exibe mensagem de fim de jogo
        if (!jogando) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Perdeu com " + pontuacao + " pontos", LARGURA / 4, ALTURA / 2);
        }
    }

    public static void main(String[] args) {
        // Cria e exibe a janela principal do jogo
        JFrame frame = new JFrame("Jogo da Cobra");
        JogoSnakeV2 jogo = new JogoSnakeV2();
        frame.add(jogo);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
