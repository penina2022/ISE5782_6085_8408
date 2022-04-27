package geometries;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Disabled
    @Test
    void getNormal() {
        Cylinder c = new Cylinder(new Ray(new Point(0.0, 0.0, 1.0), new Vector(0.0, 0.0, 2.0)), 4.0, 8.0);

        // ============ Equivalence Partitions Tests ==============
        //there are 3 parts- points on the side of the cylinder and on its bases

        //part one: on the side of the cylinder
        assertEquals((new Vector(0.8, 0.0, 0.6)), c.getNormal(new Point(4.0, 0.0, 0.0)));
        assertEquals((new Vector(0.19611613513818404, -0.7844645405527362, -0.5883484054145521)), c.getNormal(new Point(1.0, -4.0, 2.0)));

        //part two: base of the cylinder
        assertEquals(c.getNormal((new Vector(0.08192319205190406, 0.1638463841038081, 0.9830783046228486))), new Point(1.0, 2.0, -3.0));//bottom base

        //part three: bottom base of the cylinder
        assertEquals((new Vector(0.0, 0.0, 2.0)), c.getNormal(new Point(0.0, 3.0, 5.0)));//top base

        // =============== Boundary Values Tests ==================
        // the boundary values are at the intersections of the bases and the side of the cylinder

        assertEquals((new Vector(0.0, 0.0, 2.0)), c.getNormal(new Point(4.0, 0.0, 5.0)));
        assertEquals((new Vector(0.0, -0.31622776601683794, 0.9486832980505138)), c.getNormal(new Point(0.0, -4.0, -3.0)));
    }
}