package pl.polsl.java.adam.kincel.totolotek.model;

import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

/**
 * Totolotek class is a model in MVC architectural pattern.
 *
 * @author Adam Kincel
 * @version 6.0
 */
public class Totolotek implements Serializable {

    /**
     * Stores numbers which are drawn by 'lottery machine'.
     */
    //using a vector
    private Vector<Integer> drawnNumber = new Vector<>(6);

    /**
     * check if vector was used
     */
    private boolean usage = false;

    /**
     * Stores numbers which are chosen by user.
     */
    private int[] userArray = new int[6];

    /**
     * Numbers hit by user.
     */
    private int points;

    /**
     * Constructor.
     */
    public Totolotek() {
    }

    ;

    /**
     * Set number in userArray which user choose to drawing.
     *
     * @param i array's index
     * @param number number which was chosen by user
     */
    public void setNumber(int i, int number) {
        userArray[i] = number;
    }

    /**
     * Set array in argument to userArray.
     *
     * @param arr user array
     */
    public void setUserNumber(int[] arr) {
        userArray = arr;
    }

    /**
     * Set vector which stores drawn numbers
     *
     * @param vec number which is lottery drawing
     */
    public void setDrawnNumber(Vector<Integer> vec) {
        drawnNumber = vec;
    }

    /**
     * Get drawn number
     *
     * @param i position in a vector
     * @return number on the posision in parameter
     */
    public int getDrawnNumber(int i) {
        return drawnNumber.get(i);
    }

    /**
     * Get UserArray to use outside Totolotek class.
     *
     * @return userArray
     */
    public int[] getUserArray() {
        return userArray;
    }

    /**
     * Get one element in userArray on pos
     *
     * @param pos possition in array
     * @return element on specific possition
     */
    public int getUserArrayInPos(int pos) {
        return userArray[pos];
    }

    /**
     * Get drawingArray to use outside Totolotek class.
     *
     * @return drawingArray
     */
    public Vector<Integer> getDrawnArray() {
        return drawnNumber;
    }

    /**
     * Get points which user scored.
     *
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Initialization vector
     */
    private void initVec() {
        drawnNumber.add(0);
        drawnNumber.add(0);
        drawnNumber.add(0);
        drawnNumber.add(0);
        drawnNumber.add(0);
        drawnNumber.add(0);
        usage = true;
    }

    /**
     * Method which draw six random numbers between 1 and 49, it is necessary to
     * protection that the numbers do not repeat.
     *
     */
    public void drawing() {
        Random rand = new Random();
        int temp;
        boolean check;
        if (!usage) {
            initVec();

        }
        for (int i = 0; i < 6; i++) {

            do {
                check = true;
                temp = rand.nextInt(49) + 1;
                for (int ii = 0; ii < i; ii++) {
                    //check if drawing number is repeated in another number in array
                    // if YES drawing once again
                    if (temp == drawnNumber.get(ii)) {
                        check = false;
                        break;
                    }

                }
            } while (!check);

            drawnNumber.set(i, temp);
        }
        check();
    }

    /**
     * Method which check how many numbers user hit.
     */
    public void check() {
        points = 0;
        for (int i = 0; i < userArray.length; i++) {
            for (int j = 0; j < drawnNumber.size(); j++) {
                if (userArray[i] == drawnNumber.get(j)) {
                    points++;
                    break;
                }
            }
        }

    }

    /**
     * This method checks numbers chose by the user because numbers must be
     * between 1 and 49, if not, method throws exception.
     *
     * @param arg number which chosen by user
     * @throws MyException throw own exception
     */
    public void isGoodNumber(int arg) throws MyException {
        if (arg > 49 || arg < 1) {
            throw new MyException("Argument must be number between 1 and 49! ", arg);
        }
    }

    /**
     * This method checks if user's numbers are repeated, if yes method throws
     * exception.
     *
     * @param arr array where are all numbers which user choose
     * @throws MyException throw own exception
     */
    public void isRepeatable(int arr[]) throws MyException {
        //create object to use lambda expression
        LambdaExpression Obj = new LambdaExpression();
        //implementations of the lambda expressions: return true if parameters are equal
        BooleanComparing compare  = (a, b) -> (a == b);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Obj.operate(arr[i], arr[j], compare)) //using a lambda expressions
                {
                    throw new MyException("Arguments can not be repeated! ", arr[i]);
                }
            }
        }
    }



}