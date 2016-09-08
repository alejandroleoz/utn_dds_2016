package utn.dds.tp.search;

import utn.dds.tp.Flyweight;
import utn.dds.tp.poi.POI;
import utn.dds.tp.report.BusquedaEntry;

import java.util.Collection;
import java.util.Date;

/**
 * Created by aleoz on 9/6/16.
 */
public class HistoricoProxy extends AbstractBuscador {

    @Override
    public Collection<POI> buscar(String texto) {
        this.getBuscador().setConfig(this.getPois(), this.getFuentesExternas());
        Collection<POI> result = this.getBuscador().buscar(texto);

        crearRegistroHistorico(texto, result);

        return result;
    }

    @Override
    public Collection<POI> buscar(String texto, Date instante) {
        this.getBuscador().setConfig(this.getPois(), this.getFuentesExternas());
        Collection<POI> result = this.getBuscador().buscar(texto, instante);

        crearRegistroHistorico(texto, result);

        return result;
    }

    private void crearRegistroHistorico(String texto, Collection<POI> result) {

        // TODO: Esta forma no es la mejor, pero es importante identificarla para poder REFACTORIZARLA luego
        long duracion = 0;
        try{
            TimerProxy timer = (TimerProxy) this.getBuscador();
            duracion = timer.getDuracion();
        }catch (Exception e){
            // el buscador no es un timer
        }
        // ---------------------------------------------------------------

        BusquedaEntry entry = new BusquedaEntry();
        entry.setFecha(new Date());
        entry.setQuery(texto);
        entry.setResultados(result.size());
        entry.setDuracion(duracion);

        // Todo -> Terminal!!!
//        entry.setTerminal();

        // uso singleton
        Flyweight.getInstance().getReportManager().addEntry(entry);
    }
}
