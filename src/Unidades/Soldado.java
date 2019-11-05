package Unidades;

import Excepciones.NoSePuedeAtacarAUnaUnidadAliadaException;
import Excepciones.ObjetivoFueraDeRangoException;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Soldado extends Unidad {

    public Soldado(){

        vida = 100;
        costo = 1;
        danioCuerpoACuerpo = 10;
        danioADistancia = 0;
    }

    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

        if(unidadObjetivo.getAlianza() == alianza) {
            throw new NoSePuedeAtacarAUnaUnidadAliadaException();
        }

        this.dentroRango(distancia);
        unidadObjetivo.perderVida(danioCuerpoACuerpo);

    }

    /*
    @Override
    public void atacar(Unidad unidadObjetivo) {

        if(unidadObjetivo.getAlianza() != alianza) {
            throw new Excepciones.NoSePuedeAtacarAUnaUnidadAliadaException();
        }
        int distancia = max(abs(tFila - unidadObjetivo.getFila()), abs(tColumna - unidadObjetivo.getColumna()));
        this.dentroRango(distancia);
        unidadObjetivo.perderVida(danioCuerpoACuerpo);

    }
*/
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
