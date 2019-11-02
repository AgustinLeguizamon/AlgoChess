package AlgoChess;

import java.util.HashMap;
import java.util.Map;

public class Cuartel {

    private Map<String,Unidad> unidades;

    public Cuartel(){

        unidades = new HashMap<String,Unidad>();
        unidades.put("soldado",new Soldado());
        unidades.put("jinete",new Jinete());
        unidades.put("curandero", new Curandero());
        unidades.put("catapulta", new Catapulta());

    }

    public Unidad getUnidad(String nombreUnidad, int puntos) {

        Unidad unidad = unidades.get(nombreUnidad);
        if( unidad.getCosto() > puntos){
            throw new PuntosInsuficientes();
        }

        return unidad.copiar();
    }

}
