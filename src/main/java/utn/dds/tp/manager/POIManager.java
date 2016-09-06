package utn.dds.tp.manager;

import utn.dds.tp.datasource.FuenteExterna;
import utn.dds.tp.poi.POI;

import java.util.*;

/**
 * Created by aleoz on 9/6/16.
 */
public class POIManager {

    private Map<Long, POI> pois = new HashMap<>();
    private Collection<FuenteExterna> fuentesExternas = new ArrayList<>();


    /**
     * Busqueda de POIs mediante un texto libre
     * @param texto
     * @return
     */
    public Collection<POI> buscar(String texto) {
        Collection<POI> result = new ArrayList<>();

        // fuente de datos local
        for(POI poi : this.pois.values()) {
            if(poi.contieneTexto(texto)){
                result.add(poi);
            }
        }

        // fuentes de datos externas
        Collection<POI> resultExterna;
        for(FuenteExterna ext : this.fuentesExternas){
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
        for(POI poi : this.pois.values()) {
            if(poi.contieneTexto(texto) && poi.estaDisponible(instante)){
                result.add(poi);
            }
        }

        // fuentes de datos externas
        Collection<POI> resultExterna;
        for(FuenteExterna ext : this.fuentesExternas){
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

    public POI getPOIbyId(Long id) {
        return this.pois.get(id);
    }

    /**
     * Agrega un nuevo POI al sistema
     * @param poi
     * @return
     */
    public POI createPOI(POI poi) {
        try {
            Long id = this.generateId();
            poi.setId(id);
            this.pois.put(id, poi);
            return poi;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Elimina un POI del sistema
     * @param id
     * @return
     */
    public boolean deletePOI(Long id){
        if(this.pois.get(id) != null){
            this.pois.remove(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Actualiza un POI del sistema con los valores del POI pasado como parametro
     * @param poi
     * @return
     */
    public POI updatePOI(POI poi){
        // ToDo: implementar!!!!
        return poi;
    }

    private Long generateId() {
        Long id;
        do {
            id = Math.round(Math.random() * 100000);
        } while(this.getPOIbyId(id) != null);
        return id;
    }

}
