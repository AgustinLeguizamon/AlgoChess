package AlgoChess;

import Excepciones.PuntosInsuficientesException;
import Tablero.Tablero;
import Unidades.Cuartel;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {

    protected String nombre;
    protected int puntos;

    /*Asi el jugador puede ver el estado de sus unidades sin tener que buscarlas,
    al colocar una unidad coloca en el casillero el puntero a la unidad presente en esta lista*/
    protected List<Unidad> unidades;

    /*El cuartal deberia ser una sola instancia para todos los jugadores, aca estoy duplicando por cada jugador? */
    protected Cuartel cuartel = new Cuartel();
    protected Tablero tablero;
    //protected int[][] movimientosPosible = Movimiento.OFFSET_COORDENADAS_MOVIMIENTO;

    public Jugador(String unNombre) {

        nombre = unNombre;
        puntos = 20;
        unidades =  new ArrayList<>();
    }

    public Jugador(String unNombre, Tablero tableroDelJuego) {

        nombre = unNombre;
        puntos = 20;
        unidades =  new ArrayList<>();
        tablero = tableroDelJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    /*Uso overload la primera solo compra y la segunda compra y coloca en tablero
    * pq no se me ocurre como comprar primero y luego en otra funcion colocar sin tener que buscar
    * la unidad en la lista y ver si ya fue colocada o no asi que mejor hacerlo de una */

    public void comprarUnidad(String nombreUnidad){

        Unidad unidadComprada;
        unidadComprada = cuartel.getUnidad(nombreUnidad, this);
        unidades.add(unidadComprada);

    }

    public abstract void comprarUnidad(String nombreUnidad, int fila, int columna);

    public abstract void unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(int filaAliada, int columnaAliado, int filaEnemigo, int columnaEnemigo);

    /*
    Paso las dos unidades por parametro dado que como saben su posicion pueden calcular la distancia entre ellas

    public  void unidadAliadaAtacarUnidadEnemiga(Unidad unidadAliada, Unidad unidadEnemiga){

        if (unidades.contains(unidadAliada) & !unidades.contains(unidadEnemiga)){

            unidadAliada.atacar(unidadEnemiga);
        }

    }
    */

    public void pagar(int costo){

        if( costo > puntos){
            throw new PuntosInsuficientesException();
        }
        puntos -= costo;
    }
}
