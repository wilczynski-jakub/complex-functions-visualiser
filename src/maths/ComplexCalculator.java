//ComplexCalculator.java
/** A class to store the complex functions as static members, and to implement the needed complex arithmetics.
 *@author Jakub Wilczyński
 *@since 13.11.2021
 */

package maths;

import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.sinh;
import static java.lang.Math.cosh;
import java.util.Map;
import java.util.LinkedHashMap;

public class ComplexCalculator {

    // ComplexNumber arithmetics - multiplying by a scalar
    private static ComplexNumber scale(ComplexNumber z, double a) {
        return new ComplexNumber(z.re * a, z.im * a);
    }

    // Functions stored in a map of <name,expression> entries
    public static Map<String, ComplexFunction> complexFunctions = new LinkedHashMap<>();

    // The constructor
    public ComplexCalculator() {

        complexFunctions.put("10*z", (z) -> scale(z,10));

        complexFunctions.put("z^2",
                (z) -> new ComplexNumber(z.re*z.re - z.im*z.im, 2*z.re*z.im));

        complexFunctions.put("(z^3)/10", // Dividing by 10 to make it look better
                (z) -> scale(new ComplexNumber(pow(z.re,3) - 3*z.re*pow(z.im,2),
                        3*z.re*z.re*z.im - pow(z.im,3)),0.1));

        complexFunctions.put("sin(z)",
                (z) -> new ComplexNumber(sin(z.re)*cosh(z.im),cos(z.re)*sinh(z.im)));

        complexFunctions.put("cos(z)",
                (z) -> new ComplexNumber(cos(z.re)*cosh(z.im), sin(z.re)*sinh(z.im)));

        complexFunctions.put("200/z", // Multiplying by 200 to make it look better
                (z) -> scale(new ComplexNumber(z.re, z.im),200/(z.re*z.re + z.im*z.im)));
    }

}//ComplexFunctionCalculator
