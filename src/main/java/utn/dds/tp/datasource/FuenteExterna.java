package utn.dds.tp.datasource;

import utn.dds.tp.poi.POI;

import java.util.Collection;
import java.util.List;

/**
 * Created by aleoz on 9/6/16.
 */
public interface FuenteExterna {

    public Collection<POI> consultar(List<String> parametros);
}
