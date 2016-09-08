package utn.dds.tp.search;

import utn.dds.tp.Flyweight;
import utn.dds.tp.poi.POI;
import utn.dds.tp.report.BusquedaEntry;
import utn.dds.tp.user.Terminal;
import utn.dds.tp.user.Usuario;

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
        return result;
    }

    @Override
    public Collection<POI> buscar(String texto, Date instante) {
        this.getBuscador().setConfig(this.getPois(), this.getFuentesExternas());
        Collection<POI> result = this.getBuscador().buscar(texto, instante);
        return result;
    }

    @Override
    public Collection<POI> buscar(String texto, Usuario terminal) {
        Collection<POI> result = this.buscar(texto);
        crearRegistroHistorico(texto, result, terminal);
        return result;
    }

    @Override
    public Collection<POI> buscar(String texto, Date instante, Usuario terminal) {
        Collection<POI> result = this.buscar(texto, instante);
        crearRegistroHistorico(texto, result, terminal);
        return result;
    }

    private void crearRegistroHistorico(String texto, Collection<POI> result, Usuario terminal) {

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
        entry.setTerminal(terminal);

        // uso singleton
        Flyweight.getInstance().getReportManager().addEntry(entry);
    }
}
