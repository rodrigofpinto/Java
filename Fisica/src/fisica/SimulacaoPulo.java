package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

// Simulação de pulo e movimento lateral controlado pelas setas do teclado
public class SimulacaoPulo extends JPanel {
    private static final long serialVersionUID = 1L;
    
    // Posição inicial do personagem
    private int personagemX = 200, personagemY = 300; 
    
    // Velocidade horizontal e vertical
    private int velocidadeX = 0;
    private int velocidadeY = 0;
    
    // Variável para verificar se o personagem está no chão
    private boolean noChao = true;
    
    // Constantes físicas
    private final int GRAVIDADE = 1;   // Força da gravidade aplicada a cada frame
    private final int IMPULSO = -15;   // Força do pulo ao pressionar a tecla espaço
    private final int VELOCIDADE = 5;  // Velocidade de movimento lateral

    // Construtor da classe
    public SimulacaoPulo() {
        setFocusable(true); // Permite que o painel receba eventos de teclado

        // Adiciona um KeyListener para capturar teclas pressionadas
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Se a tecla espaço for pressionada e o personagem estiver no chão, aplica impulso
                if (e.getKeyCode() == KeyEvent.VK_SPACE && noChao) {
                    velocidadeY = IMPULSO;
                    noChao = false; // O personagem sai do chão
                }
                // Movimento para a esquerda
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    velocidadeX = -VELOCIDADE;
                }
                // Movimento para a direita
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    velocidadeX = VELOCIDADE;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Se a tecla esquerda ou direita for solta, para o movimento horizontal
                if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    velocidadeX = 0;
                }
            }
        });

        // Timer para atualizar a simulação a cada 16ms (~60 FPS)
        Timer timer = new Timer(16, e -> atualizar());
        timer.start();
    }

    // Método para atualizar a posição do personagem
    private void atualizar() {
        velocidadeY += GRAVIDADE; // Aplica a gravidade
        personagemY += velocidadeY; // Atualiza a posição vertical
        personagemX += velocidadeX; // Atualiza a posição horizontal

        // Verifica se o personagem atinge o chão
        if (personagemY >= 300) {
            personagemY = 300; // Mantém o personagem no chão
            velocidadeY = 0;   // Para o movimento vertical
            noChao = true;     // Define que o personagem está no chão novamente
        }

        repaint(); // Re-desenha a tela com a nova posição
    }

    // Método para desenhar o cenário e o personagem
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); // Desenha o fundo preto

        g.setColor(Color.BLUE);
        g.fillRect(personagemX, personagemY, 40, 40); // Desenha o personagem como um quadrado azul
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulação de Pulo e Impulso");
        SimulacaoPulo panel = new SimulacaoPulo();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
