package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

import primitives.Point;
import primitives.Ray;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable
{
    List<Intersectable>_intersectablesList;

    public Geometries() {
        _intersectablesList = new LinkedList<>();
    }

    public Geometries(Intersectable... intersectables)
    {
        _intersectablesList = new LinkedList<>();
        Collections.addAll(_intersectablesList, intersectables);

    }

    public void add(Intersectable...intersectables){
        Collections.addAll(_intersectablesList,intersectables);
    }

//    public void remove(Intersectable... intersectables)
//    {
//        _intersectablesList.removeAll(List.of(intersectables))
//    }

    @Override
    public List<Point> findIntersectionpoints(Ray ray) {
        List<Point> result = null;

        //iterate over the list of the geometries and find the intersections for each one
        //add the results to list "result"
        for (Intersectable item : _intersectablesList) {
            List<Point> itemPoints = item.findIntersectionpoints(ray);
            if (itemPoints != null) {
                if (result == null) {
                    result = new LinkedList<>();
                }
                result.addAll(itemPoints);
            }
        }
        return result;
    }
}
