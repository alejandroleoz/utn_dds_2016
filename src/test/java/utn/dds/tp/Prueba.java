package utn.dds.tp;

import utn.dds.tp.datasource.BancoAdapter;
import utn.dds.tp.datasource.CGPAdapter;
import utn.dds.tp.manager.POIManager;
import utn.dds.tp.poi.POI;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by aleoz on 9/6/16.
 */
public class Prueba {

    public static void main(String[] args) {

        POIManager poiManager = new POIManager();
        poiManager.setFuentesExternas(Arrays.asList(new BancoAdapter(), new CGPAdapter()));
        Collection<POI> pois = poiManager.buscar("Alm");

        for (POI poi : pois) {
            System.out.println(poi.getNombre());
        }


    }
}
