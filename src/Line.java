//Ahmad Jorban 211437223

/**
 * The type Line.
 *
 * @author Ahmad Jorban
 */
public class Line {
    // fields
    private final Point start;
    private final Point end;
    // constructors

    /**
     * Instantiates a new Line.
     *
     * @param start starting point
     * @param end   ending point draw a line from 2 points starting from the smallest x coordinates
     */
    public Line(Point start, Point end) {

        this.start = start;
        this.end = end;

    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 point 1 x
     * @param y1 point 1 y
     * @param x2 point 2 x
     * @param y2 point 2 y builds 2 points from 4 double and then build a line from 2 points
     */
    public Line(double x1, double y1, double x2, double y2) {

        start = new Point(x1, y1);
        end = new Point(x2, y2);

    }
    // Return the length of the line

    /**
     * Length double.
     *
     * @return the length of the line
     */
    public double length() {
        return start.distance(end);
    }
    // Returns the middle point of the line

    /**
     * Middle point.
     *
     * @return middle points in the line
     */
    public Point middle() {
        return new Point((this.end.getX() + this.start.getX()) / 2, (Math.max(this.start.getY(), this.end.getY())
                + Math.min(this.start.getY(), this.end.getY())) / 2);
    }
    // Returns the start point of the line

    /**
     * Start point.
     *
     * @return this line start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * End point.
     *
     * @return this line end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * this method gets the difference between x in the end points of a line.
     *
     * @return this.end().getX() - this.start().getX()
     */
    public double getDifferenceOfX() {
        return this.end().getX() - this.start().getX();
    }

    /**
     * this method gets the difference between y in the end points of a line.
     *
     * @return this.end().getY() - this.start().getY()
     */
    public double getDifferenceOfY() {
        return this.end().getY() - this.start().getY();
    }

    /**
     * this method is get the intersection point of two lines.
     *
     * @param other is the second line
     * @return new Point(this.start().getX() + t * dx1, this.start().getY() + t * dy1)
     */
    public Point intersectionWith(Line other) {
        double dx1 = this.getDifferenceOfX();
        double dy1 = this.getDifferenceOfY();
        double dx2 = other.getDifferenceOfX();
        double dy2 = other.getDifferenceOfY();
        double t = (dx2 * (other.diffOfY(this)) + dy2 * (this.diffOfX(other))) / (dx1 * dy2 - dx2 * dy1);
        if (!this.isIntersecting(other)) {
            return null;
        }
        return new Point(this.start().getX() + t * dx1, this.start().getY() + t * dy1);

    }

    /**
     * method to get the difference of the y's start point in two different line.
     *
     * @param line is the other line
     * @return line.start().getY() - this.start().getY()
     */
    public double diffOfY(Line line) {
        return line.start().getY() - this.start().getY();
    }

    /**
     * method to get the difference of the x's start point in two different line.
     *
     * @param line is the other line
     * @return line.start().getX() - this.start().getX()
     */
    public double diffOfX(Line line) {
        return line.start().getX() - this.start().getX();
    }

    /**
     * Is intersecting boolean.
     *
     * @param line is the line we check intersection with
     * @return true or false
     */
    public boolean isIntersecting(Line line) {
        double dx1 = this.getDifferenceOfX();
        double dy1 = this.getDifferenceOfY();
        double dx2 = line.getDifferenceOfX();
        double dy2 = line.getDifferenceOfY();
        if ((int) (dx2 * dy1 - dx1 * dy2) == 0) {
            return false;
        }
        double s = (dx1 * (this.diffOfY(line)) + dy1 * (line.diffOfX(this))) / (dx2 * dy1 - dx1 * dy2);
        double t = (dx2 * (line.diffOfY(this)) + dy2 * (this.diffOfX(line))) / (dx1 * dy2 - dx2 * dy1);
        return !(s < 0) && !(s > 1) && !(t < 0) && !(t > 1);
    }
    // Returns the intersection point if the lines intersect,
    // and null otherwise.

    /**
     * Equals boolean.
     *
     * @param other line
     * @return true if other line equals this line flase otherwise
     */
    public boolean equals(Line other) {
        return ((this.start.equals(other.start) && this.end.equals(other.end))
                  || (this.start.equals(other.start) && this.end.equals(other.end)));
    }

    /**
     * Closest intersection to start of line point.
     *
     * @param rect collidable object shape
     * @return closest point of intersection
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> points = rect.intersectionPoints(this);
        if (points.isEmpty()) {
            return null;
        }
        Point min = points.get(0);
        double dist = this.start.distance(min);
        for (Point point: points) {
            if (point != null) {
               double distances = this.start.distance(point);
                if (distances < dist) {
                    min = point;
                }
            }
        }
        return min;
    }
}