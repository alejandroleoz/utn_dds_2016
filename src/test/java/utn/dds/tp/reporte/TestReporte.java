package utn.dds.tp.reporte;

import org.junit.Assert;
import org.junit.Test;
import utn.dds.tp.Flyweight;
import utn.dds.tp.datasource.BancoAdapter;
import utn.dds.tp.datasource.CGPAdapter;
import utn.dds.tp.manager.POIManager;
import utn.dds.tp.poi.POI;
import utn.dds.tp.report.Reporte;
import utn.dds.tp.search.BuscadorConcreto;
import utn.dds.tp.search.HistoricoProxy;
import utn.dds.tp.search.TimerProxy;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Created by aleoz on 9/7/16.
 */
public class TestReporte {

    @Test
    public void test(){
        // buscador concreto
        BuscadorConcreto buscador = new BuscadorConcreto();

        // timer
        TimerProxy timer = new TimerProxy();
        timer.setBuscador(buscador);

        // historico Proxy
        HistoricoProxy historicoProxy = new HistoricoProxy();
        historicoProxy.setBuscador(timer);

        POIManager poiManager = Flyweight.getInstance().getPoiManager();
        poiManager.setFuentesExternas(Arrays.asList(new BancoAdapter(), new CGPAdapter()));
        poiManager.setBuscador(historicoProxy);

        // TODO: habría que Mockear el servicio externo!!

        // devuelve 1 resultaod (banco santander)
        poiManager.buscar("tand");

        // devuelve 1 resultado (zona almagro)
        poiManager.buscar("almagro");

        Reporte reporte = Flyweight.getInstance().getReportManager().crearTotalPorFecha();
        reporte.print();

        try {
            Field field = reporte.getClass().getDeclaredField("filas");
            field.setAccessible(true);
            Map<Date, Integer> filas = (Map) field.get(reporte);
            Assert.assertEquals("Cantidad de filas", 1, filas.values().size());

            Date currentDate = new Date();
            for (Map.Entry<Date, Integer> entry : filas.entrySet()) {
                Date date = entry.getKey();
                Assert.assertTrue("Fecha actual", this.checkDates(date, currentDate));
                Assert.assertEquals("Cantidad", 2, entry.getValue().intValue());
            }
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean checkDates(Date d1, Date d2){
        return d1.getYear() == d2.getYear() && d1.getMonth() == d2.getMonth() && d1.getDate() == d2.getDate();
    }
}
