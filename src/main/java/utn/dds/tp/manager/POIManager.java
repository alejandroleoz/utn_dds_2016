package utn.dds.tp.manager;

import utn.dds.tp.datasource.FuenteExterna;
import utn.dds.tp.poi.POI;
import utn.dds.tp.search.Buscador;

import java.util.*;

/**
 * Created by aleoz on 9/6/16.
 */
public class POIManager {

    private Map<Long, POI> pois = new HashMap<>();
    private Collection<FuenteExterna> fuentesExternas = new ArrayList<>();

    // 3ra entrega
    private Buscador buscador;


    /**
     * Busqueda de POIs mediante un texto libre
     * @param texto
     * @return
     */
    public Collection<POI> buscar(String texto) {
        this.buscador.setConfig(this.pois, this.fuentesExternas);
        return this.buscador.buscar(texto);
    }

    /**
     * Busqueda de POIs mediante texto libre y fecha (instante)
     * @param texto
     * @param instante
     * @return
     */
    public Collection<POI> buscar(String texto, Date instante) {
        this.buscador.setConfig(this.pois, this.fuentesExternas);
        return this.buscador.buscar(texto, instante);
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


    public void setFuentesExternas(Collection<FuenteExterna> fuentesExternas) {
        this.fuentesExternas = fuentesExternas;
    }

    // 3ra entrega
    public void setBuscador(Buscador buscador) {
        this.buscador = buscador;
    }
}
