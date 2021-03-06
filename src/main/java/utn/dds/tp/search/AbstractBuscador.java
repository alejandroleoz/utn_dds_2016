package utn.dds.tp.search;

import utn.dds.tp.datasource.FuenteExterna;
import utn.dds.tp.poi.POI;
import utn.dds.tp.user.Usuario;

import java.util.*;

/**
 * Created by aleoz on 9/6/16.
 */
public abstract class AbstractBuscador implements Buscador {

    private Buscador buscador;
    private Map<Long, POI> pois = new HashMap<>();
    private Collection<FuenteExterna> fuentesExternas = new ArrayList<>();

    public void setConfig(Map<Long, POI> pois, Collection<FuenteExterna> fuenteExternas) {
        this.pois = pois;
        this.fuentesExternas = fuenteExternas;
    }

    public Buscador getBuscador() {
        return buscador;
    }

    public void setBuscador(Buscador buscador) {
        this.buscador = buscador;
    }

    public Map<Long, POI> getPois() {
        return pois;
    }

    public Collection<FuenteExterna> getFuentesExternas() {
        return fuentesExternas;
    }

    @Override
    // Default implementation
    public Collection<POI> buscar(String texto, Usuario terminal) {
        return this.buscar(texto);
    }

    @Override
    // Default implementation
    public Collection<POI> buscar(String texto, Date instante, Usuario terminal) {
        return this.buscar(texto, instante);
    }
}
