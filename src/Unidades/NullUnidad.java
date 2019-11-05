package Unidades;

public class NullUnidad extends Unidad {

    @Override
    public String getSimbolo(){
        String unidadEnTablero = "-";
        return unidadEnTablero ;
    }

    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

    }

    @Override
    protected void dentroRango(int distancia) {

    }

    @Override
    public Unidad copiar() {
        return new NullUnidad();
    }
}
