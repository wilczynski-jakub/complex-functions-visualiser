//ComplexPlane.java
/** A class to store input complex plane as a BufferedImage, with the ability to apply a ComplexFunction to generate the output plane.
 *@author Jakub Wilczyński
 *@since 13.11.2021
 */

package gui;
import maths.*;

import java.awt.image.BufferedImage;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class ComplexPlane {

    // Attributes - for easier code below
    public final BufferedImage image;
    private final int width, height;

    // The constructor
    public ComplexPlane(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    // Converting cartesian X coordinates into pixels
    private int realPartPixel(ComplexNumber z, int imageWidth) {
        int x = (int)z.re + imageWidth/2;
        return min ( max(0,x) , imageWidth-1 );
    }

    // Converting cartesian Y coordinates into pixels
    private int imaginaryPartPixel(ComplexNumber z, int imageHeight) {
        int y = imageHeight/2 - (int)z.im;
        return min ( max(0,y) , imageHeight-1 );
    }

    // Make the pixel at "onto" the same color as the one at "from"
    private void copyRGB(ComplexNumber from, ComplexNumber onto,
                            BufferedImage coloring) {

        // Converting input coordinates into pixels
        int x0 = realPartPixel(from, this.width);
        int y0 = imaginaryPartPixel(from, this.height);
        int color = 0;

        // Try-catch just for debugging
        try {
            // Get the "onto"-pixel's color
            color = this.image.getRGB(x0, y0);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\nImage resolution: "+width+" x "+height);
            System.out.println("Could not get:\nx = "+x0+"\ny = "+y0);
        }

        // Converting output coordinates into pixels
        int x1 = realPartPixel(onto, coloring.getWidth());
        int y1 = imaginaryPartPixel(onto, coloring.getHeight());

        // Try-catch just for debugging
        try {
            // Paint the pixel
            coloring.setRGB(x1, y1, color);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\nImage resolution: "+width+" x "+height);
            System.out.println("Could not set:\nx = "+x1+"\ny = "+y1);
        }

    }

    // Generate the output image, applying a given function to the input image
    public BufferedImage remap(ComplexFunction function) {

        BufferedImage result = new BufferedImage(this.width*10, this.height*10,
                                              BufferedImage.TYPE_INT_ARGB);
        ComplexNumber input;
        // Multiple output numbers - to make the image more condensed
        ComplexNumber[] outputs = new ComplexNumber[3];

        for (double y = -this.height; y < this.height; y += 0.15)
            for (double x = -this.width; x < this.width; x += 0.15) {

                input = new ComplexNumber(x, y);
                outputs[0] = function.calculate(input);
                outputs[1] = function.calculate(input.floor("re"));
                outputs[2] = function.calculate(input.floor("im"));

                for (ComplexNumber output : outputs)
                    this.copyRGB(input, output, result);

            }//for(y)

        return result;
    }//remap

}//ComplexPlane
