// Exemplos em Java Swing para Interfaces Gráficas (GUI)
// Cada exemplo demonstra um tópico ou subtópico

// 1. Janela Básica
// Este exemplo pode ser salvo em um arquivo chamado "JanelaBasica.java"
import javax.swing.*;

public class JanelaBasica {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Janela Básica"); // Cria uma janela
        janela.setSize(300, 200); // Define o tamanho da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
        janela.setVisible(true); // Torna a janela visível
    }
}