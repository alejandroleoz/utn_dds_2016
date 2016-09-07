package utn.dds.tp.search;

import utn.dds.tp.poi.POI;

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
        long duracion = 0;
        try{
            TimerProxy timer = (TimerProxy) this.getBuscador();
            duracion = timer.getDuracion();
        }catch (Exception e){
            // el buscador no es un timer
        }
        System.out.println("Duracion: " + duracion + "ms");
        // todo implementar
    }
}
