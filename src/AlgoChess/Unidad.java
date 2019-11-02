package AlgoChess;

public abstract class Unidad {

    protected int vida;
    protected int costo;
    protected int danioCuerpoACuerpo;
    protected int danioADistancia;

    public int getPuntosDeVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    public void perderVida(int danio){

        if (vida < 0){
            throw (new unidadEstaMuertaException());
        }
        vida -= danio;
    }

    public abstract void atacar(int distancia, Unidad unidadObjetivo);

    protected abstract void dentroRango(int distancia);

    public abstract Unidad copiar();

}
