package primitives;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

class VectorTest {
    Vector vector1 = new Vector(1, 2, 3);
    Vector vector2 = new Vector(-2, -4, -6);
    Vector vector3 = new Vector(0, 3, -2);
    @Test
    /***
     * methhod for testing {@link Vector#lengthSquared()}
     */
    void testLengthSquared() {
        // test length..
        if (!isZero(vector1.lengthSquared() - 14))
            out.println("ERROR: lengthSquared() wrong value");
    }

    @Test
    void testLength() {
    }

    @Test
    void testDotProduct() {
    }

    @Test
    void testCrossProduct() {
    }

    @Test
    void testNormalize() {
    }

    @Test
    void testScale() {
    }

    /***
     * test constractor{@link Vector#}
     */
    @Test
    void testConstractorNotZero() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Vector(0, 0, 0.000000000000000034);
                },
                "Vector(0,0,0) shold have thrown Exception");
    }
}