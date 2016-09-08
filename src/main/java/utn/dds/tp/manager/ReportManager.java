package utn.dds.tp.manager;

import utn.dds.tp.report.BusquedaEntry;
import utn.dds.tp.report.Reporte;
import utn.dds.tp.report.TotalPorFecha;
import utn.dds.tp.report.TotalPorTerminal;

import java.util.*;

/**
 * Created by aleoz on 9/6/16.
 */
public class ReportManager {

    private Collection<BusquedaEntry> registro;

    public ReportManager(){
        this.registro = new ArrayList<>();
    }

    public void addEntry(BusquedaEntry entry) {
        this.registro.add(entry);
    }

    /**
     * Crea reporte que sumariza resultados por fecha
     * @return
     */
    public Reporte crearTotalPorFecha() {
        TotalPorFecha reporte = new TotalPorFecha();
        Map<Date, Integer> filas = new HashMap<>();
        for (BusquedaEntry entry : this.registro) {
            Date dateKey = new Date(entry.getFecha().getYear(), entry.getFecha().getMonth(), entry.getFecha().getDate());

            if(filas.get(dateKey) == null){
                filas.put(dateKey, entry.getResultados());
            } else {
                Integer count = filas.get(dateKey);
                count += entry.getResultados();
                filas.put(dateKey, count);
            }
        }
        reporte.setFilas(filas);
        return reporte;
    }

    /**
     * Crea reporte que sumariza resultados por terminal
     * @return
     */
    public Reporte crearTotalPorTerminal() {
        TotalPorTerminal reporte = new TotalPorTerminal();
        Map<String, Integer> filas = new HashMap<>();
        for (BusquedaEntry entry : this.registro) {
            Integer count = filas.get(entry.getTerminal().getUsername());
            if(count == null) {
                filas.put(entry.getTerminal().getUsername(), entry.getResultados());
            } else {
                count += entry.getResultados();
                filas.put(entry.getTerminal().getUsername(), count);
            }
        }
        reporte.setFilas(filas);
        return reporte;
    }
}
