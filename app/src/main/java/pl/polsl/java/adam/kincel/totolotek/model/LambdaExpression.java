package pl.polsl.java.adam.kincel.totolotek.model;

/**
 * Specification of the lambda expression with two parameters.
 *
 * @author Adam Kincel
 * @version 6.0
 */
interface BooleanComparing {

    boolean comparing(int a, int b);
}

/**
 * Lambda expression class
 *
 * @author Adam Kincel
 * @version 6.0
 */
public class LambdaExpression {

    /**
     * Lambda expression as a parameter
     *
     * @param a first parameter to compare
     * @param b second parameter to compare
     * @param op boolean operator
     * @return true if two parameters are equal, false if not
     */
    Boolean operate(int a, int b, BooleanComparing op) {
        return op.comparing(a, b);
    }
}
