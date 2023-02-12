//Ahmad 211437223
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.Random;

/**
 * The type Ball.
 *
 * @author Ahmad Jorban
 * this is the ball class.
 */
public class Ball implements Sprite {
    // fields
    private GameEnvironment gameEnvironment;
    private final int radius;
    private Point center;
    private Velocity velocity;
    private final Color color;
    // constructor

    /**
     * Instantiates a new Ball.
     *
     * @param x      x coordinates
     * @param y      y coordinates
     * @param radius ball radius
     * @param color  ball color
     * @param game   is the game environment construct a ball from 2 coordinates ints and radius from int and color
     */
    public Ball(int x, int y, int radius, java.awt.Color color, GameEnvironment game) {
        this.radius = radius;
        this.color = color;
        this.center = new Point(x, y);
        this.gameEnvironment = game;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param point  is a point
     * @param radius ball radius
     * @param color  ball color
     * @param game   game environment
     */
    public Ball(Point point, int radius, Color color, GameEnvironment game) {
        this.radius = radius;
        this.color = color;
        this.center = new Point(point.getX(), point.getY());
        this.gameEnvironment = game;
    }

    /**
     * @param game adds to Game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * Instantiates a new Ball.
     *
     * @param point  ball center/coordinates
     * @param radius ball radius
     * @param color  ball color construct a ball from  a point radius and color
     */
    public Ball(Point point, int radius, java.awt.Color color) {
        this.radius = radius;
        this.color = color;
        this.center = new Point((int) point.getX(), (int) point.getY());
    }
    // accessors

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * Sets game environment.
     *
     * @param gameEnvironment the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Gets x.
     *
     * @return ball center x coordinates
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets center.
     *
     * @return this.center center
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * Gets y.
     *
     * @return ball center y coordinates
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return ball radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Gets velocity.
     *
     * @return ball velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Gets color.
     *
     * @return ball color
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    // draw the ball on the given DrawSurface
    /**
     * @param surface draws the ball
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) center.getX(), (int) center.getY(), radius);
    }
    @Override
    public void timePassed() {
        this.moveOneStep();
    }
    // set ball velocity

    /**
     * Sets velocity.
     *
     * @param v taking v and apply it to ball velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets velocity.
     *
     * @param dx horizontal speed
     * @param dy vertical speed sets velocity using horizontal and vertical speed
     */
//another method to set velocity
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    //method to move ball one step using ball velocity

    /**
     * moves one step.
     */
    public void moveOneStep() {
        stayInFrames();
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * calculates possible collison changes speed if there is a hit.
     */
    public void stayInFrames() {
        Point lastPoint = this.center;
        while (lastPoint.checkPound(780, 20, 580, 20)) {
            Velocity v = new Velocity(this.velocity.getDx(), this.velocity.getDy());
            lastPoint = v.applyToPoint(lastPoint);
        }
        Line trajectory = new Line(this.center, lastPoint);
        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo != null) {
            Velocity newVelocity = new Velocity(-this.velocity.getDx(), -this.velocity.getDy());
            Point newCollison = collisionInfo.collisionPoint();
            Point toPoint = newVelocity.applyToPoint(newCollison);
            double distance = this.center.distance(newCollison) - toPoint.distance(newCollison);
            if (distance <= 1) {
                this.velocity = collisionInfo.collisionObject().hit(this, newCollison, this.getVelocity());
            }
        }
    }

    /**
     * Random Color.
     *
     * @return a random color
     */
    public static Color randomColor() {
        Random rand = new Random();
        return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }

    /**
     * Remove from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}