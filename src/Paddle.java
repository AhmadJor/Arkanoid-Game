//Ahmad Jorban 211437223
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Ahmad Jorban
 */
public class Paddle implements Sprite, Collidable {
    private final biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private final int puddleSize = 100;
    private GameLevel gameLevel;
    private Rectangle rectangle1;
    private java.awt.Color color;
    private java.util.List<Ball> listBalls;
    private int movingSteps;


    /**
     * Paddle constructor.
     * creating and initializing all the things is needed to create the paddle.
     * @param gameLevel the game object.
     * @param point - start point of the paddle.
     * @param width - the width size.
     * @param height - the height size.
     * @param color - the color of the paddle.
     * @param movingSteps - the moving parameter.
     */
    public Paddle(GameLevel gameLevel, Point point, double width, double height, Color color, int movingSteps) {
        this.gameLevel = gameLevel;
        this.keyboard = gameLevel.getGUI().getKeyboardSensor();
        this.rectangle = new Rectangle(point, width, height);
        this.listBalls = new ArrayList<Ball>();
        this.color = color;
        this.movingSteps = movingSteps;
    }

    /**
     * move paddle one step to the left.
     */
    public void moveLeft() {
        this.rectangle = new Rectangle(new Point(this.rectangle.getUpperLeft().getX() - 10,
                this.rectangle.getUpperLeft().getY()), this.rectangle.getWidth(), this.rectangle.getHeight());
        if (this.rectangle.getUpperLeft().getX() <= 20) {
            this.rectangle = new Rectangle(new Point(20, this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }
    /**
     * move paddle one step to the right.
     */
    public void moveRight() {
        this.rectangle = new Rectangle(new Point(this.rectangle.getUpperLeft().getX() + 10,
                this.rectangle.getUpperLeft().getY()), this.rectangle.getWidth(), this.rectangle.getHeight());

        if (this.rectangle.getUpperLeft().getX() >= 780 - this.rectangle.getWidth()) {
            this.rectangle = new Rectangle(new Point(780 - rectangle.getWidth(),
                    this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }
    // Sprite
    /**
     * checks which key is pressed and notifies the right function.
     */
    public void timePassed() {
        if (keyboard.isPressed("a") || keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed("d") || keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * @param d draw paddle on d .
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.blue);
        int x = (int) rectangle.getUpperLeft().getX();
        int y = (int) rectangle.getUpperLeft().getY();
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        d.fillRectangle(x, y, width, height);
    }

    /**
     *
     * @return this.rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     *
     * @param collisionPoint collision points with object
     * @param currentVelocity ball velocity
     * @return currentVelocity after changes
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double width = this.rectangle.getWidth();
        double speed = currentVelocity.getSpeed();
        double distance = collisionPoint.distance(this.rectangle.getUpperLeft());
        if (distance < width / 5) {
            currentVelocity = Velocity.fromAngleAndSpeed(330, speed);
        } else if (distance < 2 * width / 5) {
            currentVelocity = Velocity.fromAngleAndSpeed(300, speed);
        } else if (distance < 3 * width / 5) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        } else if (distance < 4 * width / 5) {
            currentVelocity = Velocity.fromAngleAndSpeed(60, speed);
        } else if (distance < width) {
            currentVelocity = Velocity.fromAngleAndSpeed(30, speed);
        }

        return currentVelocity;
    }

    /**
     *
     * @param game is to add for it the sprites and coliidables
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

}