package utn.dds.tp.report;

import java.util.List;

/**
 * Created by aleoz on 9/9/16.
 */
public class ExportStandardOutput implements ExportStrategy {

    @Override
    public void exportar(Reporte reporte) {
        System.out.println("****************************************************");
        System.out.println("\t" + reporte.getTitulo());
        System.out.println("****************************************************");

        List<String> encabezados = reporte.getEncabezados();
        for (String encabezado : encabezados) {
            System.out.println(encabezado + "\t");
        }
        System.out.println("----------------------------------------------------");

        List<List<String>> filas = reporte.getFilasFormateadas();
        for (List<String> fila : filas) {
            for (String celda : fila) {
                System.out.print(celda + "\t");
            }
        }
        System.out.println();
        System.out.println("----------------------------------------------------");

        System.out.println();
    }
}
