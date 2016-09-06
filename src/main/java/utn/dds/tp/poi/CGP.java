package utn.dds.tp.poi;

import utn.dds.tp.poi.aux.Coordenada;
import utn.dds.tp.poi.aux.Horario;

import java.util.Collection;
import java.util.Date;

/**
 * Created by aleoz on 9/6/16.
 */
public class CGP extends POI {

    private Collection<Servicio> servicios;

    @Override
    public boolean estaCerca(Coordenada coordenada) {
        return this.getComuna().contieneCoordenada(coordenada);
    }

    @Override
    public boolean estaDisponible(Date date) {

        // Todo: busqueda por palabra clave

        for(Servicio servicio : this.servicios){
            for(Horario horario : servicio.getHorarios()){
                if(horario.estaEnRango(date)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contieneTexto(String texto) {
        // todo: checkear Servicios
        return super.contieneTexto(texto);
    }
}
