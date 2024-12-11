// 8. Exemplo de JComboBox
// Este exemplo pode ser salvo em um arquivo chamado "ExemploComboBox.java"
import javax.swing.*;

public class ExemploComboBox {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo de ComboBox");
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes); // Cria uma lista suspensa

        janela.add(comboBox); // Adiciona o comboBox à janela
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}