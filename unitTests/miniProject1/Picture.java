package miniProject1;

import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import lighting.AmbientLight;
import lighting.PointLight;
import lighting.SpotLight;
import org.junit.jupiter.api.Test;
import primitives.*;
import renderer.Camera;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import scene.Scene;

import static java.awt.Color.*;
import static java.awt.Color.YELLOW;

public class Picture {
    Scene scene = new Scene("New Picture");
    @Test
    public void BonusImage() {
        Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0))
                .setVPSize(200, 200).setVPDistance(1000);

        scene.setAmbientLight(new AmbientLight(new Color(BLACK), new Double3(0.3)));

        scene.geometries.add(
                new Plane(new Point(-150, -150, -100), new Point(-100, 100, -100), new Point(75, 75, -100))
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(20)).setEmission(new Color(blue)),

                /** new Triangle(new Point(-100, -100, 42), new Point(-90, -60, 42), new Point(-80, -100, 42))
                 .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.3)).setEmission(new Color(GREEN)), //
                 new Triangle(new Point(-80, -100, 42), new Point(-70, -60, 42), new Point(-60, -100, 42)) //
                 .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),//
                 new Triangle(new Point(-60, -100, 42), new Point(-45, -60, 42), new Point(-30, -100, 42)) //
                 .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.3)).setEmission(new Color(GREEN)),
                 new Triangle(new Point(-30, -100, 42), new Point(-18, -60, 42), new Point(-6, -100, 42)) //
                 .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                 new Triangle(new Point(-6, -100, 42), new Point(10, -60, 42), new Point(26, -100, 42)) //
                 .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                 new Triangle(new Point(26, -100, 42), new Point(36, -60, 42), new Point(46, -100, 42)) //
                 .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.2)).setEmission(new Color(GREEN)),
                 new Triangle(new Point(46, -100, 42), new Point(60, -60, 42), new Point(74, -100, 42)) //
                 .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.15)).setEmission(new Color(GREEN)),
                 new Triangle(new Point(74, -100, 42), new Point(87, -60, 42), new Point(100, -100, 42)) //
                 .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.2)).setEmission(new Color(GREEN)),**/
                //the top head sphere of the  snow man
                new Sphere(new Point(30, 35, 5), 20) //
                        .setEmission(new Color(lightGray)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.0001)),
                //the middle part of the snow man
                new Sphere(new Point(30, -10, 5), 30) //
                        .setEmission(new Color(lightGray)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //the bottom part of the snow man
                new Sphere(new Point(30, -70, 5), 40) //
                        .setEmission(new Color(lightGray)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),

                /**new Sphere(new Point(-20, 35, 5), 10) //
                 .setEmission(new Color(BLUE)) //
                 .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                 new Sphere(new Point(20, 35, 5), 10) //
                 .setEmission(new Color(BLUE)) //
                 .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                 new Sphere(new Point(0, 2, 60), 8) //
                 .setEmission(new Color(BLACK)) //
                 .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),
                 new Sphere(new Point(-10, 18, 60), 6) //
                 .setEmission(new Color(WHITE)) //
                 .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),
                 new Sphere(new Point(28, -15, 74), 4) //
                 .setEmission(new Color(WHITE)) //
                 .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),**/
                //the snow mans' eyes
                new Sphere(new Point(35, 36, 85), 4) //
                        .setEmission(new Color(0,100,0)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),
                new Sphere(new Point(21, 36, 85), 4) //
                        .setEmission(new Color(0,100,0)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),
                //the snow mans nose
                new Triangle(new Point(25.5, 30, 70), new Point(28.5, 20, 70), new Point(31.5, 30, 70))
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.3)).setEmission(new Color(255,69,0)),
                //the snow mans buttons
                new Sphere(new Point(28, -22, 78), 4) //
                        .setEmission(new Color(BLACK)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),
                new Sphere(new Point(28, -7, 78), 4) //
                        .setEmission(new Color(BLACK)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),
                new Sphere(new Point(28, 8, 78), 4) //
                        .setEmission(new Color(BLACK)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),

                new Triangle(new Point(20, 52, 42), new Point(29, 80, 42), new Point(38, 52, 42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKT(0.25)).setEmission(new Color(RED)),



                /**new Sphere(new Point(6, -15, 60), 6) //
                 .setEmission(new Color(RED)) //
                 .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),
                 new Sphere(new Point(-6, -15, 60), 6) //
                 .setEmission(new Color(RED)) //
                 .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),**/
                new Sphere(new Point(-90, 80, 60), 40) //
                        .setEmission(new Color(YELLOW)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.65))
                /**new Sphere(new Point(30, -25, 5), 10) //
                 .setEmission(new Color(BLUE)) //
                 .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                 new Sphere(new Point(-30, -25, 5), 10) //
                 .setEmission(new Color(BLUE)) //
                 .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001))**/
        );


        scene.lights.add(new SpotLight(new Color(700, 400, 400), new Point(-90, 80, 5), new Vector(0, 10, 5)) //
                .setKl(0.0001).setKq(0.0005));

        scene.lights.add(new PointLight(new Color(YELLOW), new Point(150, 90, 5)) //
                .setKl(0.0001).setKq(0.00005));
        /*scene.lights.add(new PointLight(new Color(700, 400, 400), new Point(0,-30,5)) //
         .setkL(0.0001).setkQ(0.00005));*/
        scene.lights.add(new PointLight(new Color(YELLOW), new Point(-90, 80, 5)) //
                .setKl(0.000000000001).setKq(0.0000000000005));


        ImageWriter imageWriter = new ImageWriter("Bonus image", 600, 600);

        camera.setImageWriter(imageWriter) //
                .setRayTracer(new RayTracerBasic(scene)).renderImage(); //
        camera.writeToImage();; //
    }
}
