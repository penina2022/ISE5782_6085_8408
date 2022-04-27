//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
// Mini Project in Software Engineering
// Shira Pinski 214103723 pinskishira@gmail.com
// Ayelet Dadon 324863216 ayeletnomi6@gmail.com
import primitives.Vector;

public final class Main {
    public Main() {
    }

    public static void main(String[] args)
    {
        try {
            new Vector(0.0D, 0.0D, 0.0D);
            System.out.println("ERROR: zero vector does not throw an exception");
        } catch (Exception var10) {
        }

        Vector v1 = new Vector(1.0D, 2.0D, 3.0D);
        Vector v2 = new Vector(-2.0D, -4.0D, -6.0D);
        Vector v3 = new Vector(0.0D, 3.0D, -2.0D);
        System.out.println("If there were no any other outputs - all tests succeeded!");
    }
}

