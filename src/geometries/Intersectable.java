package geometries;
import primitives.*;
import java.util.List;

/**
 * common interface for all graphic objects that intersect with a ray {@link Ray}
 */
public interface Intersectable {
    /**
     * find all intersection points from the array
     * @param ray ray pointing towards the graphic object
     * @return immutable list of intersection points {@link Point}
     */
    List<Point> findIntersectionpoints(Ray ray);
}

