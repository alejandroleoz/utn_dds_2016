package utn.dds.tp.poi.aux;

import com.grum.geocalc.Coordinate;
import com.grum.geocalc.DegreeCoordinate;
import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;

/**
 * Created by aleoz on 6/21/16.
 */
public class DistanceCalculator {

    public static double getDistance(Coordenada c1, Coordenada c2){
        if(c1.getLatitud() == c2.getLatitud() && c1.getLongitud() == c2.getLongitud()){
            return 0;
        }

        Coordinate lat = new DegreeCoordinate(c1.getLatitud());
        Coordinate lng = new DegreeCoordinate(c1.getLongitud());
        Point point1 = new Point(lat, lng);

        lat = new DegreeCoordinate(c2.getLatitud());
        lng = new DegreeCoordinate(c2.getLongitud());
        Point point2 = new Point(lat, lng);

        return EarthCalc.getDistance(point2, point1); //in meters
    }

}
