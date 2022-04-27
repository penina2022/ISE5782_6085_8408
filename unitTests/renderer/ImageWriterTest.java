package renderer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import primitives.Color;
import java.awt.*;

public class ImageWriterTest {
    /**
     * Test method for ImageWriter class
     */
    @Test
    public void test() {
        int nX=800;
        int nY =500;

        Color blackColor = new Color(java.awt.Color.BLACK);
        Color blueColor = new Color(java.awt.Color.BLUE);

        ImageWriter imageWriter = new ImageWriter("testblue",800,500);

        for (int i = 0; i < nX; i++) {
            for (int j = 0; j < nY; j++) {
                // 800/16 = 50// 500/10 = 50
                if (i % 50 == 0 || j % 50 == 0) {
                    imageWriter.writePixel(i, j, blackColor);
                }

                else {
                    imageWriter.writePixel(i, j,blueColor);
                }
            }
        }
        imageWriter.writeToImage();
    }
}
