public class Main {
    public static void main(String[] args) {
        Produto notebook = new Produto("Notebook Gamer", 10);

        ObservadorEstoque compras = new Compras();
        ObservadorEstoque vendas = new Vendas();
        ObservadorEstoque auditoria = new Auditoria();

        notebook.adicionarObservador(compras);
        notebook.adicionarObservador(vendas);
        notebook.adicionarObservador(auditoria);

        System.out.println("--- Alteração 1: Estoque para 10 (mesmo valor, não deve notificar) ---");
        notebook.setQuantidade(10);

        System.out.println("\n--- Alteração 2: Estoque para 4 (abaixo de 5) ---");
        notebook.setQuantidade(4);

        System.out.println("\n--- Alteração 3: Estoque zerado (0) ---");
        notebook.setQuantidade(0);

        System.out.println("\n--- Alteração 4: Estoque reposto para 8 (voltou após zerar) ---");
        notebook.setQuantidade(8);

        System.out.println("\n--- Removendo a área de Auditoria ---");
        notebook.removerObservador(auditoria);

        System.out.println("\n--- Alteração 5: Estoque para 2 (Auditoria não deve mais receber) ---");
        notebook.setQuantidade(2);
    }
}
