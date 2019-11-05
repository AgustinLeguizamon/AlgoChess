package TestAlgoChess;


import AlgoChess.*;
import Tablero.Tablero;
import Unidades.Curandero;
import Unidades.Jinete;
import Unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMovimientoUnidades {

    @Test
    public void test00SoldadoEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,5));

    }

    @Test
    public void testSoldadoEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,6));

    }

    @Test
    public void testSoldadoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,6));

    }

    @Test
    public void testSoldadoEnTableroSeMueveAlSuresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,6));

    }

    @Test
    public void testSoldadoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,5));

    }

    @Test
    public void testSoldadoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,4));

    }

    @Test
    public void testSoldadoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,4));

    }

    @Test
    public void testSoldadoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,4));

    }

    /** De integracion */

    @Test
    public void testJineteEnTableroSeMueveNorteEsteSurOesteSurYVuelveASuPosicionInicial(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,12,4);
        tablero.moverUnidad(12,4,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);
        tablero.moverUnidad(11,4,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        tablero.moverUnidad(11,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);
        tablero.moverUnidad(12,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertFalse(tablero.estaVacio(12,4));

    }


    @Test
    public void testCuranderoEnTableroSeMueveNorteEsteSurOesteSurYVuelveASuPosicionInicial(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.imprimirTablero();
        tablero.colocarUnidad(curandero,12,4);
        tablero.imprimirTablero();
        tablero.moverUnidad(12,4,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);
        tablero.imprimirTablero();
        tablero.moverUnidad(11,4,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        tablero.imprimirTablero();
        tablero.moverUnidad(11,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);
        tablero.imprimirTablero();
        tablero.moverUnidad(12,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);
        tablero.imprimirTablero();

        Assertions.assertFalse(tablero.estaVacio(12,4));

    }



}
