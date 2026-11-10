public class Compras implements ObservadorEstoque {
    @Override
    public void atualizar(String nomeProduto, int novaQuantidade) {
        if (novaQuantidade < 5) {
            System.out.println("[COMPRAS - ALERTA] Estoque baixo para '" + nomeProduto
                    + "': apenas " + novaQuantidade + " unidade(s) restante(s).");
        }
    }
}
