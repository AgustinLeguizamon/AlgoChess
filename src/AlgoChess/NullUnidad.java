package AlgoChess;

public class NullUnidad extends Unidad{


    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

    }

    @Override
    public void atacar(Unidad unidadObjetivo) {

    }

    @Override
    protected void dentroRango(int distancia) {

    }

    @Override
    public Unidad copiar() {
        return new NullUnidad();
    }
}
