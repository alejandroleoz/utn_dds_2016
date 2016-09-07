package utn.dds.tp.datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import utn.dds.tp.poi.CGP;
import utn.dds.tp.poi.POI;

import java.util.*;

/**
 * Created by aleoz on 9/6/16.
 */
public class CGPAdapter extends AbstractFuenteExterna {

    // todo: hardcodeado
    private static String URL = "http://trimatek.org/Consultas/centro";

    @Override
    public Collection<POI> consultar(List<String> parametros) {
        Map<String, String> params = new HashMap<>();
        try{
            params.put("zona", parametros.get(0));
        } catch (Exception e){
            // no tiene todos los parametros
        }

        // leo del server
        JsonNode jsonNode = this.leerFuente(URL, params);

        Collection<POI> result = new ArrayList<>();
        for (int i = 0; i < jsonNode.size(); i++) {
            ObjectNode obj = (ObjectNode) jsonNode.get(i);
            CGP cgp = new CGP();
            cgp.setNombre("Comuna" + obj.get("comuna"));
            // todo: setear todos los fields !
            result.add(cgp);
        }
        return result;
    }
}
