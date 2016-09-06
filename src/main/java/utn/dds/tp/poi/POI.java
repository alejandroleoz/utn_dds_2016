package utn.dds.tp.poi;


import utn.dds.tp.poi.aux.Comuna;
import utn.dds.tp.poi.aux.Coordenada;

import java.util.Date;

public abstract class POI {

    private Long id;
    private String nombre;
    private Coordenada coordenada;
    private Comuna comuna;

    /**
     * Indica si este POI está cerca de la coordenada pasada como parámetro.
     * @param coordenada
     * @return
     */
    public abstract boolean estaCerca(Coordenada coordenada);

    /**
     * Indica si este POI está disponible para la fecha pasada como parámetro
     * @param date
     * @return
     */
    public abstract boolean estaDisponible(Date date);


    public boolean contieneTexto(String texto) {
        return this.getNombre().toLowerCase().contains(texto);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
}
