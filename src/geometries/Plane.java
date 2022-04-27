package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;
import java.util.Objects;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane implements Geometry, Intersectable {
    final private Point _q0;
    final private Vector _normal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return _q0.equals(plane._q0) && _normal.equals(plane._normal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_q0, _normal);
    }

    public Plane(Point q0, Vector normal) {
        _q0 = q0;
        _normal = normal;
    }

    public Plane(Point p1, Point p2, Point p3) {
        this._q0 = p1;
        //        //TODO check direction of vectors
//        Vector U = p1.subtract(p2);
//        Vector V = p3.subtract(p2);

        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);
        Vector N = U.crossProduct(V);
        //right hand rule
        this._normal = N.normalize();
    }

    public Point getQ0() {
        return _q0;
    }

    /**
     *  getter for _normal Vector
     * @return the infamous normal
     */
    public Vector getNormal() {
        return _normal;
    }

    /**
     *  implementation of {@link Geometry#getNormal(Point)}
     *
     * @param point external Point
     * @return normal to plane
     */
    @Override
    public Vector getNormal(Point point) {
        return getNormal();
    }


    @Override
    public List<Point> findIntersectionpoints(Ray ray) {
        Point P0=ray.getP0();
        Vector v=ray.getDir();
        Vector n=_normal;
        //denominator
        double nv = n.dotProduct(v);

        if (isZero(nv)) {
            return null;
        }
        Vector P0_Q=_q0.subtract(P0);
        double t=alignZero(n.dotProduct(P0_Q)/nv);
        //if t < 0 the array point to the opposite direction
        // if t==0 the ray origin lay with ×”×§×¨×Ÿ ×œ× ×‘×›×™×•×•×Ÿ ×©×× ×—× ×• ×¨×•×¦×™×
        if(t > 0)
        {
            Point P=P0.add(v.scale(t));
            return List.of(P);
        }

        return null;
    }
}

