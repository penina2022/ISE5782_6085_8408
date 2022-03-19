package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SphereTest {

    @Test
    void testGetNormal()
    {
        // ============ Equivalence Partitions Test ==============
        Sphere sp = new Sphere(new Point(0,0,0),1);
        assertEquals(new Vector(0,0, 1), sp.getNormal(new Point(0, 0, 1)));
    }

    @Test
    public void findIntersections() {
        Sphere sphere = new Sphere(new Point(1, 0, 0),1d);

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertEquals(null,sphere.findIntersectionpoints(new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0))),"Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point p1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        Point p2 = new Point(1.53484692283495, 0.844948974278318, 0);
        List<Point> result1 = sphere.findIntersectionpoints(new Ray(new Point(-1, 0, 0), new Vector(3, 1, 0)));
        assertEquals(2, result1.size(),"Wrong number of points");
        if (result1.get(0).get_x() > result1.get(1).get_x())
            result1 = Arrays.asList(result1.get(1), result1.get(0));
        assertEquals(Arrays.asList(p1, p2), result1,"Ray crosses sphere");

        // TC03: Ray starts inside the sphere (1 point)
        Point p3 = new Point(1.11111111150, 0, 0.9938079899564274);
        List<Point> result2 = sphere.findIntersectionpoints(new Ray(new Point(1, 0, 0), new Vector(0,0,2)));

        assertEquals(1, result2.size(),"Wrong number of points");

        assertEquals(Arrays.asList(p3), result2,"Ray inside sphere");

        // TC04: Ray starts after the sphere (0 points)
        List<Point> result3 = sphere.findIntersectionpoints(new Ray(new Point(0, 0, -5), new Vector(0, 0,-10)));
        assertEquals(null, result3,"Ray after sphere");

        // =============== Boundary Values Tests ==================

        // ** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        Point p4 = new Point(1.5466783573534415, 0.8373426858827532, 0.0);
        List<Point> result4 = sphere.findIntersectionpoints(new Ray(new Point(0.5, 0, 0), new Vector(5,4, 0)));
        assertEquals(1, result4.size(),"Wrong number of points");
        assertEquals(Arrays.asList(p4), result4,"Ray starts at sphere and goes inside");

        // TC12: Ray starts at sphere and goes outside (0 points)
        List<Point> result5 = sphere.findIntersectionpoints(new Ray(new Point(0, 0, 0), new Vector(-6, 2, 0)));
        assertEquals(null, result5,"Ray starts at sphere and goes outside");

        // ** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        Point p5 = new Point(1, 1, 0);
        Point p6 = new Point(1, -1, 0);
        List<Point> result6 = sphere.findIntersectionpoints(new Ray(new Point(1, -3, 0), new Vector(0, 1, 0)));
        assertEquals(2, result6.size(),"Wrong number of points");
        if (result6.get(0).get_x() > result6.get(1).get_x())
            result6 = Arrays.asList(result6.get(1), result6.get(0));

        assertEquals(Arrays.asList(p5, p6), result6,"Ray starts before sphere");

        // TC14: Ray starts at sphere and goes inside (1 points)
        Point p7 = new Point(2, 0, 0);
        List<Point> result7 = sphere.findIntersectionpoints(new Ray(new Point(0, 0, 0), new Vector(9, 0, 0)));
        assertEquals( 1, result7.size(),"Wrong number of points");
        assertEquals(Arrays.asList(p7), result7,"Ray starts at sphere and goes inside");

        // TC15: Ray starts inside (1 points)
        Point p8 = new Point(1.5228843567351842, 0.8524036306126535, 0.0);
        List<Point> result8 = sphere.findIntersectionpoints(new Ray(new Point(0.5, 0, 0), new Vector(6, 5, 0)));
        assertEquals(1, result8.size(),"Wrong number of points");
        assertEquals(Arrays.asList(p8), result8,"Ray starts inside");

        // TC16: Ray starts at the center (1 points)
        Point p9 = new Point(1.1111111115, 0.7027283688955621, 0.7027283688955621);
        List<Point> result9 = sphere.findIntersectionpoints(new Ray(new Point(1, 0, 0), new Vector(0, 10, 10)));
        assertEquals(1, result9.size(),"Wrong number of points");
        assertEquals( Arrays.asList(p9), result9,"Ray starts at the center");

        // TC17: Ray starts at sphere and goes outside (0 points)
        List<Point> result10 = sphere.findIntersectionpoints(new Ray(new Point(2, 0, 0), new Vector(10, 0, 0)));
        assertEquals(null, result10,"Ray starts at sphere and goes outside");

        // TC18: Ray starts after sphere (0 points)
        List<Point> result11 = sphere.findIntersectionpoints(new Ray(new Point(8, 0, 0), new Vector(12, 0, 0)));
        assertEquals(null, result11,"Ray starts after sphere");

        // ** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        Point p12 = new Point(0, 0, 0);
        List<Point> result12 = sphere.findIntersectionpoints(new Ray(new Point(0, -4, 0), new Vector(0, 8, 0)));
        assertEquals( 1, result12.size(),"Wrong number of points");
        assertEquals( Arrays.asList(p12), result12,"Ray starts before the tangent point");

        // TC20: Ray starts at the tangent point(0 points)
        List<Point> result13 = sphere.findIntersectionpoints(new Ray(new Point(0, 0, 0), new Vector(0, 8, 0)));
        assertEquals(null, result13,"Ray starts at the tangent point");

        // TC21: Ray starts after the tangent point(0 points)
        List<Point> result14 = sphere.findIntersectionpoints(new Ray(new Point(0, 1, 0), new Vector(0, 8, 0)));
        assertEquals(null, result14,"Ray starts after the tangent point");

        // ** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's center line(0 points)
        List<Point> result15 = sphere.findIntersectionpoints(new Ray(new Point(-1, 0, 0), new Vector(0, 8, 0)));
        assertEquals(null, result15,"Ray's line is outside, ray is orthogonal to ray start to sphere's center line");

    }

}