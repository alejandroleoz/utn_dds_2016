package utn.dds.tp.poi;

import utn.dds.tp.poi.aux.Coordenada;
import utn.dds.tp.poi.aux.DistanceCalculator;

import java.util.Date;


public class ParadaColectivo extends POI {

    public static double RADIO_CERCANIA = 100;

    private String linea;

    @Override
    public boolean estaCerca(Coordenada coordenada) {
        return DistanceCalculator.getDistance(this.getCoordenada(), coordenada) <= RADIO_CERCANIA;
    }

    @Override
    public boolean estaDisponible(Date date) {
        return true;
    }

    @Override
    public boolean contieneTexto(String texto) {
        return super.contieneTexto(texto) || this.linea.toLowerCase().contains(texto);
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
}
