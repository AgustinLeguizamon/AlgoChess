package AlgoChess;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Tablero {

    private Unidad tablero[][];

    public Tablero(){

        int i,j;

        tablero = new Unidad[20][20];
        for ( i = 0; i < 20 ; i++) {
            for (j = 0; j < 20 ; j++) {
                tablero[i][j] = null;
            }
        }

    }

    public void imprimirTablero(){

    }

    public int getTamanio(){

        return tablero.length * tablero.length;
    }


    public boolean estaVacio(int fila, int columna){

        return tablero[fila][columna] == null;
    }

    public void casilleroEstaOcupado(int fila, int columna){

        if(tablero[fila][columna] != null){
            throw new CasilleroEstaOcupadoException();
        }
    }

    public void colocarUnidad(Unidad unaUnidad, int fila, int columna) {

        casilleroEstaOcupado(fila,columna);
        tablero[fila][columna] = unaUnidad;
        unaUnidad.setPosicion(fila,columna);
    }

    private Unidad preparar(int fila, int columna) {

        tablero[fila][columna].pasoAlNorte();
        Unidad unidadAMover = tablero[fila][columna];
        tablero[fila][columna] = null;
        return unidadAMover;
    }

    public void pasoAlNorte(int fila, int columna) {

        Unidad unidadAMover;
        unidadAMover = this.preparar(fila,columna);
        this.colocarUnidad(unidadAMover,fila-1,columna);
    }


    public void pasoAlEste(int fila, int columna) {

        Unidad unidadAMover;
        unidadAMover = this.preparar(fila,columna);
        this.colocarUnidad(unidadAMover,fila,columna+1);
    }

    public void pasoAlSur(int fila, int columna) {

        Unidad unidadAMover;
        unidadAMover = this.preparar(fila,columna);
        this.colocarUnidad(unidadAMover,fila+1,columna);
    }

    public void pasoAlOeste(int fila, int columna) {

        Unidad unidadAMover;
        unidadAMover = this.preparar(fila,columna);
        this.colocarUnidad(unidadAMover,fila,columna-1);
    }

    public void unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(int filaAliado, int columnaAliado, int filaEnemigo, int columnaEnemigo) {

        Unidad unidadAliada, unidadEnemiga;

        unidadAliada = tablero[filaAliado][columnaAliado];
        unidadEnemiga = tablero[filaEnemigo][columnaEnemigo];

        if(unidadAliada == null || unidadEnemiga == null){
            throw new noHayUnidadEnCasilleroException();
        }

        int distancia = max(abs(filaAliado - filaEnemigo), abs(columnaAliado - columnaEnemigo));

        unidadAliada.atacar(distancia, unidadEnemiga);
    }

    public int getPuntosDeVidaUnidadEnPosicion(int fila, int columna) {

        return tablero[fila][columna].getPuntosDeVida();
    }

}
