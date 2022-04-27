package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.isZero;

public class Sphere implements Geometry, Intersectable {
    final Point _center;
    final double _radius;

    public Sphere(Point center, double radius) {
        this._center = center;
        this._radius = radius;
    }

    @Override
    public Vector getNormal(Point point) {
        Vector N=point.subtract(_center);
        return N.normalize();
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", radius=" + _radius +
                '}';
    }

    @Override
    public List<Point> findIntersectionpoints(Ray ray) {
        Point p0 = new Point(ray.getP0().get_x(),ray.getP0().get_y(),ray.getP0().get_z());
        //if the ray starts at the center add epsilon
        if(_center.equals(ray.getP0()))
            p0 = new Point(ray.getP0().get_x() + 0.1111111115,ray.getP0().get_y(), ray.getP0().get_z());
        //now we need new ray because of we add epsilon to _POO
        Ray myRay = new Ray(p0,ray.getDir());
        //u = o - p0
        Vector u = _center.subtract(p0);
        //t_m = v * u
        double t_m = myRay.getDir().dotProduct(u);
        //d = sqrt(|u|^2 - t_m^2)
        double d = Math.sqrt(u.lengthSquared() - t_m*t_m);
        //there are no intersections
        if(d>_radius)
            return null;
        //t_h = sqrt(r^2 - d^2)
        double t_h = Math.sqrt(_radius*_radius - d*d);
        //t1,2 = t_m +- t_h
        double t1 = t_m + t_h;
        double t2 = t_m - t_h;
        Point p1 = null;
        Point p2 = null;
        //if the ray tangent to the sphere - t_h=0
        if(t1 == t2)
            t2 = -1; //that`s for that it will not return the same point twice
        //only if t1>0
        if(!isZero(t1) && t1>0)
            //p1 = p0 + t1*v
            p1 = myRay.getP0().add(myRay.getDir().scale(t1));
        //only if t2>0
        if(!isZero(t2) && t2>0)
            //p2 = p0 + t2*v
            p2 = myRay.getP0().add(myRay.getDir().scale(t2));
        //if it is no intersections points
        if(p1 == null && p2 == null)
            return null;
        ArrayList<Point> intsersection = new ArrayList<Point>();
        if(p1 != null)
            intsersection.add(p1);
        if(p2 != null)
            intsersection.add(p2);
        return intsersection;
    }
}


