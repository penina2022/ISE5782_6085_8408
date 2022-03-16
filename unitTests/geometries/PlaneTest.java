package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    Point p1=new Point(0,0,0);
    Point p2=new Point(0,0,1);
    Point p3=new Point(0,1,0);
    Plane pl=new Plane(p1,p2,p3);
    @Test
    void testGetNormal() {
        // problem is that vector doesn't have an equal function so can't use the operator ==.
        // assertEquals(new Vector(-1,0, 0).normalize(), pl.getNormal());
        Vector expected = new Vector(-1,0,0).normalize();
        Vector expected2 = expected.scale(-1);
        assertTrue(pl.getNormal().equals(expected) || pl.getNormal().equals(expected2));

    }

    /**
     * Test method for {@link geometries.Plane#findIntersectionpoints(Ray)} (primitives.Ray)}.
     */
    @Test
    public void testFindIntersectionsEP()
    {
        Plane plane = new Plane(new Point(1, 1, 0), new Vector(0, 0, 1));

        // TC01:: Ray's line is outside the plane (0 points)
        assertEquals(null, plane.findIntersectionpoints(new Ray(new Point(0, 0, 7), new Vector(3, 0, 0))));
        // TC02: Ray intersects the plane (1 points)

        List<Point> result1 = plane.findIntersectionpoints(new Ray(new Point(0,0,0), new Vector(0,0,1)));
        assertEquals(1, result1.size());



        // =============== Boundary Values Tests ==================
        // ** Group: Ray is parallel to the plane
        // TC03: The ray included in the plane (0 points)
        assertEquals(null, plane.findIntersectionpoints(new Ray(new Point(0, 0, 0), new Vector(3, 7, 0))));

        // TC04: The ray not included in the plane (0 points)
        assertEquals(null, plane.findIntersectionpoints(new Ray(new Point(0, 0, 7), new Vector(3, 0, 0))));

        // ** Group: Ray is orthogonal to the plane
        // TC05: The ray before the plane (1 points)

        List<Point> l = plane.findIntersectionpoints(new Ray(new Point(0,0,3), new Vector(0, 0, -4)));
        assertEquals(1, l.size());


        // TC06: The ray in the plane (0 points)
        assertEquals( null, plane.findIntersectionpoints(new Ray(new Point(9, 8, 0), new Vector(7, 5, 0))));

        // TC07: The ray after the plane (0 points)
        assertEquals(null, plane.findIntersectionpoints(new Ray(new Point(0,0,-3), new Vector(0, 0, -10))));

        // ** Group: Ray is neither orthogonal nor parallel to the plane
        // TC08: Ray begins at the plane(0 points)
        assertEquals(null, plane.findIntersectionpoints(new Ray(new Point(1, 4, 5), new Vector(100, 100, 100))));

        // TC09: Ray begins in the same point which appears as reference point in the plane(0 points)
        assertEquals(null, plane.findIntersectionpoints(new Ray(new Point(1, 0, 0), new Vector(-6, 2, 0))));
    }
}