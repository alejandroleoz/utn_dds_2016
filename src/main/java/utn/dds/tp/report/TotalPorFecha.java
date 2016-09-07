package utn.dds.tp.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by aleoz on 9/7/16.
 */
public class TotalPorFecha implements Reporte<Date, Integer> {

    private Map<Date, Integer> filas;

    public void setFilas(Map<Date, Integer> filas) {
        this.filas = filas;
    }

    @Override
    public void print() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Totales por fecha");
        System.out.println("-------------------");
        for (Map.Entry<Date, Integer> entry : filas.entrySet()) {
            System.out.println(format.format(entry.getKey()) + ": " + entry.getValue());
        }
        System.out.println();
    }
}
