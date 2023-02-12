//Ahmad Jorban 211437223

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;

import java.util.List;

/**
 * The type Block.
 *
 * @author Ahmad Jorban
 */
public class Block implements Sprite, Collidable, HitNotifier {
    private final Rectangle rectangle;
    private final Color color;
    private final List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Instantiates a new Block.
     *
     * @param rectangle     is a block shape
     * @param color new block color
     */
    public Block(Rectangle rectangle, Color color) {
        this.color = color;
        this.rectangle = rectangle;

    }

    /**
     * @param surface draws block on surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * time pass.
     */
    @Override
    public void timePassed() {

    }

    /**
     * @param game adds sprite to game g
     */
    @Override
    //add block to game
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * @return this.rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * @param collisionPoint  collision points with this object
     * @param currentVelocity velocity of the ball
     * @return new velocity of the ball
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double y = collisionPoint.getY();
        double x = collisionPoint.getX();
        double recX = rectangle.getUpperLeft().getX();
        double height = rectangle.getHeight();
        double recY = rectangle.getUpperLeft().getY();
        double width = rectangle.getWidth();
        boolean flag = false;
        if (x < recX + width && x > recX) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
            flag = true;
        }
        if (y < recY + height && y > recY) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
            flag = true;
        }
        if (!flag) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * removeFromGame - remove the block from the given game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * @param hitter is ball to be notified if a hit event took place
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     *
     * @param hl the listener to add
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     *
     * @param hl the listener to remove
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Gets hit listener.
     *
     * @return a list of listeners
     */
    public List<HitListener> getHitListener() {
        return this.hitListeners;
    }
}