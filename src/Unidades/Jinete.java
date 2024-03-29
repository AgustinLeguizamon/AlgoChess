package Unidades;

import Excepciones.ObjetivoFueraDeRangoException;

import static java.lang.Math.abs;

public class Jinete extends Unidad {


    public Jinete(){

        vida = 100;
        costo = 3;
        danioCuerpoACuerpo = 5;
        danioADistancia = 15;

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

        /*
        if(distancia < 3){
            unidadObjetivo.perderVida(danioCuerpoACuerpo);

        }
        */
        this.dentroRango(distancia);
        unidadObjetivo.perderVida(danioADistancia);

    }


    @Override
    public void perderVida(int danio) {
        vida -= danio;
    }

    @Override
    protected void dentroRango(int distancia) {

        if (distancia > 5) {
            throw new ObjetivoFueraDeRangoException();
        }
    }

    @Override
    public Unidad copiar() {
        return new Jinete();
    }

}
