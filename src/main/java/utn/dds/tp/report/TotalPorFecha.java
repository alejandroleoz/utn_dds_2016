package utn.dds.tp.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by aleoz on 9/7/16.
 */
public class TotalPorFecha implements Reporte<Date, Integer> {

    private Map<Date, Integer> filas;

    public void setFilas(Map<Date, Integer> filas) {
        this.filas = filas;
    }

    @Override
    public String getTitulo() {
        // todo: hardcodeado!
        return "Totales por fecha";
    }

    @Override
    public List<String> getEncabezados() {
        return Collections.emptyList();
    }

    @Override
    public List<List<String>> getFilasFormateadas() {
        // todo: hardcoded
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Date, Integer> entry : this.filas.entrySet()) {
            List<String> fila = new ArrayList<>();
            fila.add(format.format(entry.getKey()));
            fila.add(entry.getValue().toString());
            result.add(fila);
        }
        return result;
    }

    @Override
    public void export(ExportStrategy estrategia) {
        estrategia.exportar(this);
    }
}
