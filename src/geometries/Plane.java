package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;
import java.util.Objects;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane extends Geometry {
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
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        Point P0 = ray.getP0();
        Vector v = ray.getDir();
        Vector n = _normal;
        double nv = n.dotProduct((v)); //nv=n*v

        // ray parallel to plane
        if (isZero(nv)) {
            return null;
        }

        //  ray cannot start from the plane
        if (_q0.equals(P0)) {
            return null;
        }

        Vector Q0_P0 = _q0.subtract(P0);

        double numerator = n.dotProduct(Q0_P0); //numerator=n*Q0_P0

        //in this case P0 is on the plane, so return null
        if (isZero(numerator)) {
            return null;
        }
        double t = alignZero(numerator / nv); //t=numerator/nv

        //if t>0 the ray does point toward the plane
        if (t > 0) {
            GeoPoint P = new GeoPoint(this, P0.add(v.scale(t))); //new GeoPoint{geometry=this, point=p0+tv}
            return List.of(P);
        }
        //otherwise it doesn't point toward the plane, so return null
        return null;
    }
}

