//211437223
import java.util.Random;

/**
 * The type Velocity.
 *
 * @author Ahmad Jorban this class is to craete a velocity of a ball
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * method to get dx.
     *
     * @return this.dx dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * method to get dy.
     *
     * @return this.dy dy
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * constructor.
     *
     * @param dx x change
     * @param dy y change
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * method to set the velocity according to an angle and speed.
     *
     * @param angle is the angle the ball goes to
     * @param speed is the speed of the ball
     * @return new Velocity(speed * Math.cos(angle), speed * Math.sin(angle))
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        return new Velocity(speed * Math.cos(angle), speed * Math.sin(angle));
    }

    /**
     * method to get a random velocity.
     *
     * @param range is the range of the speeds
     * @return fromAngleAndSpeed(rand.nextInt ( 90), range);
     */
    public static Velocity randomVelocity(int range) {
        Random rand = new Random();
        return fromAngleAndSpeed(rand.nextInt(90), range);
    }

    /**
     * method to change the center of the ball from one to other.
     *
     * @param p is the current point
     * @return new Point(p.getX() + this.dx, p.getY() + this.dy)
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * Gets speed.
     *
     * @return the speed of teh ball
     */
    public double getSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }

    /**
     * Sets dy.
     *
     * @param dy to set dy
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * Sets dx.
     *
     * @param dx is to set dx
     */
    public void setDx(double dx) {
        this.dx = dx;
    }
}