package AlgoChess;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Tablero {

    private Casillero tablero[][];

    public Tablero(){

        int i,j;

        tablero = new Casillero[20][20];
        for ( i = 0; i < 20 ; i++) {
            for (j = 0; j < 20 ; j++) {
                Casillero casillero = new Casillero();
                tablero[i][j] = casillero;
            }
        }

    }

    public int getTamanio(){

        return tablero.length * tablero.length;
    }


    public boolean estaVacio(int fila, int columna){
        return tablero[fila][columna].estaVacio();
    }


    public void colocarUnidad(Unidad unaUnidad, int fila, int columna) {

        tablero[fila][columna].casilleroEstaOcupado();
        tablero[fila][columna].colocarUnidad(unaUnidad);
    }

    public void pasoAlNorte(int fila, int columna) {

        tablero[fila-1][columna].casilleroEstaOcupado();
        Unidad unaUnidad = tablero[fila][columna].removerUnidad();
        tablero[fila-1][columna].colocarUnidad(unaUnidad);
    }

    public void pasoAlEste(int fila, int columna) {

        tablero[fila][columna+1].casilleroEstaOcupado(); //Se fija si se puede mover al casillero Este
        Unidad unaUnidad = tablero[fila][columna].removerUnidad(); //Remueve del casillero a la unidad
        tablero[fila][columna+1].colocarUnidad(unaUnidad);// La coloca en el casillero inmediato Este
    }

    public void pasoAlSur(int fila, int columna) {

        tablero[fila+1][columna].casilleroEstaOcupado();
        Unidad unaUnidad = tablero[fila][columna].removerUnidad();
        tablero[fila+1][columna].colocarUnidad(unaUnidad);
    }

    public void pasoAlOeste(int fila, int columna) {

        tablero[fila][columna-1].casilleroEstaOcupado(); //Se fija si se puede mover al casillero Este
        Unidad unaUnidad = tablero[fila][columna].removerUnidad(); //Remueve del casillero a la unidad
        tablero[fila][columna-1].colocarUnidad(unaUnidad);// La coloca en el casillero inmediato Este
    }

    public void unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(int filaAliado, int columnaAliado, int filaEnemigo, int columnaEnemigo) {

        Casillero casilleroAliado, casilleroEnemigo;

        casilleroAliado = tablero[filaAliado][columnaAliado];
        casilleroEnemigo = tablero[filaEnemigo][columnaEnemigo];

        if(casilleroAliado.estaVacio() || casilleroEnemigo.estaVacio()){
            throw new noHayUnidadEnCasilleroException();
        }

        int distancia = max(abs(filaAliado - filaEnemigo), abs(columnaAliado - columnaEnemigo));

        casilleroAliado.unidadAtacar(distancia, casilleroEnemigo.getUnidad());
    }

    public int getPuntosDeVidaUnidadEnPosicion(int fila, int columna) {

        return tablero[fila][columna].getUnidad().getPuntosDeVida();
    }

}
