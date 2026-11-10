public class Main {
    public static void main(String[] args) {

        Bebida pedido1 = new Espresso();
        pedido1 = new Leite(pedido1);
        pedido1 = new Calda(pedido1);
        imprimirPedido(1, pedido1);

        Bebida pedido2 = new Cha();
        pedido2 = new Chantilly(pedido2);
        imprimirPedido(2, pedido2);

        Bebida pedido3 = new Espresso();
        pedido3 = new Leite(pedido3);
        pedido3 = new Leite(pedido3);
        pedido3 = new Chantilly(pedido3);
        imprimirPedido(3, pedido3);
    }

    private static void imprimirPedido(int numero, Bebida pedido) {
        System.out.printf("Pedido %d: %s | Preço Total: R$ %.2f%n",
                numero, pedido.getDescricao(), pedido.getPreco());
    }
}
