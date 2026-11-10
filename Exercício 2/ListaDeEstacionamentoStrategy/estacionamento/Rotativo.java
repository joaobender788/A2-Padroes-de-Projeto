package estacionamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Perfil Rotativo: cobrança de um valor por hora iniciada (RQ2.2). */
public class Rotativo implements PerfilCobranca {
    private static final BigDecimal VALOR_HORA = new BigDecimal("10.00");

    @Override
    public BigDecimal calcularValor(int minutosPermanencia) {
        if (minutosPermanencia <= 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        // Calcula horas iniciadas (arredonda para cima)
        int horas = (int) Math.ceil(minutosPermanencia / 60.0);
        return VALOR_HORA.multiply(BigDecimal.valueOf(horas)).setScale(2, RoundingMode.HALF_UP);
    }
}