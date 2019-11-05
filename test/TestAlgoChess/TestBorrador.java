package TestAlgoChess;


import AlgoChess.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBorrador {

    @Test
    public void test00SoldadoEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlNorte(5,5);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,5));

    }

    /**
    @Test
    public void testSoldadoAzulAtacaASoldadoRojoEnDistanciaCercanaYLeQuita10PuntosDeVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);
        JugadorRojo jugadorRojo = new JugadorRojo("lego",tablero);

        jugadorAzul.comprarUnidad("soldado",11,5);
        jugadorRojo.comprarUnidad("soldado",10,5);

        jugadorAzul.unidadAliadaAtacarUnidadEnemiga();

    }
*/

    @Test
    public void test01JuegoSeCreaConTableroYUnJugadorColorAzulYOtroColorRojo(){

        Juego juego = new Juego("agus","lego");


    }

}
