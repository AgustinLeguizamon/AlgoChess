package AlgoChess;

public class Casillero {

    protected Unidad unidad;

    public Casillero(){

        unidad = null;
    }

    public void colocarUnidad(Unidad unaUnidad){

        unidad = unaUnidad;
    }


    protected void casilleroEstaOcupado(){
        if (unidad != null){
            throw (new CasilleroEstaOcupadoException());
        }
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public boolean estaVacio() {

        return unidad == null;

    }

    public void unidadAtacar(int distancia, Unidad unidadObjetivo) {

        unidad.atacar(distancia, unidadObjetivo);
    }


    public Unidad removerUnidad() {

        Unidad unidadARetornar = unidad;
        unidad = null;
        return unidadARetornar;
    }
}
