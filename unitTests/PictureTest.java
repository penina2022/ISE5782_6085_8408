import geometries.Geometry;
import geometries.Sphere;
import lighting.AmbientLight;
import primitives.Color;
import primitives.Double3;
import primitives.Material;
import primitives.Point;
import scene.Scene;
import java.awt.color.*;

import static java.awt.Color.cyan;
import static java.awt.Color.pink;

public class PictureTest {
    private Scene scene = new Scene("Test scene")
            .setAmbientLight(new AmbientLight((new Color(pink)), new Double3(0.15)))
            .setBackground(new Color(cyan).reduce(1.1));

    //---------------------------------4 spheres----------------------------------------------
    private Geometry sphere1 =new Sphere(new Point(120,115,-10),70d)
            .setEmission(new Color(cyan).reduce(1.5))
            .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300));

    private Geometry sphere2 =new Sphere(new Point(120,115,-10),70d)
            .setEmission(new Color(cyan).reduce(1.5))
            .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300));


}