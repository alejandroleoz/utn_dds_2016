package utn.dds.tp.report;

import java.util.Date;
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
    public void print() {

    }

}
