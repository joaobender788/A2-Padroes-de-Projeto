public class Auditoria implements ObservadorEstoque {
    @Override
    public void atualizar(String nomeProduto, int novaQuantidade) {
        System.out.println("[AUDITORIA - REGISTRO] Produto '" + nomeProduto
                + "' teve o estoque alterado para " + novaQuantidade + " unidade(s).");
    }
}
