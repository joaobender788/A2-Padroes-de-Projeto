package estacionamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Perfil Mensalista: valor fixo, independente do tempo de permanência (RQ2.3). */
public class Mensalista implements PerfilCobranca {
    private static final BigDecimal VALOR_MENSAL = new BigDecimal("250.00");

    @Override
    public BigDecimal calcularValor(int minutosPermanencia) {
        return VALOR_MENSAL.setScale(2, RoundingMode.HALF_UP);
    }
}