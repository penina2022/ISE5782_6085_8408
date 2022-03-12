package geometries;

import primitives.Double3;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;


public class Tube implements Geometry
{
    final Ray axisRay;
    final double radius;

    public Tube(Ray axisRay, double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    public Ray getAxis() {
        return axisRay;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + radius +
                '}';
    }

    /**
     * calculates normal for infinite cylinder(tube)
     * @param point
     * @return
     */
    @Override
    public Vector getNormal(Point point) {
        double t = axisRay.getDirection().dotProduct(point.subtract( axisRay.getP0()));//finding scaler for the projection of point on axisRay
        Point O = axisRay.getP0().add(axisRay.getDirection().scale(t));// O is the projection of point on axisRay
        Vector N=point.subtract(O);
        return N.normalize();
    }

}
