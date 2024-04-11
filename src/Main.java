//Main.java
/** The main class to run the Complex Function Visualiser GUI.
 *@author Jakub Wilczyński
 *@since 13.11.2021
 */

import gui.*;
import maths.ComplexCalculator;

import java.io.File;
import static javax.imageio.ImageIO.read;

public class Main {

    // The main method
    public static void main(String[] args) {

        // Reading the file
        File inputFile = new File("src/Input.png");

        // Try-catch in case of a non-existing file
        try {
            // BufferedImage object without additional import
            var image = read(inputFile);

            // 2 objects for back-end operations
            ComplexPlane plane = new ComplexPlane(image);
            ComplexCalculator calculator = new ComplexCalculator();

            // The main window
            MainFrame mainFrame = new MainFrame("Complex Functions Visualiser",
                                                plane, calculator.complexFunctions);
        }//try
        catch (java.io.IOException exception) {
            System.out.println("Image error:\n" + exception);
        }
    }//main

}//Main
