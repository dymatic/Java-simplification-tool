package libsubject;

/**
 * This is a collection of formulas for dealing with numbers, simple operations,
 * and geometrical shapes. LibMath is not limited to just Math, and also covers
 * scientific operations that relate to numerical data.
 *
 * @author Norton
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
     * Finds the volume of the rectangle with the specified length, width, and
     * height. If you are trying to find the volume of a cube make all of the
     * number the same. Volume is a measure of how much space the object
     * occupies.
     *
     * @param length of the prism
     * @param width of the prism
     * @param height of the prism
     * @return volume of the prism.
     */
    public static double rectangularVolume(double length, double width, double height) {
        return (length * width * height);
    }

    /**
     * Returns the area of the triangle. To calculate the area multiply the base
     * by .5 and multiply it with the height (1/2bh)
     *
     * @param base length
     * @param height of the triangle
     * @return area
     */
    public static double triangularArea(double base, double height) {
        return (base * height * .5);
    }

    /**
     * Finds the volume that the pyramid takes up.
     *
     * @param Length of the base
     * @param Height of the pyramid
     * @return volume of the pyramid
     */
    public static double pyramidVolume(double base, double height) {
        return ((1 / 3) * base * height);
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

    /**
     * Finds the circumference (perimeter) of a circle using the radius. The
     * radius is the length from the side of the circle to the center. To find
     * it using diameter, divide diameter by 2.
     *
     * @param radius of the circle
     * @return the circumference of the circle
     */
    public static double circumference(double radius) {
        return ((radius * 2) * Math.PI);
    }

    /**
     * Returns the area of a circle when given the radius. The radius is the
     * length from the side of the circle to the center. To find it using
     * diameter, divide by 2.
     *
     * @param radius of the circle
     * @return the Area of the circle.
     */
    public static double circularArea(double radius) {
        return (LibMath.returnSquareOf(radius) * Math.PI);
    }

    /**
     * Finds the volume of the sphere with the specified radius. The volume is
     * how much space the object occupies.
     *
     * @param radius of the sphere
     * @return volume of the sphere.
     */
    public static double sphericalVolume(double radius) {
        return ((4 / 3) * Math.PI * (Math.pow(radius, 3)));
    }

    /**
     * Returns the area of the cylinder with the specified radius and height.
     *
     * @param radius of the cylinder's circles.
     * @param height of the cylinder
     * @return area of the cylinder
     */
    public static double cylindricalArea(double radius, double height) {
        return (2 * Math.PI * radius * height) + (2 * LibMath.circularArea(radius));
    }

    /**
     * Returns the volume that the cylinder takes up.
     *
     * @param radius of the cylinder's circles.
     * @param height of the cylinder
     * @return The volume of the cylinder.
     */
    public static double cylindricalVolume(double radius, double height) {
        return Math.PI * LibMath.returnSquareOf(radius) * height;
    }

    /**
     * Returns the area of a cone when give the radius of it's base, the height
     * of the cone, and the height of the cone's slant.
     *
     * @param The base's radius
     * @param The height of the cone
     * @param The height of the cone's slant
     * @return The area of the cone.
     */
    public static double coneArea(double radius, double height, double slant) {
        return (Math.PI * slant * radius) + LibMath.circularArea(radius);
    }

    public static double coneVolume(double radius, double height) {
        return (1 / 3) * LibMath.circularArea(radius) * height;
    }

    /**
     * Returns the density of the object. Density is equal to the mass times the
     * volume.
     *
     * @param mass of the object
     * @param volume of the object
     * @return density of the object
     */
    public static double densityOf(double mass, double volume) {
        return mass * volume;
    }
}
