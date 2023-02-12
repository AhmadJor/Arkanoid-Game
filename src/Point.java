//Ahmad Jorban 211437223
import java.util.Random;

/**
 * The type Point.
 *
 * @author Ahmad Jorban this class is to craete a point.
 */
public class Point {
    private final double x;
    private final double y;

    /**
     * constructor.
     *
     * @param x x of the point
     * @param y y of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * this method measures the distance between two Points.
     * using the distance formula.
     *
     * @param other is the other point
     * @return the distance
     */
    public double distance(Point other) {
        double squareX = (this.x - other.getX()) * (this.x - other.getX());
        double squareY = (this.y - other.getY()) * (this.y - other.getY());
        return Math.sqrt(squareX + squareY);
    }

    /**
     * this method checks if two points are equal.
     *
     * @param other is the other point to be checked
     * @return true or false
     */
    public boolean equals(Point other) {
        return other != null && this.getX() == other.getX() && this.getY() == other.getY();
    }

    /**
     * this method is to get a random point in a range.
     *
     * @param range     is the bound range
     * @param specifier is to stay in bound
     * @return new Point(x, y);
     */
    public static Point randomPoint(int range, int specifier) {
        Random rand = new Random();
        int x = rand.nextInt(range - specifier) + specifier;
        int y = rand.nextInt(range - specifier) + specifier;
        return new Point(x, y);
    }

    /**
     * this method is to get the x from the class.
     *
     * @return this.x x
     */
    public double getX() {
        return this.x;
    }

    /**
     * this method is to get the y from the class.
     *
     * @return this.y y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Check pound boolean.
     *
     * @param w1 first width
     * @param w2 second width
     * @param h1 first height
     * @param h2 second height
     * @return true or false
     */
    public boolean checkPound(int w1, int w2, int h1, int h2) {
        return this.getX() < w1 && this.getX() > w2 && this.getY() < h1 && this.getY() > h2;
    }
}