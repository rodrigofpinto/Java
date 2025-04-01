package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Classe que simula o lançamento de um projétil num ambiente gráfico usando Java Swing.
 */
public class SimulacaoProjetil extends JPanel implements ActionListener, KeyListener {
    private Timer timer; // Temporizador para atualizar o movimento dos projéteis
    private ArrayList<Projetil> projeteis; // Lista para armazenar os projéteis disparados
    private double angulo = Math.toRadians(45); // Ângulo inicial de lançamento (convertido para radianos)
    private double forca = 20; // Força inicial do disparo (módulo da velocidade)

    /**
     * Construtor da Simulação do Projétil.
     */
    public SimulacaoProjetil() {
        timer = new Timer(16, this); // Timer com intervalo de 16ms (~60 FPS)
        projeteis = new ArrayList<>(); // Inicializa a lista de projéteis
        setFocusable(true); // Permite que o painel receba eventos do teclado
        addKeyListener(this); // Registra a classe como ouvinte de eventos do teclado
        timer.start(); // Inicia o temporizador
    }

    /**
     * Atualiza o estado dos projéteis a cada tick do temporizador.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Projetil p : projeteis) {
            p.mover(); // Move cada projétil
        }
        repaint(); // Redesenha a tela
    }

    /**
     * Método responsável por desenhar todos os elementos gráficos no painel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenhar plataforma de disparo (um pequeno retângulo preto na base)
        g.setColor(Color.BLACK);
        g.fillRect(50, getHeight() - 20, 100, 10);

        // Desenhar todos os projéteis em movimento
        for (Projetil p : projeteis) {
            p.desenhar(g);
        }

        // Desenhar a linha representando o ângulo do disparo
        g.setColor(Color.RED);
        int x1 = 100;
        int y1 = getHeight() - 20;
        int x2 = x1 + (int) (50 * Math.cos(angulo));
        int y2 = y1 - (int) (50 * Math.sin(angulo)); // Subtrai porque a coordenada Y cresce para baixo
        g.drawLine(x1, y1, x2, y2);

        // Exibir informações sobre o ângulo e a força do disparo
        g.drawString("Ângulo: " + Math.toDegrees(angulo) + "º", 10, 20);
        g.drawString("Força: " + forca, 10, 40);
        g.drawString("Setas: Esquerda/Direita = força | Cima/Baixo = ângulo | Espaço = Disparar", 10, 60);
    }

    /**
     * Captura eventos do teclado para modificar o ângulo e a força ou disparar um projétil.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            angulo -= Math.toRadians(5); // Diminui o ângulo (vira para cima)
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            angulo += Math.toRadians(5); // Aumenta o ângulo (vira para baixo)
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            forca = Math.max(5, forca - 2); // Reduz a força do disparo, com um mínimo de 5
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            forca = Math.min(50, forca + 2); // Aumenta a força do disparo, com um máximo de 50
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // Adiciona um novo projétil à lista com a posição inicial e os parâmetros ajustados
            projeteis.add(new Projetil(100, getHeight() - 20, forca, angulo));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Não utilizado, mas necessário para implementar KeyListener
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não utilizado, mas necessário para implementar KeyListener
    }

    /**
     * Método principal que cria a janela da simulação.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulação de Projétil");
        SimulacaoProjetil panel = new SimulacaoProjetil();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/**
 * Classe que representa um projétil em movimento.
 */
class Projetil {
    private double x, y; // Posição do projétil
    private double velocidadeX, velocidadeY; // Componentes da velocidade do projétil
    private final double gravidade = 0.5; // Intensidade da gravidade que afeta o movimento vertical

    /**
     * Construtor do projétil.
     *
     * @param x       Posição inicial X
     * @param y       Posição inicial Y
     * @param forca   Intensidade do disparo (magnitude da velocidade)
     * @param angulo  Ângulo de disparo em radianos
     */
    public Projetil(double x, double y, double forca, double angulo) {
        this.x = x;
        this.y = y;
        this.velocidadeX = forca * Math.cos(angulo); // Componente horizontal da velocidade
        this.velocidadeY = -forca * Math.sin(angulo); // Componente vertical da velocidade (negativo porque sobe)
    }

    /**
     * Atualiza a posição do projétil a cada frame.
     */
    public void mover() {
        x += velocidadeX; // Movimento horizontal
        y += velocidadeY; // Movimento vertical
        velocidadeY += gravidade; // Aplicação da gravidade
    }

    /**
     * Desenha o projétil na tela.
     *
     * @param g Objeto Graphics usado para desenhar
     */
    public void desenhar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval((int) x, (int) y, 10, 10); // Desenha um círculo azul representando o projétil
    }
}
