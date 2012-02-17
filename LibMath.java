package libsubject;

/**
 * This is a collection of formulas for dealing with numbers and simple
 * operations.
 *
 * @author nate
 */
public abstract class LibMath {

    /**
     * Takes the sum of the data in the array.
     *
     * @param the array containing the data
     * @return the sum of all the data.
     */
    public static double addAll(double[] data) {
        double collector = 0.0;
        for (int index = 0; index < data.length; index++) {
            collector += data[index];
        }
        return collector;
    }

    /**
     * Returns the square of the number in the parameter, but does not change
     * it's value.
     *
     * @param the number to square.
     * @return the squared number.
     */
    public static double returnSquareOf(double number) {
        return number * number;
    }

    /**
     * Returns nothing but turns the parameter into a square of itself.
     *
     * @param the number to quare.
     */
    public static void makeSquare(double number) {
        number *= number;
    }

    /**
     * Returns the mean for the list of data.
     *
     * @param Array containing the data.
     * @return mean of the data.
     */
    public static double getMean(double[] list) {
        return (LibMath.addAll(list) / list.length);

    }

    /**
     * Returns the standard deviation from a set of data. Standard deviation is
     * commonly used in mathematics and the sciences to check the validity of
     * the set of information. Conventions state that any point of data two
     * standard deviations away from the mean should be rejected, and a new
     * standard deviation calculated.
     *
     * @param list of data
     * @return standard deviation.
     */
    public static double calculateStandardDeviation(double[] list) {
        if (list.length == 1) {
            return list[0];
        }

        double[] localList = new double[list.length];
        double collector = 0;

        for (int index = 0; index < list.length; index++) {
            localList[index] = list[index];
            localList[index] -= LibMath.getMean(localList);
        }

        for (int index = 0; index < localList.length; index++) {
            collector += LibMath.returnSquareOf(localList[index]);
        }

        return Math.sqrt(collector /= (localList.length - 1));

    }

    /**
     * Returns the area of the specified rectangle. This can also be used with
     * squares, just supply the same side twice.
     *
     * @param length
     * @param width
     * @return Area
     */
    public static double rectangularArea(double length, double width) {
        return (length * width);
    }

    /**
     * Returns the area of the triangle. To calculate the area multiply the base
     * by .5 and multiply it with the height (1/2bh)
     *
     * @param base length
     * @param height of the triangle
     * @return area
     */
    public static double triangularWidth(double base, double height) {
        return (base * height * .5);
    }

    /**
     * Returns the missing side of a right triangle. The two sides to use with
     * this method are the hypotenuse and the side of the triangle that is not
     * missing.
     *
     * @param hypotenuse side
     * @param the non-missing leg.
     * @return missingSide
     */
    public static double pyThagSide(double hypotenuse, double side1) {
        return Math.sqrt(LibMath.returnSquareOf(hypotenuse) - LibMath.returnSquareOf(side1));
    }

    /**
     * Finds the length of the hypotenuse when given the length of both of the
     * legs.
     *
     * @param leg A
     * @param leg B
     * @return hypotenuse
     */
    public static double pyThagHypotenuse(double side1, double side2) {
        return Math.sqrt(LibMath.returnSquareOf(side1) + LibMath.returnSquareOf(side2));
    }
}
