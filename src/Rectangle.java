
import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class.
 * this class creates the point that is needed to create the ball.
 */
public class Rectangle {
    private Point upperLeft;
    private Point upperRight;
    private Point downLeft;
    private Point downRight;
    private double width;
    private double height;
    private static final int NUM_RECT = 4;

    /**
     * constructor method.
     * it creates the velocity object.
     * @param upperLeft the upper point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.width = width;
        this.height = height;
        this.upperLeft = upperLeft;
        this.upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        this.downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        this.downRight = new Point(this.upperLeft.getX() + this.width, upperLeft.getY() + this.height);
    }

    /**
     * setUpperLeft method.
     * change the x value in the upper left point of the rectangle.
     * @param changeDx the new X
     */
    public void setUpperLeft(int changeDx) {
        this.upperLeft = new Point(upperLeft.getX() + changeDx, upperLeft.getY());
    }

    /**
     * setOtherSides method.
     * setting the other sides of the rectangle after changing the upper left.
     */
    public void setOtherSides() {
        this.upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        this.downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        this.downRight = new Point(this.upperLeft.getX() + this.width, upperLeft.getY() + this.height);
    }
    /**
     * getUpperLeft method.
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * getUpperRight method.
     * @return the upper right point of the rectangle.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * getDownLeft method.
     * @return the down left point of the rectangle.
     */
    public Point getDownLeft() {
        return this.downLeft;
    }

    /**
     * getDownRight method.
     * @return the down right point of the rectangle.
     */
    public Point getDownRight() {
        return this.downRight;
    }

    /**
     * getWidth method.
     * @return width value of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getHeight method.
     * @return height value of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the line from points upperLeft(x,y) to point p3(x+width,y)
     */
    public Line getFirstLine() {
        return new Line(this.upperLeft, this.upperRight);
    }

    /**
     * @return the line from points upperLeft(x,y) to point p2(x,y+height)
     */
    public Line getSecondLine() {
        return new Line(this.upperLeft, this.downLeft);
    }

    /**
     * @return the line from points p2(x,y+height) to point p4(x+width,y+height)
     */
    public Line getThirdLine() {
        return new Line(this.downLeft, this.downRight);
    }

    /**
     * @return the line from points p3(x+width,y) to point p4(x+width,y+height)
     */
    public Line getForthLine() {
        return new Line(this.downRight, this.upperRight);
    }

    /**
     * intersectionPoints method.
     * @param line the line with it checks if intersecting.
     * @return list of intersecting points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        /* initializing array list of points */
        List<Point> listOfPoints = new ArrayList<Point>();
        /* array list of all the lines of the rectangle */
        Line[] arrLines = {getFirstLine(), getSecondLine(), getThirdLine(), getForthLine()};
        for (int i = 0; i < NUM_RECT; i++) {

            /* check if there is intersection */
            if (line.isIntersecting(arrLines[i])) {
                int x = (int) Math.round(line.intersectionWith(arrLines[i]).getX());
                int y = (int) Math.round(line.intersectionWith(arrLines[i]).getY());
                listOfPoints.add(new Point(x, y));
            }
        }
        /* returning the array list of the points */
        return listOfPoints;
    }
}