package AlgoChess;

import Tablero.Tablero;

public class Juego {

    private Tablero tablero;
    private JugadorAzul jugadorAzul;
    private JugadorRojo jugadorRojo;

    public Juego(String nombreJugadorAzul, String nombreJugadorRojo){

        tablero = new Tablero();
        jugadorAzul = new JugadorAzul(nombreJugadorAzul);
        jugadorRojo = new JugadorRojo(nombreJugadorRojo);
    }





}
