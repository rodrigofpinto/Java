package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;

/**
 * Simulação de uma mola oscilando com ativação por tecla.
 * A mola segue a Lei de Hooke e tem amortecimento gradual.
 */
public class SimulacaoMola extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L; // Evita warnings de serialização

    // Posição de equilíbrio da mola e posição inicial da massa suspensa
    private int baseY = 200;
    private int posY = baseY;

    // Propriedades físicas da mola e do sistema
    private double velocidade = 0; // Velocidade inicial da oscilação
    private final double K = 0.1; // Constante elástica da mola (quanto maior, mais rígida)
    private final double MASSA = 5; // Massa do objeto pendurado
    private final double ATRITO = 0.02; // Amortecimento (quanto maior, mais rápido para de oscilar)

    private Timer timer; // Timer para atualizar a simulação
    private boolean oscilando = false; // Indica se a mola está em movimento

    /**
     * Construtor da Simulação da Mola.
     */
    public SimulacaoMola() {
        setFocusable(true); // Permite que o JPanel receba eventos de teclado
        addKeyListener(new KeyAdapter() { // Adiciona um ouvinte de teclado
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) { // Se a tecla espaço for pressionada
                    if (!oscilando) {
                        oscilando = true; // Ativa a oscilação
                        velocidade = 5; // Dá um impulso inicial à massa suspensa
                    }
                }
            }
        });

        timer = new Timer(16, this); // Atualiza a cada 16ms (~60 FPS)
        timer.start(); // Inicia a simulação
    }

    /**
     * Atualiza a posição da mola com base na física do sistema.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (oscilando) {
            // Calcula a força restauradora usando a Lei de Hooke: F = -k * x
            double forcaMola = -K * (posY - baseY);
            
            // Calcula a aceleração com base na Segunda Lei de Newton: F = m * a
            double aceleracao = forcaMola / MASSA;
            
            // Atualiza a velocidade com a aceleração calculada
            velocidade += aceleracao;
            
            // Aplica amortecimento à velocidade para simular resistência do ar
            velocidade *= (1.0 - ATRITO);
            
            // Atualiza a posição da massa suspensa
            posY += velocidade;

            // Para a oscilação se a velocidade for muito baixa e estiver próximo da posição de equilíbrio
            if (Math.abs(velocidade) < 0.01 && Math.abs(posY - baseY) < 0.5) {
                oscilando = false;
            }
        }

        repaint(); // Redesenha a interface gráfica
    }

    /**
     * Desenha os elementos gráficos da simulação.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Preenche o fundo de preto
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Desenha a mola em branco (linha vertical)
        g.setColor(Color.WHITE);
        g.drawLine(getWidth() / 2, 50, getWidth() / 2, posY);

        // Desenha a massa suspensa em vermelho
        g.setColor(Color.RED);
        g.fillOval(getWidth() / 2 - 20, posY, 40, 40);
    }

    /**
     * Método principal que cria a janela da simulação.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulação de Molas e Oscilações");
        SimulacaoMola panel = new SimulacaoMola();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
