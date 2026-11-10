package estacionamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Perfil Conveniado: primeiros 30 min gratuitos, depois valor por hora com desconto (RQ2.4). */
public class Conveniado implements PerfilCobranca {
    private static final int MINUTOS_GRATIS = 30;
    private static final BigDecimal VALOR_HORA = new BigDecimal("12.00");
    private static final BigDecimal DESCONTO_PERCENTUAL = new BigDecimal("0.20"); // 20% de desconto

    @Override
    public BigDecimal calcularValor(int minutosPermanencia) {
        if (minutosPermanencia <= MINUTOS_GRATIS) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        
        int minutosCobrados = minutosPermanencia - MINUTOS_GRATIS;
        int horas = (int) Math.ceil(minutosCobrados / 60.0);
        
        BigDecimal valorBruto = VALOR_HORA.multiply(BigDecimal.valueOf(horas));
        BigDecimal desconto = valorBruto.multiply(DESCONTO_PERCENTUAL);
        
        return valorBruto.subtract(desconto).setScale(2, RoundingMode.HALF_UP);
    }
}