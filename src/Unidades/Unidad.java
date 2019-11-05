package Unidades;

import AlgoChess.Alianza;
import Excepciones.UnidadEstaMuertaException;

public abstract class Unidad {

    protected int vida;
    protected int costo;
    protected int danioCuerpoACuerpo;
    protected int danioADistancia;

    protected Alianza alianza;
    protected int tFila;
    protected int tColumna;

    public int getPuntosDeVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    public void perderVida(int danio){

        if (vida < 0){
            throw (new UnidadEstaMuertaException());
        }
        vida -= danio;
    }

    public abstract void atacar(int distancia, Unidad unidadObjetivo);

    //public abstract void atacar(Unidad unidadObjetivo);

    protected Alianza getAlianza() {
        return alianza;
    }

    protected abstract void dentroRango(int distancia);

    public abstract Unidad copiar();

    public void setPosicion(int fila, int columna){
        tFila = fila;
        tColumna = columna;
    }

    public void pasoAlNorte() {

        tFila -=1;
    }

    public void pasoAlEste() {

        tColumna+=1;
    }

    public void pasoAlSur() {
        tFila += 1;
    }

    public void pasoAlOeste() {

        tColumna-=1;
    }

    public int getFila() {
        return tFila;
    }

    public int getColumna() {
        return tColumna;
    }

    public void setAlianza(Alianza alianza) {

        this.alianza = alianza;
    }

    public String getSimbolo(){

        String unidadEnTablero = "x";

        return unidadEnTablero ;
    }
}
