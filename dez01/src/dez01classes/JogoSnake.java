package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class JogoSnake extends JPanel implements ActionListener {
    // Definindo constantes do jogo
    private final int TAMANHO_CELULA = 25;  // Tamanho de cada célula da grade do jogo
    private final int LARGURA = 800;  // Largura da tela do jogo
    private final int ALTURA = 600;  // Altura da tela do jogo
    private final int NUM_CELULAS_X = LARGURA / TAMANHO_CELULA;  // Número de células na direção X
    private final int NUM_CELULAS_Y = ALTURA / TAMANHO_CELULA;  // Número de células na direção Y

    private LinkedList<Point> cobra;  // A cobra é representada por uma lista de pontos
    private Point comida;  // A posição da comida no jogo
    private boolean jogando = true;  // Flag para verificar se o jogo está em andamento
    private int direcao = KeyEvent.VK_RIGHT;  // Direção inicial da cobra (direita)

    private Timer timer;  // O timer controla a velocidade do jogo

    public JogoSnake() {
        // Configurações iniciais do painel
        setPreferredSize(new Dimension(LARGURA, ALTURA));  // Tamanho da tela
        setBackground(Color.BLACK);  // Cor de fundo preta
        setFocusable(true);  // Permite que o painel receba eventos de teclado

        // Adiciona um ouvinte para as teclas pressionadas
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Controle de direção com as setas do teclado
                if (e.getKeyCode() == KeyEvent.VK_UP && direcao != KeyEvent.VK_DOWN) {
                    direcao = KeyEvent.VK_UP;  // Cima
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && direcao != KeyEvent.VK_UP) {
                    direcao = KeyEvent.VK_DOWN;  // Baixo
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT && direcao != KeyEvent.VK_RIGHT) {
                    direcao = KeyEvent.VK_LEFT;  // Esquerda
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && direcao != KeyEvent.VK_LEFT) {
                    direcao = KeyEvent.VK_RIGHT;  // Direita
                }
            }
        });

        initJogo();  // Inicializa o estado do jogo
    }

    public void initJogo() {
        // Inicializa a cobra e a comida
        cobra = new LinkedList<>();
        cobra.add(new Point(NUM_CELULAS_X / 2, NUM_CELULAS_Y / 2));  // A cobra começa no centro da tela
        gerarComida();  // Gera a primeira comida

        jogando = true;  // O jogo começa
        if (timer == null) {
            timer = new Timer(100, this);  // Define a velocidade do jogo (100 ms por movimento)
            timer.start();  // Inicia o timer
        } else {
            timer.start();  // Reinicia o timer se já existir
        }
    }

    public void gerarComida() {
        // Gera uma comida em uma posição aleatória dentro da tela
        Random random = new Random();
        comida = new Point(random.nextInt(NUM_CELULAS_X), random.nextInt(NUM_CELULAS_Y));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica se o jogo acabou
        if (!jogando) {
            initJogo();  // Reinicia o jogo
            timer.restart();  // Reinicia o cronômetro
            return;
        }

        // Move a cobra
        Point cabeca = cobra.getFirst();  // Pega a posição da cabeça da cobra
        Point novaCabeca = null;  // A nova posição da cabeça será calculada com base na direção

        // Movimentos da cobra
        switch (direcao) {
            case KeyEvent.VK_UP:
                novaCabeca = new Point(cabeca.x, cabeca.y - 1);  // Cima
                break;
            case KeyEvent.VK_DOWN:
                novaCabeca = new Point(cabeca.x, cabeca.y + 1);  // Baixo
                break;
            case KeyEvent.VK_LEFT:
                novaCabeca = new Point(cabeca.x - 1, cabeca.y);  // Esquerda
                break;
            case KeyEvent.VK_RIGHT:
                novaCabeca = new Point(cabeca.x + 1, cabeca.y);  // Direita
                break;
        }

        // Verifica se a cobra comeu a comida
        if (novaCabeca.equals(comida)) {
            cobra.addFirst(novaCabeca);  // Adiciona a nova cabeça à cobra
            gerarComida();  // Gera uma nova comida
        } else {
            cobra.addFirst(novaCabeca);  // Move a cabeça da cobra
            cobra.removeLast();  // Remove a cauda da cobra
        }

        // Verifica se a cobra colidiu com algo
        if (checarColisoes()) {
            jogando = false;  // O jogo terminou
            return;  // A colisão foi detectada, o jogo será reiniciado
        }

        repaint();  // Redesenha o painel (atualiza a tela)
    }

    public boolean checarColisoes() {
        Point cabeca = cobra.getFirst();  // Pega a posição da cabeça da cobra

        // Verifica se a cobra colidiu com as bordas
        if (cabeca.x < 0 || cabeca.x >= NUM_CELULAS_X || cabeca.y < 0 || cabeca.y >= NUM_CELULAS_Y) {
            return true;  // Colisão com a borda
        }

        // Verifica se a cobra colidiu com seu próprio corpo
        for (int i = 1; i < cobra.size(); i++) {
            if (cobra.get(i).equals(cabeca)) {
                return true;  // Colisão com o corpo
            }
        }

        return false;  // Sem colisão
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a cobra
        g.setColor(Color.GREEN);  // Cor verde para a cobra
        for (Point ponto : cobra) {
            g.fillRect(ponto.x * TAMANHO_CELULA, ponto.y * TAMANHO_CELULA, TAMANHO_CELULA, TAMANHO_CELULA);  // Desenha cada célula da cobra
        }

        // Desenha a comida
        g.setColor(Color.RED);  // Cor vermelha para a comida
        g.fillRect(comida.x * TAMANHO_CELULA, comida.y * TAMANHO_CELULA, TAMANHO_CELULA, TAMANHO_CELULA);  // Desenha a comida

    }

    public static void main(String[] args) {
        // Cria a janela do jogo
        JFrame frame = new JFrame("Jogo da Cobra");
        JogoSnake jogo = new JogoSnake();  // Cria uma instância do jogo
        frame.add(jogo);  // Adiciona o painel do jogo à janela
        frame.pack();  // Ajusta o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Define o comportamento ao fechar a janela
        frame.setVisible(true);  // Exibe a janela
    }
}
