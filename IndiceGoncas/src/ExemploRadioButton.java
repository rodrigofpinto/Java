// 9. Exemplo de JRadioButton
// Este exemplo pode ser salvo em um arquivo chamado "ExemploRadioButton.java"
import javax.swing.*;

public class ExemploRadioButton {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo de Botão de Opção");
        JRadioButton opcao1 = new JRadioButton("Opção 1");
        JRadioButton opcao2 = new JRadioButton("Opção 2");

        ButtonGroup grupo = new ButtonGroup(); // Agrupa as opções para que apenas uma possa ser selecionada
        grupo.add(opcao1);
        grupo.add(opcao2);

        JPanel painel = new JPanel();
        painel.add(opcao1);
        painel.add(opcao2);

        janela.add(painel); // Adiciona o painel com os botões de opção
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}