package utn.dds.tp.report;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by aleoz on 9/7/16.
 */
public class TotalPorTerminal implements Reporte<String, Integer> {

    private Map<String, Integer> filas;

    public void setFilas(Map<String, Integer> filas) {
        this.filas = filas;
    }

    @Override
    public String getTitulo() {
        // todo: hardcodeado!
        return "Totales por terminal";
    }

    @Override
    public List<String> getEncabezados() {
        // todo!!
        return Collections.emptyList();
    }

    @Override
    public List<List<String>> getFilasFormateadas() {
        // todo !!!
        return Collections.emptyList();
    }

    @Override
    public void export(ExportStrategy estrategia) {
        estrategia.exportar(this);
    }

}
