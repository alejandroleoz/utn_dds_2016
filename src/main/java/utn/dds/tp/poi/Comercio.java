package utn.dds.tp.poi;

import utn.dds.tp.poi.aux.Coordenada;
import utn.dds.tp.poi.aux.DistanceCalculator;
import utn.dds.tp.poi.aux.Horario;

import java.util.Collection;
import java.util.Date;

/**
 * Created by aleoz on 9/6/16.
 */
public class Comercio extends POI {

    private Collection<Rubro> rubros;
    private Collection<Horario> horarios;

    @Override
    public boolean estaCerca(Coordenada coordenada) {
        boolean isCerca = false;
        for(Rubro rubro : this.rubros){
            double distancia = DistanceCalculator.getDistance(coordenada, this.getCoordenada());
            if(distancia <= rubro.getRadioCercania()){
                isCerca = true;
            }
        }
        return isCerca;
    }

    @Override
    public boolean estaDisponible(Date date) {
        for(Horario horario : this.horarios) {
            if(horario.estaEnRango(date)){
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean contieneTexto(String texto) {
        // todo: checkear Rubros
        return super.contieneTexto(texto);
    }
}
