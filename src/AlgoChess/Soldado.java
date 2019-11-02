package AlgoChess;

import static java.lang.Math.abs;

public class Soldado extends Unidad {

    public Soldado(){

        vida = 100;
        costo = 1;
        danioCuerpoACuerpo = 10;
        danioADistancia = 0;
    }

    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

        this.dentroRango(distancia);
        unidadObjetivo.perderVida(danioCuerpoACuerpo);
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
        return new Soldado();
    }

}
