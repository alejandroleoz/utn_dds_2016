package utn.dds.tp.search;

import static org.junit.Assert.*;
import org.junit.Test;
import utn.dds.tp.Flyweight;
import utn.dds.tp.datasource.BancoAdapter;
import utn.dds.tp.datasource.CGPAdapter;
import utn.dds.tp.manager.POIManager;
import utn.dds.tp.poi.POI;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by aleoz on 9/7/16.
 */
public class TestBuscador {

    @Test
    public void test_busquedaRemota(){

        // buscador concreto
        BuscadorConcreto buscador = new BuscadorConcreto();

        POIManager poiManager = Flyweight.getInstance().getPoiManager();
        poiManager.setFuentesExternas(Arrays.asList(new BancoAdapter(), new CGPAdapter()));
        poiManager.setBuscador(buscador);

        // TODO: habría que Mockear el servicio externo!!

        Collection<POI> pois = poiManager.buscar("tand");
        assertEquals("Busqueda banco Santander", 1, pois.size());

        pois = poiManager.buscar("magro");
        assertEquals("Busqueda centro Almagro", 1, pois.size());

        pois = poiManager.buscar("");
        assertTrue("Busqueda (todos los resultados)", pois.size() > 1);

        pois = poiManager.buscar("saraza");
        assertEquals("Busqueda 0 resultados", 0, pois.size());
    }
}
