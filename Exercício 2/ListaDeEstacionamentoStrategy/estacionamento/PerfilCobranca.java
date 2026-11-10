package estacionamento;

import java.math.BigDecimal;

/**
 * Contrato para o cálculo do valor de permanência do estacionamento.
 * Implementa o padrão Strategy para evitar uso de if/else ou switch (RQ2.7).
 */
public interface PerfilCobranca {
    BigDecimal calcularValor(int minutosPermanencia);
}
