package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class JogoPongV3 extends JPanel implements ActionListener {
    private final int TAMANHO_CELULA = 25;
    private final int LARGURA = 800;
    private final int ALTURA = 600;
    private final int NUM_CELULAS_X = LARGURA / TAMANHO_CELULA;
    private final int NUM_CELULAS_Y = ALTURA / TAMANHO_CELULA;

    private LinkedList<Point> cobra;
    private Point comida;
    private boolean jogando = false;
    private int direcao = KeyEvent.VK_RIGHT;
    private int pontuacao = 0;

    private Timer timer;
    private JButton iniciarJogoButton;
    private JLabel pontuacaoLabel;
    private JButton reiniciarJogoButton;

    public JogoPongV3() {
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        setBackground(Color.BLACK);
        setFocusable(true);

        // Inicializando os componentes gráficos
        pontuacaoLabel = new JLabel("Pontuação: 0", JLabel.CENTER);
        pontuacaoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pontuacaoLabel.setForeground(Color.WHITE);
        pontuacaoLabel.setOpaque(false); // Sem fundo

        iniciarJogoButton = new JButton("Clique aqui para começar");
        reiniciarJogoButton = new JButton("Jogar novamente");
        reiniciarJogoButton.setVisible(false);

        // Ação do botão iniciar
        iniciarJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo();
            }
        });

        // Ação do botão reiniciar
        reiniciarJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo();
            }
        });

        // Configurar a tela
        setLayout(new BorderLayout());
        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Alinha no centro
        painelSuperior.setBackground(Color.BLACK);
        painelSuperior.add(pontuacaoLabel);
        add(painelSuperior, BorderLayout.NORTH);

        // Painel para centralizar o botão de "Começar"
        JPanel painelCentral = new JPanel();
        painelCentral.setOpaque(false); // Não ter fundo
        painelCentral.add(iniciarJogoButton);
        add(painelCentral, BorderLayout.CENTER);
        
        // Botão de reiniciar no fundo
        JPanel painelInferior = new JPanel();
        painelInferior.setOpaque(false); // Não ter fundo
        painelInferior.add(reiniciarJogoButton);
        add(painelInferior, BorderLayout.SOUTH);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!jogando) return;
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
        cobra = new LinkedList<>();
        cobra.add(new Point(NUM_CELULAS_X / 2, NUM_CELULAS_Y / 2));
        gerarComida();
        pontuacao = 0;
        jogando = true;
        iniciarJogoButton.setVisible(false);
        reiniciarJogoButton.setVisible(false);
        timer = new Timer(100, this);
        timer.start();
    }

    public void reiniciarJogo() {
        cobra.clear();
        gerarComida();
        pontuacao = 0;
        direcao = KeyEvent.VK_RIGHT;
        jogando = true;
        reiniciarJogoButton.setVisible(false);
        iniciarJogoButton.setVisible(false);
        timer.start();
        repaint();
    }

    public void gerarComida() {
        Random random = new Random();
        comida = new Point(random.nextInt(NUM_CELULAS_X), random.nextInt(NUM_CELULAS_Y));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jogando) {
            return;
        }

        Point cabeca = cobra.getFirst();
        Point novaCabeca = null;

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

        if (novaCabeca.equals(comida)) {
            cobra.addFirst(novaCabeca);
            pontuacao++;
            gerarComida();
        } else {
            cobra.addFirst(novaCabeca);
            cobra.removeLast();
        }

        if (checarColisoes()) {
            jogando = false;
            timer.stop();
            reiniciarJogoButton.setVisible(true);
        }

        pontuacaoLabel.setText("Pontuação: " + pontuacao);
        repaint();
    }

    public boolean checarColisoes() {
        Point cabeca = cobra.getFirst();

        // Colisão com as bordas
        if (cabeca.x < 0 || cabeca.x >= NUM_CELULAS_X || cabeca.y < 0 || cabeca.y >= NUM_CELULAS_Y) {
            return true;
        }

        // Colisão com o próprio corpo
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

        // Desenha a cobra
        g.setColor(Color.GREEN);
        for (Point ponto : cobra) {
            g.fillRect(ponto.x * TAMANHO_CELULA, ponto.y * TAMANHO_CELULA, TAMANHO_CELULA, TAMANHO_CELULA);
        }

        // Desenha a comida
        g.setColor(Color.RED);
        g.fillRect(comida.x * TAMANHO_CELULA, comida.y * TAMANHO_CELULA, TAMANHO_CELULA, TAMANHO_CELULA);

        // Se o jogo acabou, exibe uma mensagem
        if (!jogando) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Perdeu com " + pontuacao + " pontos", LARGURA / 4, ALTURA / 2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo da Cobra");
        JogoPongV3 jogo = new JogoPongV3();
        frame.add(jogo);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
