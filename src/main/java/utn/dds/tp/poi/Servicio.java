package utn.dds.tp.poi;

import utn.dds.tp.poi.aux.Horario;

import java.util.Collection;

/**
 * Created by aleoz on 9/6/16.
 */
public class Servicio {

    private String nombre;
    private Collection<Horario> horarios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Collection<Horario> horarios) {
        this.horarios = horarios;
    }
}
