package utn.dds.tp.datasource;

import utn.dds.tp.poi.Banco;
import utn.dds.tp.poi.POI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by aleoz on 9/8/16.
 */
public class MockBancoAdapter extends BancoAdapter {

    @Override
    public Collection<POI> consultar(List<String> parametros) {
        Collection<POI> result = new ArrayList<>();
        result.add(this.crearPOI("Santander - Almagro"));
        result.add(this.crearPOI("Santander - Microcentro"));
        result.add(this.crearPOI("Santander - Caballito"));
        return result;
    }

    private POI crearPOI(String nombre){
        Banco banco = new Banco();
        banco.setNombre(nombre);
        return banco;
    }
}
