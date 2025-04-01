package fisica;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Simulação de Partículas - Chuva
public class SimulacaoParticulas extends JPanel {
    private static final long serialVersionUID = 1L;

    // Lista de partículas
    private final ArrayList<Particula> particulas = new ArrayList<>();
    private final Random random = new Random();

    public SimulacaoParticulas() {
        // Timer para atualizar a animação a cada 16ms (~60 FPS)
        Timer timer = new Timer(16, e -> atualizar());
        timer.start();
    }

    private void atualizar() {
        // Atualiza todas as partículas
        Iterator<Particula> iterator = particulas.iterator();
        while (iterator.hasNext()) {
            Particula p = iterator.next();
            p.atualizar();
            if (p.y > getHeight()) {
                iterator.remove(); // Remove partículas que saíram da tela
            }
        }

        // Adiciona novas partículas
        if (particulas.size() < 100) {
            int largura = Math.max(getWidth(), 1); // Evita getWidth() ser 0
            particulas.add(new Particula(random.nextInt(largura), 0));
        }

        // Redesenha a tela
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Ativa o anti-aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define fundo preto
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Desenha as partículas em ciano
        g2d.setColor(Color.CYAN);
        for (Particula p : particulas) {
            g2d.fillOval((int) p.x, (int) p.y, 4, 4);
        }
    }

    public static void main(String[] args) {
        // Configuração da janela
        JFrame frame = new JFrame("Simulação de Partículas - Chuva");
        SimulacaoParticulas panel = new SimulacaoParticulas();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// Classe que representa uma partícula
class Particula {
    double x, y, velocidadeY;

    public Particula(double x, double y) {
        this.x = x;
        this.y = y;

        // Define uma velocidade aleatória entre 2 e 6
        this.velocidadeY = 2 + Math.random() * 4;
    }

    // Atualiza a posição da partícula
    public void atualizar() {
        y += velocidadeY;
    }
}
