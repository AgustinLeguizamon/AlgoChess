package Tablero;

import Excepciones.CasilleroEstaOcupadoException;
import Unidades.NullUnidad;
import Unidades.Unidad;
import Excepciones.noHayUnidadEnCasilleroException;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Tablero {

    private Unidad tablero[][];

    public Tablero(){

        int i,j;

        tablero = new Unidad[20][20];
        for ( i = 0; i < 20 ; i++) {
            for (j = 0; j < 20 ; j++) {
                tablero[i][j] = new NullUnidad();
            }
        }
    }

    public void imprimirTablero(){

        int i,j;

        System.out.print(" *****************Tablero del juego******************** \n") ;
        System.out.print("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18\t19\t\n") ;

        for ( i = 0; i < 20 ; i++) {
            System.out.print(i +"\t| ") ;
            for (j = 0; j < 20 ; j++) {
                System.out.print(tablero[i][j].getSimbolo() + " | ") ;
            }
            System.out.print("\n") ;
        }
    }

    public int getTamanio(){

        return tablero.length * tablero[0].length;
    }


    public boolean estaVacio(int fila, int columna){

        return tablero[fila][columna].getSimbolo() == "-";
    }

    public void casilleroEstaOcupado(int fila, int columna){

        if(tablero[fila][columna].getSimbolo() != "-"){
            throw new CasilleroEstaOcupadoException();
        }
    }

    public void colocarUnidad(Unidad unaUnidad, int fila, int columna) {

        casilleroEstaOcupado(fila,columna);
        tablero[fila][columna] = unaUnidad;
        unaUnidad.setPosicion(fila,columna);
    }

    private Unidad punteroAUnidad(int fila, int columna) {

        Unidad unidadAMover = tablero[fila][columna];
        tablero[fila][columna] = new NullUnidad();
        return unidadAMover;
    }

    public void pasoAlNorte(int fila, int columna) {

        Unidad unidadAMover;
        unidadAMover = this.punteroAUnidad(fila,columna);
        this.colocarUnidad(unidadAMover,fila-1,columna);
    }


    public void pasoAlEste(int fila, int columna) {

        Unidad unidadAMover;
        unidadAMover = this.punteroAUnidad(fila,columna);
        this.colocarUnidad(unidadAMover,fila,columna+1);
    }

    public void pasoAlSur(int fila, int columna) {

        Unidad unidadAMover;
        unidadAMover = this.punteroAUnidad(fila,columna);
        this.colocarUnidad(unidadAMover,fila+1,columna);
    }

    public void pasoAlOeste(int fila, int columna) {

        Unidad unidadAMover;
        unidadAMover = this.punteroAUnidad(fila,columna);
        this.colocarUnidad(unidadAMover,fila,columna-1);
    }


    /*El siguiente metodo reemplaza a todos los de arriba*/
    /*OJO esto hace que las catapultas se muevan*/

    public void moverUnidad(int fila, int columna, int[] offset) {
        Unidad unidadAMover;
        int offsetEnFila, offsetEnColumna;

        offsetEnFila = offset[0];
        offsetEnColumna = offset[1];

        unidadAMover = this.punteroAUnidad(fila,columna);
        this.colocarUnidad(unidadAMover,fila+offsetEnFila,columna+offsetEnColumna);
    }

    public void unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(int filaAliado, int columnaAliado, int filaEnemigo, int columnaEnemigo) {

        Unidad unidadAliada, unidadEnemiga;

        unidadAliada = tablero[filaAliado][columnaAliado];
        unidadEnemiga = tablero[filaEnemigo][columnaEnemigo];

        if(unidadAliada.getSimbolo() == "-" || unidadEnemiga.getSimbolo() == "-"){
            throw new noHayUnidadEnCasilleroException();
        }

        int distancia = max(abs(filaAliado - filaEnemigo), abs(columnaAliado - columnaEnemigo));
        unidadAliada.atacar(distancia, unidadEnemiga);
    }

    public int getPuntosDeVidaUnidadEnPosicion(int fila, int columna) {

        return tablero[fila][columna].getPuntosDeVida();
    }

}
