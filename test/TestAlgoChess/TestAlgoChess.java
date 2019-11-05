package TestAlgoChess;

import AlgoChess.*;
import Excepciones.*;
import Tablero.Tablero;
import Unidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAlgoChess {

    @Test
    public void testCrearJugadorEquipoAzulConNombreAgustinY20Puntos(){

        Jugador jugador = new JugadorAzul("agustin");

        Assertions.assertEquals("agustin", jugador.getNombre());
        Assertions.assertEquals(20, jugador.getPuntos());

    }

    @Test
    public void testJugadorAzulCompraUnSoldadoPor1Punto(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("soldado");
        Assertions.assertEquals(19, jugadorAzul.getPuntos());

    }

    @Test
    public void testJugadorAzulCompraUnJinetePor3Puntos(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("jinete");
        Assertions.assertEquals(17, jugadorAzul.getPuntos());

    }

    @Test
    public void testJugadorAzulCompraUnCuranderoPor2Puntos(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("curandero");
        Assertions.assertEquals(18, jugadorAzul.getPuntos());
    }

    @Test
    public void testJugadorAzulCompraUnaCatapultaPor5Puntos(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("catapulta");
        Assertions.assertEquals(15, jugadorAzul.getPuntos());
    }

    @Test
    public void testJugadorAzulConMenosDe5PuntosNoCompraUnaCatapultaPorInsuficienciaDePuntos(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("catapulta");
        jugadorAzul.comprarUnidad("catapulta");
        jugadorAzul.comprarUnidad("catapulta");
        jugadorAzul.comprarUnidad("jinete");

        Assertions.assertThrows(PuntosInsuficientesException.class, () -> jugadorAzul.comprarUnidad("catapulta"));
        Assertions.assertEquals(2, jugadorAzul.getPuntos());
    }


    @Test
    public void testCrearSoldadoDeInfanteriaTiene100DeVidaYCuesta1Puntos() {

        Soldado soldado = new Soldado();

        Assertions.assertEquals(100, soldado.getPuntosDeVida());
        Assertions.assertEquals(1, soldado.getCosto());
    }

    @Test
    public void testCrearJineteTiene100DeVidaYCuesta3Puntos(){

        Jinete jinete = new Jinete();

        Assertions.assertEquals(100, jinete.getPuntosDeVida());
        Assertions.assertEquals(3, jinete.getCosto());
    }

    @Test
    public void testCrearCuranderoTiene75DeVidaYCuesta2Puntos(){

        Curandero curandero = new Curandero();

        Assertions.assertEquals(75, curandero.getPuntosDeVida());
        Assertions.assertEquals(2, curandero.getCosto());
    }

    @Test
    public void testCrearCatapultaTiene50DeVidaYCuesta5Puntos(){

        Catapulta catapulta = new Catapulta();

        Assertions.assertEquals(50, catapulta.getPuntosDeVida());
        Assertions.assertEquals(5, catapulta.getCosto());
    }

    @Test
    public void testTableroTieneUnTamanioDe20Por20(){

        Tablero tablero = new Tablero();

        Assertions.assertEquals(20*20, tablero.getTamanio());
    }

    /**Posicion y movimientos*/

    /*Instancia jugador pq es necesario saber de que color es*/
    @Test
    public void testJugadorAzulColocaUnSoldadoEnUnCasilleroVacioDelSectorAliadoConExito() {

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("soldado",15,15);

        Assertions.assertFalse(tablero.estaVacio(15, 15));

    }

    @Test
    public void testJugadorAzulNoPuedeColocarUnSoldadoEnUnCasilleroDelSectorEnemigo() {

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        Assertions.assertThrows(NoSePuedeColocarUnidadEnSectorEnemigoException.class, () -> jugadorAzul.comprarUnidad("soldado",5,5));

    }


    @Test
    public void testJugadorRojoColocaUnSoldadoEnUnCasilleroDelSectorAliadoConExito() {

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",3,8);

        Assertions.assertFalse(tablero.estaVacio(3,8));
    }

    @Test
    public void testJugadorRojoNoPuedeColocarUnSoldadoEnUnCasilleroDelSectorEnemigo() {

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        Assertions.assertThrows(NoSePuedeColocarUnidadEnSectorEnemigoException.class, () -> jugadorRojo.comprarUnidad("soldado",11,18));
    }

    /*Fin test sectores*/

    @Test
    public void testAlColocarUnSoldadoEnUnCasilleroEstePasaAEstarOcupadoYNoSePuedeColocarOtraUnidadEncima(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        Soldado otroSoldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () -> tablero.colocarUnidad(otroSoldado, 5, 5));
    }

    @Test
    public void testSoldadoSeMueveUnCasilleroAlNorteYLoOcupa(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlNorte(5,5);


        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,5));

    }

    @Test
    public void testSoldadoSeMueveUnCasilleroAlEsteYLoOcupa(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlEste(5,5);


        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,6));

    }

    @Test
    public void testSoldadoSeMueveUnCasilleroAlSurYLoOcupa(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlSur(5,5);


        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,5));

    }


    @Test
    public void testSoldadoSeMueveUnCasilleroAlOesteYLoOcupa(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlOeste(5,5);


        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,4));

    }

    @Test
    public void testSoldadoNoSePuedeMoverAlEstePorqueElCasilleroEstaOcupado(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        Soldado otroSoldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.colocarUnidad(otroSoldado,5,6);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () -> tablero.pasoAlEste(5,5));


    }

    /**Ataques*/

    @Test
    public void testSoldadoAtacaAOtroSoldadoQueEstaEnDistanciaCercanaYLeQuita10PuntosDeVida(){

        Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();

        soldado.setAlianza(Alianza.AZUL);
        soldadoEnemigo.setAlianza(Alianza.ROJO);

        soldado.atacar(2,soldadoEnemigo);

        Assertions.assertEquals(90, soldadoEnemigo.getPuntosDeVida());
    }


    @Test
    public void testSoldadoAtacaAOtroSoldadoQueNoEstaEnDistanciaCercanaYNoLeQuitaVida(){

        Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();

        soldado.setAlianza(Alianza.AZUL);
        soldadoEnemigo.setAlianza(Alianza.ROJO);

        Assertions.assertEquals(100, soldadoEnemigo.getPuntosDeVida());
        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> soldado.atacar(3,soldadoEnemigo));
    }


    @Test
    public void testSoldadoAzulAtacaAUnSoldadoRojoQueEstaEnDistanciaCercanaYLeQuita10PuntosDeVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);
        JugadorRojo jugadorRojo = new JugadorRojo("lego",tablero);

        jugadorAzul.comprarUnidad("soldado",11,5);
        jugadorRojo.comprarUnidad("soldado",10,5);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(11,5,10,5);

        Assertions.assertEquals(90, tablero.getPuntosDeVidaUnidadEnPosicion(10,5));
    }


    @Test
    public void testSoldadoRojoAtacaAUnSoldadoAzulQueNoEstaEnDistanciaCercanaYNoLeQuitaVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);
        JugadorRojo jugadorRojo = new JugadorRojo("lego",tablero);

        jugadorRojo.comprarUnidad("soldado",4,10);
        jugadorAzul.comprarUnidad("soldado",12,5);

        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> tablero.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(12,5,4,10));
        Assertions.assertEquals(100, tablero.getPuntosDeVidaUnidadEnPosicion(12,5));
    }

    @Test
    public void testJineteAzulAtacaAUnSoldadoRojoQueEstaEnDistanciaMedianaYLeQuita15PuntosDeVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);
        JugadorRojo jugadorRojo = new JugadorRojo("lego",tablero);

        jugadorAzul.comprarUnidad("jinete",10,12);
        jugadorRojo.comprarUnidad("jinete",6,14);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(10,12,6,14);

        Assertions.assertEquals(85, tablero.getPuntosDeVidaUnidadEnPosicion(6,14));
    }


    @Test
    public void testCuranderoAzulCuraAUnSoldadoAliadoQueEstaEnDistanciaCercanaYLeDa15PuntosDeVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("curandero",18,12);
        jugadorAzul.comprarUnidad("soldado",17,14);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(18,12,17,14);

        Assertions.assertEquals(115, tablero.getPuntosDeVidaUnidadEnPosicion(17,14));
    }

    @Test
    public void testCuranderoAzulNoPuedeCurarAUnaCatapultaAzul(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("curandero",18,12);
        jugadorAzul.comprarUnidad("catapulta",17,14);

        Assertions.assertThrows(NoSePuedenCurarUnidadesNoOrganicasException.class, () -> tablero.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(18,12,17,14));
    }

    /**Unidades aliadas no pueden atacarse y curanderos no pueden curar unidades enemigas*/
    @Test
    public void testCuranderoAzulNoPuedeCurarAUnSoldadoRojo(){

        Tablero tablero = new Tablero();

        Curandero curanderoAzul = new Curandero();
        Soldado soldadoRojo = new Soldado();

        soldadoRojo.setAlianza(Alianza.ROJO);
        curanderoAzul.setAlianza(Alianza.AZUL);

        curanderoAzul.atacar(2,soldadoRojo);

        Assertions.assertEquals(100, soldadoRojo.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAzulNoPuedeAtacarAUnSoldadoAzul(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("soldado",18,12);
        jugadorAzul.comprarUnidad("soldado",17,14);

        Assertions.assertThrows(NoSePuedeAtacarAUnaUnidadAliadaException.class,
                () -> jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(18,12,17,14));
        Assertions.assertEquals(100, tablero.getPuntosDeVidaUnidadEnPosicion(17,14));
    }


    /**Jugador no puede mover fichas enemigas*/

    @Test
    public void testJugadorAzulNoPuedeMoverUnaUnidadEnemiga(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);
        Soldado soldadoEnemigo = new Soldado();

        jugadorAzul.comprarUnidad("soldado",18,12);
        tablero.colocarUnidad(soldadoEnemigo,6,6);

        Assertions.assertThrows(CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException.class, () -> jugadorAzul.unidadPasoAlNorte(6,6));

    }


}
