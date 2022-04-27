package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public interface Geometry
{
    public Vector getNormal(Point p);
    List<Point> findIntersectionpoints(Ray ray);
}
