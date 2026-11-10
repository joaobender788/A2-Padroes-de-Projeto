import java.util.HashSet;
import java.util.Set;

public class Vendas implements ObservadorEstoque {
    private final Set<String> produtosZerados = new HashSet<>();

    @Override
    public void atualizar(String nomeProduto, int novaQuantidade) {
        if (novaQuantidade == 0) {
            produtosZerados.add(nomeProduto);
        } else if (novaQuantidade > 0 && produtosZerados.remove(nomeProduto)) {
            System.out.println("[VENDAS - ALERTA] O produto '" + nomeProduto
                    + "' voltou a ter estoque! Quantidade disponível: " + novaQuantidade);
        }
    }
}
