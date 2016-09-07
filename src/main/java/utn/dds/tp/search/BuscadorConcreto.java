package utn.dds.tp.search;

import utn.dds.tp.datasource.FuenteExterna;
import utn.dds.tp.poi.POI;

import java.util.*;

/**
 * Created by aleoz on 9/6/16.
 */
public class BuscadorConcreto extends AbstractBuscador {

    /**
     * Busqueda de POIs mediante un texto libre
     * @param texto
     * @return
     */
    public Collection<POI> buscar(String texto) {
        Collection<POI> result = new ArrayList<>();

        // fuente de datos local
        for(POI poi : this.getPois().values()) {
            if(poi.contieneTexto(texto)){
                result.add(poi);
            }
        }

        // fuentes de datos externas
        Collection<POI> resultExterna;
        for(FuenteExterna ext : this.getFuentesExternas()){
            resultExterna = ext.consultar(Arrays.asList(texto));
            result.addAll(resultExterna);
        }

        return result;
    }

    /**
     * Busqueda de POIs mediante texto libre y fecha (instante)
     * @param texto
     * @param instante
     * @return
     */
    public Collection<POI> buscar(String texto, Date instante) {
        Collection<POI> result = new ArrayList<>();

        // fuente de datos local
        for(POI poi : this.getPois().values()) {
            if(poi.contieneTexto(texto) && poi.estaDisponible(instante)){
                result.add(poi);
            }
        }

        // fuentes de datos externas
        Collection<POI> resultExterna;
        for(FuenteExterna ext : this.getFuentesExternas()){
            resultExterna = ext.consultar(Arrays.asList(texto));

            // de las que vinieron, veo cuales estan disponibles...
            for(POI poi : resultExterna){
                if(poi.estaDisponible(instante)){
                    result.add(poi);
                }
            }
        }
        return result;
    }
}
