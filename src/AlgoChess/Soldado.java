package AlgoChess;

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

        if(unidadObjetivo.getAlianza() != alianza){
            this.dentroRango(distancia);
            unidadObjetivo.perderVida(danioCuerpoACuerpo);
        }else{
            System.out.println("No se pueden atacar unidades aliadas");
        };

    }

    @Override
    public void atacar(Unidad unidadObjetivo) {

        if(unidadObjetivo.getAlianza() != alianza){
            int distancia = max(abs(tFila - unidadObjetivo.getFila()), abs(tColumna - unidadObjetivo.getColumna()));
            this.dentroRango(distancia);
            unidadObjetivo.perderVida(danioCuerpoACuerpo);
        }
        else{
            System.out.println("No se pueden atacar unidades aliadas");
        }

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
