public class Calda extends ComplementoDecorator {
    public Calda(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", Calda";
    }

    @Override
    public double getPreco() {
        return bebida.getPreco() + 2.50;
    }
}
