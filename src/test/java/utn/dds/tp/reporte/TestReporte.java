package utn.dds.tp.reporte;

import org.junit.Assert;
import org.junit.Test;
import utn.dds.tp.Flyweight;
import utn.dds.tp.datasource.MockBancoAdapter;
import utn.dds.tp.datasource.MockCGPAdapter;
import utn.dds.tp.manager.POIManager;
import utn.dds.tp.report.ExportStandardOutput;
import utn.dds.tp.report.Reporte;
import utn.dds.tp.search.BuscadorConcreto;
import utn.dds.tp.search.HistoricoProxy;
import utn.dds.tp.search.TimerProxy;
import utn.dds.tp.user.Terminal;
import utn.dds.tp.user.Usuario;

import java.lang.reflect.Field;
import java.util.Arrays;
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

        Usuario terminal = new Usuario("terminal1", "aaabbbccc", Flyweight.getInstance().getRole(Terminal.ROLE));

        POIManager poiManager = Flyweight.getInstance().getPoiManager();
        poiManager.setFuentesExternas(Arrays.asList(new MockBancoAdapter(), new MockCGPAdapter()));
        poiManager.setBuscador(historicoProxy);

        // devuelve 5 resultaos
        poiManager.buscar("tand", terminal);

        // devuelve 5 resultados
        poiManager.buscar("almagro", terminal);

        Reporte reporte = Flyweight.getInstance().getReportManager().crearTotalPorFecha();
        reporte.export(new ExportStandardOutput());

        try {
            Field field = reporte.getClass().getDeclaredField("filas");
            field.setAccessible(true);
            Map<Date, Integer> filas = (Map) field.get(reporte);
            Assert.assertEquals("Cantidad de filas", 1, filas.values().size());

            Date currentDate = new Date();
            for (Map.Entry<Date, Integer> entry : filas.entrySet()) {
                Date date = entry.getKey();
                Assert.assertTrue("Fecha actual", this.checkDates(date, currentDate));
                Assert.assertEquals("Cantidad", 10, entry.getValue().intValue());
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
