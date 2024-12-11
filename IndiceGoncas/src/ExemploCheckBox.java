// 5. Exemplo de JCheckBox
// Este exemplo pode ser salvo em um arquivo chamado "ExemploCheckBox.java"
import javax.swing.*;

public class ExemploCheckBox {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo de Caixa de Seleção");
        JCheckBox caixaSelecao = new JCheckBox("Eu concordo"); // Cria uma caixa de seleção

        janela.add(caixaSelecao); // Adiciona a caixa de seleção à janela
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}