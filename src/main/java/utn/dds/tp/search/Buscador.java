package utn.dds.tp.search;

import utn.dds.tp.datasource.FuenteExterna;
import utn.dds.tp.poi.POI;
import utn.dds.tp.user.Usuario;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Created by aleoz on 9/6/16.
 */
public interface Buscador {

    public void setConfig(Map<Long, POI> pois, Collection<FuenteExterna> fuenteExternas);

    public Collection<POI> buscar(String texto);

    public Collection<POI> buscar(String texto, Usuario terminal);

    public Collection<POI> buscar(String texto, Date instante);

    public Collection<POI> buscar(String texto, Date instante, Usuario terminal);

}
