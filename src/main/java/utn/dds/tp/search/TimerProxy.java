package utn.dds.tp.search;

import utn.dds.tp.poi.POI;

import java.util.Collection;
import java.util.Date;

/**
 * Created by aleoz on 9/6/16.
 */
public class TimerProxy extends AbstractBuscador {

    private long startTime;
    private long endTime;

    @Override
    public Collection<POI> buscar(String texto) {
        this.getBuscador().setConfig(this.getPois(), this.getFuentesExternas());
        this.startTimer();
        Collection<POI> result = this.getBuscador().buscar(texto);
        this.stopTimer();
        return result;
    }

    @Override
    public Collection<POI> buscar(String texto, Date instante) {
        this.getBuscador().setConfig(this.getPois(), this.getFuentesExternas());
        this.startTimer();
        Collection<POI> result = this.getBuscador().buscar(texto, instante);
        this.stopTimer();
        return result;
    }

    public long getDuracion() {
        return this.endTime - this.startTime;
    }

    private void startTimer() {
        this.startTime = new Date().getTime();
    }

    private void stopTimer() {
        this.endTime = new Date().getTime();
    }

}
