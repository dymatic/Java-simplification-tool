
/**
 * This is a collection of formulas that Java's math class left out.
 *
 * @author nate
 */
public class mathematicsLibrary {
    /**
     * Returns the square of the number in the parameter, but does not change
     * it's value.
     *
     * @param toSquare
     */
    public double returnSquareOf(double number) {
        return number * number;
    }

    /**
     * Returns nothing but turns the parameter into a square of itself.
     *
     * @param number
     */
    public void makeSquare(double number) {
        number *= number;
    }

    /**
     * Returns the mean for the list of data.
     *
     * @param list
     * @return mean
     */
    public double getMean(double[] list) {
        double collector = 0.0;
        for (int index = 0; index < list.length; index++) {
            collector += list[index];
        }
        return collector /= list.length;

    }

    /**
     * Returns the standard deviation from a set of data. Standard deviation is
     * commonly used in mathematics and the sciences to check the validity of
     * the set of information. Conventions state that any point of data two
     * standard deviations away from the mean should be rejected, and a new
     * standard deviation calculated.
     * @param list
     * @return stdDev
     */
    public double calculateStandardDeviation(double[] list) {
        if (list.length == 1) {
            return list[0];
        }

        double[] localList = new double[list.length];
        double collector = 0;

        for (int index = 0; index < list.length; index++) {
            localList[index] = list[index];
            localList[index] -= this.getMean(localList);
        }

        for (int index = 0; index < localList.length; index++) {
            collector += this.returnSquareOf(localList[index]);
        }

        return Math.sqrt(collector /= (localList.length - 1));

    }

    /**
     * Returns the area of a rectangle.
     *
     * @param length
     * @param width
     * @return Area
     */
    public double rectangularArea(double length, double width) {
        return length * width;
    }

    /**
     * Returns the area of the triangle. To calculate the area multiply the base
     * by .5 and multiply it with the height (1/2bh)
     *
     * @param base
     * @param height
     * @return area
     */
    public double triangularWidth(double base, double height) {
        return base * height * .5;
    }

    /**
     * Returns the missing side of a right triangle. The two sides to use with
     * this method are the hypotenuse and the side of the triangle that is not
     * missing.
     *
     * @return missingSide
     */
    public double pyThagSide(double hypotenuse, double side1) {
        double side12 = hypotenuse;
        double side2 = side1;

       this.makeSquare(side12);
        this.makeSquare(side2);

        side12 -= side1;
        return Math.sqrt(side12);
    }

    /**
     * Finds the length of the hypotenuse when given the length of side1 and
     * side2.
     *
     * @param side1
     * @param side2
     * @return hypotenuse
     */
    public double pyThagHypotenuse(double side1, double side2) {
        double hypotenuse = side1;
        double side12 = side2;

        this.makeSquare(hypotenuse);
        this.makeSquare(side12);

        return Math.sqrt(side12 + side2);
    }
}
