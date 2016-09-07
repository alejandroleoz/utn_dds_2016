package utn.dds.tp.report;


import java.util.Map;

public interface Reporte<V,W> {

    public void setFilas(Map<V, W> filas);

    public void print();
}
