import primitives.*;
import static java.lang.System.out;
import static primitives.Util.*;

/**
 * Test program for the 1st stage
 *
 * @author Dan Zilberstein
 */
public final class Main {

	/**
	 * Main program to tests initial functionality of the 1st stage
	 * 
	 * @param args irrelevant here
	 */
	public static void main(String[] args) {

		try { // test zero vector
			new Vector(0, 0, 0);
			out.println("ERROR: zero vector does not throw an exception");
		} catch (Exception e) {
		}

		Vector vector1 = new Vector(1, 2, 3);
		Vector vector2 = new Vector(-2, -4, -6);
		Vector vector3 = new Vector(0, 3, -2);

		// test length..
		if (!isZero(vector1.lengthSquared() - 14))
			out.println("ERROR: lengthSquared() wrong value");
		if (!isZero(new Vector(0, 3, 4).length() - 5))
			out.println("ERROR: length() wrong value");

		// test Dot-Product
		if (!isZero(vector1.dotProduct(vector3)))
			out.println("ERROR: dotProduct() for orthogonal vectors is not zero");
		if (!isZero(vector1.dotProduct(vector2) + 28))
			out.println("ERROR: dotProduct() wrong value");

		// test Cross-Product
		try { // test zero vector
			vector1.crossProduct(vector2);
			out.println("ERROR: crossProduct() for parallel vectors does not throw an exception");
		} catch (Exception e) {
		}
		Vector vector = vector1.crossProduct(vector3);
		if (!isZero(vector.length() - vector1.length() * vector3.length()))
			out.println("ERROR: crossProduct() wrong result length");
		if (!isZero(vector.dotProduct(vector1)) || !isZero(vector.dotProduct(vector3)))
			out.println("ERROR: crossProduct() result is not orthogonal to its operands");

		// test vector normalization vs vector length and cross-product
		Vector v = new Vector(1, 2, 3);
		Vector u = v.normalize();
		if (!isZero(u.length() - 1))
			out.println("ERROR: the normalized vector is not a unit vector");
		try { // test that the vectors are co-lined
			v.crossProduct(u);
			out.println("ERROR: the normalized vector is not parallel to the original one");
		} catch (Exception e) {
		}
		if (v.dotProduct(u) < 0)
			out.println("ERROR: the normalized vector is opposite to the original one");

		// Test operations with points and vectors
		Point point = new Point(1, 2, 3);
		if (!(point.add(new Vector(-1, -2, -3)).equals(new Point(0, 0, 0))))
			out.println("ERROR: Point + Vector does not work correctly");
		if (!new Vector(1, 1, 1).equals(new Point(2, 3, 4).subtract(point)))
			out.println("ERROR: Point - Point does not work correctly");

		out.println("If there were no any other outputs - all tests succeeded!");
	}
}
