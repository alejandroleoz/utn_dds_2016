package utn.dds.tp.datasource;

import utn.dds.tp.poi.CGP;
import utn.dds.tp.poi.POI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by aleoz on 9/8/16.
 */
public class MockCGPAdapter extends CGPAdapter {

    @Override
    public Collection<POI> consultar(List<String> parametros) {
        Collection<POI> result = new ArrayList<>();
        result.add(crearPOI("Comuna 4"));
        result.add(crearPOI("Comuna 5"));
        return result;
    }

    private POI crearPOI(String nombre){
        CGP cgp = new CGP();
        cgp.setNombre(nombre);
        return cgp;
    }
}
