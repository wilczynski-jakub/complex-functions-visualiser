//ComplexNumber.java
/** A class with a pair of 2 numbers: real part, imaginary part.
 *@author Jakub Wilczyński
 *@since 13.11.2021
 */

package maths;

public class ComplexNumber {

    // Real part, imaginary part
    public double re,im;

    // The constructor
    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // This method will be used for generating the output plane,
    // to make it more dense (for better visibility)
    public ComplexNumber floor(String dim) {

        double floorRe = (int)this.re;
        double floorIm = (int)this.im;

        return switch (dim) {
            case "re" -> new ComplexNumber(floorRe, this.im);
            case "im" -> new ComplexNumber(this.re, floorIm);
            default -> this;
        };
    }

}//ComplexNumber
