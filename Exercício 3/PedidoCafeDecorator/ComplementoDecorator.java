public abstract class ComplementoDecorator implements Bebida {
    protected final Bebida bebida;

    public ComplementoDecorator(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public abstract String getDescricao();

    @Override
    public abstract double getPreco();
}
