public class Chantilly extends ComplementoDecorator {
    public Chantilly(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", Chantilly";
    }

    @Override
    public double getPreco() {
        return bebida.getPreco() + 3.00;
    }
}
