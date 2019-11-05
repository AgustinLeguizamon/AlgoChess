package AlgoChess;

import javax.swing.text.html.HTMLDocument;

import java.util.Iterator;

import static AlgoChess.Alianza.AZUL;

public class JugadorAzul extends Jugador {

    public JugadorAzul(String unNombre) {
        super(unNombre);
    }

    public JugadorAzul(String unNombre, Tablero tablero) {
        super(unNombre,tablero);
    }


    @Override
    public void comprarUnidad(String nombreUnidad, int fila, int columna) {

        /*BRUTO hardcodeo para ver si estoy en el sector azul*/
        if(fila < 10 ){
            throw new NoSePuedeColocarUnidadEnSectorEnemigoException();
        }

        Unidad unidadComprada;
        unidadComprada = cuartel.getUnidad(nombreUnidad, this);
        unidadComprada.setAlianza(AZUL);
        tablero.colocarUnidad(unidadComprada, fila, columna);
        unidades.add(unidadComprada);
    }

    @Override
    public void unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(int filaAliada, int columnaAliado, int filaEnemigo, int columnaEnemigo) {

        tablero.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(filaAliada, columnaAliado, filaEnemigo, columnaEnemigo);
    }

    public void unidadPasoAlNorte(int fila, int columna){

        Iterator<Unidad> iterador = unidades.iterator();
        boolean encontro=false;
        Unidad unidadAzulActual;

        /**Si, no pregunta la alianza pq no se me ocurre como comparar la alianza de la unidad con la del jugador
         * pq es jugadorAzul es una clase y no tiene sentido ponerle un atributo que sea Alianza
         * la principal razon es que no quiero estar preguntando todo el tiempo si soy el jugador azul o rojo*/

        /*busco una unidad en la lista del jugador cuya posicion sea la misma que las del parametro*/
        while(iterador.hasNext() && !encontro){
            unidadAzulActual = iterador.next();
            encontro = (unidadAzulActual.getFila() == fila && unidadAzulActual.getColumna() == columna);
        }

        if(!encontro){
            throw new NoSePuedeComandarAUnaUnidadEnemigaException();
        }

        tablero.pasoAlNorte(fila,columna);

    }

}
