package estacionamento;

/** RF01 - Contrato do padrão Prototype: o objeto sabe produzir uma cópia de si mesmo. */
public interface Prototype<T> {

    T clonar();
}
