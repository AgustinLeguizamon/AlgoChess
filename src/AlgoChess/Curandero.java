package AlgoChess;

public class Curandero extends Unidad {

    public Curandero(){

        vida = 75;
        costo = 2;
        danioCuerpoACuerpo = 0;
        danioADistancia = -15;

    }

    @Override
    public int getPuntosDeVida() {
        return vida;
    }

    @Override
    public int getCosto() {
        return costo;
    }

    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

        this.dentroRango(distancia);
        unidadObjetivo.perderVida(danioADistancia);

    }

    @Override
    public void perderVida(int danio) {
        vida -= danio;
    }

    @Override
    protected void dentroRango(int distancia) {

        if(distancia > 2){
            throw new ObjetivoFueraDeRangoException();
        }

    }

    @Override
    public Unidad copiar() {
        return new Curandero();
    }

}
