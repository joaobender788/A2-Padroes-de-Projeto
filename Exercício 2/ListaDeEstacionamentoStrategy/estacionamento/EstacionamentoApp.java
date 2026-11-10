package estacionamento;

import java.math.BigDecimal;
import java.util.Locale;

public class EstacionamentoApp {

    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    public static void main(String[] args) {
        int tempoPermanenciaMinutos = 125; // Exemplo: 2 horas e 5 minutos

        System.out.println("=== DEMONSTRAÇÃO DE CÁLCULO POR PERFIL (Tempo: " + tempoPermanenciaMinutos + " min) ===");
        
        Tiquete tiqueteRotativo = new Tiquete("ABC-1234", tempoPermanenciaMinutos, new Rotativo());
        Tiquete tiqueteMensalista = new Tiquete("ABC-1234", tempoPermanenciaMinutos, new Mensalista());
        Tiquete tiqueteConveniado = new Tiquete("ABC-1234", tempoPermanenciaMinutos, new Conveniado());

        imprimirTiquete("Rotativo", tiqueteRotativo);
        imprimirTiquete("Mensalista", tiqueteMensalista);
        imprimirTiquete("Conveniado", tiqueteConveniado);

        System.out.println("\n=== DEMONSTRAÇÃO DE TROCA DE PERFIL EM TEMPO DE EXECUÇÃO (RQ2.6) ===");
        
        Tiquete tiqueteDinamico = new Tiquete("XYZ-9876", 90, new Rotativo());
        System.out.println(String.format(PT_BR, "Tiquete #%d (Placa: %s) criado inicialmente como **Rotativo** (90 min): R$ %.2f",
                tiqueteDinamico.getId(), tiqueteDinasicoPlacaSafe(tiqueteDinamico), tiqueteDinamico.calcularValorPagar()));

        // Alterando para Conveniado em tempo de execução
        tiqueteDinamico.setPerfilCobranca(new Conveniado());
        System.out.println(String.format(PT_BR, "-> Perfil alterado para **Conveniado**: R$ %.2f",
                tiqueteDinamico.calcularValorPagar()));

        // Alterando para Mensalista em tempo de execução
        tiqueteDinamico.setPerfilCobranca(new Mensalista());
        System.out.println(String.format(PT_BR, "-> Perfil alterado para **Mensalista**: R$ %.2f",
                tiqueteDinamico.calcularValorPagar()));
    }

    private static void imprimirTiquete(String nomePerfil, Tiquete t) {
        BigDecimal valor = t.calcularValorPagar();
        System.out.println(String.format(PT_BR, "Perfil %-12s | Tíquete #%d | Placa: %s | Valor: R$ %.2f",
                nomePerfil, t.getId(), t.getPlaca(), valor));
    }

    private static String tiqueteDinasicoPlacaSafe(Tiquete t) {
        return t.getPlaca();
    }
}
