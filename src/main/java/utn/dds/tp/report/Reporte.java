package utn.dds.tp.report;


import java.util.List;
import java.util.Map;

public interface Reporte<V,W> {

    public String getTitulo();

    public List<String> getEncabezados();

    /**
     * Lo que se muestra
     * Lista de "filas" (cada fila tiene "columnas")
     * @return
     */
    // Todo: esto hay que cambiarlo porque Map no asegura orden
    public List<List<String>> getFilasFormateadas();

    /**
     * Datos
     * @param filas
     */
    // Todo: esto hay que cambiarlo porque Map no asegura orden
    public void setFilas(Map<V, W> filas);

    public void export(ExportStrategy estrategia);
}
