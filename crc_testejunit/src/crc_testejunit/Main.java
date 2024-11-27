package crc_testejunit;

public class Main {
    public static void main(String[] args) {
        // Criando um cliente
        Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");

        // Criando produtos
        Produto produto1 = new Produto("Notebook", 3000.00);
        Produto produto2 = new Produto("Mouse", 50.00);

        // Fazendo pedidos
        Pedido pedido1 = cliente.fazerPedido(produto1, 1); // 1 Notebook
        Pedido pedido2 = cliente.fazerPedido(produto2, 2); // 2 Mouses

        // Exibindo os resultados
        System.out.println("Pedido 1:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produto: " + produto1.getNome());
        System.out.println("Quantidade: 1");
        System.out.println("Total: R$" + pedido1.calcularTotal());

        System.out.println("\nPedido 2:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produto: " + produto2.getNome());
        System.out.println("Quantidade: 2");
        System.out.println("Total: R$" + pedido2.calcularTotal());
    }
}

