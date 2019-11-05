package Unidades;

import Excepciones.NoSePuedenCurarUnidadesNoOrganicasException;
import Excepciones.ObjetivoFueraDeRangoException;
import Excepciones.UnidadNoMovibleException;

public class Catapulta extends Unidad {

    private int costo =5;
    private int vida =50;
    private int danio =0;
    private int danioADistancia =20;


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
        if (danio < 0) {
            throw (new NoSePuedenCurarUnidadesNoOrganicasException());
        }
        vida -= danio;
    }

    @Override
    protected void dentroRango(int distancia) {

        if ( distancia < 6){
            throw new ObjetivoFueraDeRangoException();
        }
    }

    @Override
    public Unidad copiar() {

        return new Catapulta();
    }

    @Override
    public int getPuntosDeVida() {
        return vida;
    }

    @Override
    public void pasoAlNorte(){
        throw new UnidadNoMovibleException();
    }

    @Override
    public void pasoAlEste(){
        throw new UnidadNoMovibleException();
    }

    @Override
    public void pasoAlSur(){
        throw new UnidadNoMovibleException();
    }

    @Override
    public void pasoAlOeste(){
        throw new UnidadNoMovibleException();
    }

}
