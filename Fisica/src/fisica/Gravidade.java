package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.RenderingHints;

public class Gravidade extends JPanel {
	private static final long serialVersionUID = 1L; 
	
	//Variáveis de estado da simulaçãp
	private double y = 50;
	private double velocidade = 0;
	private final double gravidade = 500;
	private long ultimoTempo;
	private final int chao = 350;
	private final double amortecimento = 0.8;
	
	//Construtor da classe Gravidade
	public Gravidade() {
		ultimoTempo = System.nanoTime(); //Inicializa o tempo de referencia para o calculo do delta time (dt)
		
		Timer timer = new Timer(26, e-> {
			long tempoAtual = System.nanoTime(); //Obtém o tempo atual dos nanossegundos
			double dt = (tempoAtual - ultimoTempo) / 1.0e9; //Calcula o delta time (tempo decorrido desde a última atualização)
			ultimoTempo = tempoAtual; //Atualiza o tempo de referencia para a próxima interação
			
			//Atualiza a velocidade da bola com base na gravidade 
			velocidade += gravidade * dt;// v = v0 + a * dt (equação da velocidade com acelaração constante)
			//Atualiza a posição da bola com base na velocidade
			y += velocidade * dt; // y0 + v * dt (equação do movimento uniforme acelarado)
			
			//Verifica se a bola atingiu o chao
			if (y > chao) { //Se a posição y da bola ultrapassar a posição do cão
				y = chao; //Corrige a posição da bola para ficar exatamente no chão
				velocidade = -velocidade * amortecimento; //Inverte a velocidade e aplicar o amortecimento
				
				//Para a bola quando a velocidade for muito pequena (evita oscilações infinitas)
				if (Math.abs(velocidade) < 10) { //Se a velocidade for menor que 10 pixels por segundo
					velocidade = 0; //Define a velocidade como 0
				}
			}
			repaint(); //Redesenha o painel (chama o método paintComponent)
		});
		timer.start(); //Inicia o timer
	}
	
	//Método responsável por desenhar os componentes na tela
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //Chama o método da superclasse para garantir que o fundo seja desenhado corretamente
		
		Graphics2D g2d = (Graphics2D) g; // Converte o objeto Graphics para Graphics2D (permite usar recursos avançados)
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Activa o anti-aliasing para suavizar as bordas
		
		//Desenha o fundo branco
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		//Desenha a bola (círculo azul)
		g2d.setColor(Color.BLUE);
		g2d.fillOval(150, (int) Math.round(y), 20, 20); //Posição (150, y) com diametro de 20 pixels
		
		//Desenha o chao (retangulo preto)
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, chao + 20, getWidth(), 10); //Posiciona o chao 20 pixels abaixo da posição y = chao
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Gravidade");
		Gravidade panel = new Gravidade();
		frame.add(panel); //Cria uma janela com o titulo "Gravidade"
		frame.setSize(400,420); //Define o tamanho da ja nela (400x400px)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fecha o programa ao fechar a janela
		frame.setVisible(true); //Torna a janela visivel
	}
}
