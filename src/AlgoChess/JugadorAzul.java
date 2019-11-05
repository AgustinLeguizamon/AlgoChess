package AlgoChess;

import Excepciones.CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException;
import Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import Tablero.Tablero;
import Unidades.Unidad;


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

        seleccionarUnidad(fila, columna);
        tablero.pasoAlNorte(fila,columna);

    }

    /*Con esto verifico si el casillero seleccionado tiene una unidad y si esta pertenece al jugador*/
    public void seleccionarUnidad(int fila, int columna) {
        Iterator<Unidad> iterador = unidades.iterator();
        boolean encontro=false;
        Unidad unidadAzulActual;

        /**Si, no pregunta la alianza pq no se me ocurre como comparar la alianza de la unidad con la del jugador
         * pq es jugadorAzul es una clase y no tiene sentido ponerle un atributo que sea AlgoChess.Alianza
         * la principal razon es que no quiero estar preguntando todo el tiempo si soy el jugador azul o rojo*/

        /*busco una unidad en la lista del jugador cuya posicion sea la misma que las del parametro*/
        while(iterador.hasNext() && !encontro){
            unidadAzulActual = iterador.next();
            encontro = (unidadAzulActual.getFila() == fila && unidadAzulActual.getColumna() == columna);
        }

        if(!encontro){
            throw new CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException();
        }
    }

    /**El problema mas grande que tengo es que no se si la responsabilidad de los movimientos recae en el tablero
     * o si recae en la unidad dado que el tablero es aquel que conoce todas las posiciones y la unidad solo sabe en donde esta
     * HASTA EL MOMENTO LA POSICION DE LA UNIDAD SOLO LA UTILIZE PARA seleccionarUnidad()*/

    public void moverUnidad(int fila, int columna, int orientacion) {
        int[] offset = Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[orientacion]; // 0 es norte {-1,0}

        seleccionarUnidad(fila, columna);
        tablero.moverUnidad(fila,columna,offset);

    }
}
