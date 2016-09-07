package utn.dds.tp.report;

import utn.dds.tp.user.Usuario;

import java.util.Date;

/**
 * Created by aleoz on 9/7/16.
 */
public class BusquedaEntry {

    private String query;
    private int resultados;
    private long duracion;
    private Usuario terminal;
    private Date fecha;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getResultados() {
        return resultados;
    }

    public void setResultados(int resultados) {
        this.resultados = resultados;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public Usuario getTerminal() {
        return terminal;
    }

    public void setTerminal(Usuario terminal) {
        this.terminal = terminal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
