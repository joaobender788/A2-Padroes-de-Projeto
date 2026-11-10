package estacionamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

/** RQ2.1 e RQ2.6 - Representa o tíquete do estacionamento e delega o cálculo ao perfil. */
public class Tiquete {
    private static final AtomicLong SEQUENCIA = new AtomicLong();

    private final long id;
    private final String placa;
    private int minutosPermanencia;
    private PerfilCobranca perfilCobranca;
    private final LocalDateTime criadoEm;

    public Tiquete(String placa, int minutosPermanencia, PerfilCobranca perfilCobranca) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("A placa do veículo é obrigatória.");
        }
        if (minutosPermanencia < 0) {
            throw new IllegalArgumentException("O tempo de permanência não pode ser negativo.");
        }
        if (perfilCobranca == null) {
            throw new IllegalArgumentException("O perfil de cobrança é obrigatório.");
        }

        this.id = SEQUENCIA.incrementAndGet();
        this.placa = placa;
        this.minutosPermanencia = minutosPermanencia;
        this.perfilCobranca = perfilCobranca;
        this.criadoEm = LocalDateTime.now();
    }

    /** RQ2.6 - Permite alterar o perfil de cobrança de um mesmo tíquete em tempo de execução. */
    public void setPerfilCobranca(PerfilCobranca perfilCobranca) {
        if (perfilCobranca == null) {
            throw new IllegalArgumentException("O novo perfil de cobrança não pode ser nulo.");
        }
        this.perfilCobranca = perfilCobranca;
    }

    /** Delega o cálculo para o perfil atual sem utilizar if/else ou switch (RQ2.7). */
    public BigDecimal calcularValorPagar() {
        return perfilCobranca.calcularValor(minutosPermanencia);
    }

    public long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public int getMinutosPermanencia() {
        return minutosPermanencia;
    }

    public void setMinutosPermanencia(int minutosPermanencia) {
        this.minutosPermanencia = minutosPermanencia;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
