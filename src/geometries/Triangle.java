package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Triangle extends Polygon implements Geometry, Intersectable {
    public Triangle(Point p1, Point p2, Point p3)
    {
        super(p1, p2, p3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "vertices=" + vertices +
                ", plane=" + plane +
                '}';
    }

    @Override
    public List<Point> findIntersectionpoints(Ray ray) {
        //comment here
        List<Point> result =plane.findIntersectionpoints(ray);
        if(result == null)
            return null;

        Point P0=ray.getP0();
        Vector v=ray.getDirection();

        Point p1 = vertices.get(0);
        Point p2 = vertices.get(1);
        Point p3 = vertices.get(2);

        Vector v1 = p1.subtract(P0);//(P0->p1)
        Vector v2 = p2.subtract(P0);//(P0->p2)
        Vector v3 = p3.subtract(P0);//(P0->p3)

        Vector n1 = v1.crossProduct(v2);
        Vector n2 = v2.crossProduct(v3);
        Vector n3 = v3.crossProduct(v1);

        double s1 = v.dotProduct(n1);
        double s2 = v.dotProduct(n2);
        double s3 = v.dotProduct(n3);

        if((s1>0 && s2>0 && s3>0 )|| (s1<0 && s2<0 && s3<0))
        {
            return result;
        }
        return super.findIntersectionpoints(ray);
    }
}


