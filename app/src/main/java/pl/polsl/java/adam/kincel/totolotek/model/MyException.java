package pl.polsl.java.adam.kincel.totolotek.model;

/**
 * Class which handle own exception, it extends class Exception.
 *
 * @author Adam Kincel
 * @version 6.0
 */
public class MyException extends Exception {

    /**
     * Stores number which cause exception.
     */
    private int exceptionNumber;

    /**
     * Contructor.
     */
    MyException() {
    }

    /**
     * This method shows what exception has occurred and what number causes this
     * exception.
     *
     * @param message inform what is the exception
     * @param exceptionNumber inform what number causes exception
     */
    MyException(String message, int exceptionNumber) {
        super(message);
        this.exceptionNumber = exceptionNumber;
    }

    /**
     * This method get exception number.
     *
     * @return exceptionNumber
     */
    public int getExceptionNumber() {
        return exceptionNumber;
    }

}

