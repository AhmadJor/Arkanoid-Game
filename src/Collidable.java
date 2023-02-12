//Ahmad jorban 211437223

/**
 * The interface Collidable.
 *
 * @author Ahmad Jorban
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * Hit velocity.
     *
     * @param hitter          the hitter
     * @param collisionPoint  collision points with object
     * @param currentVelocity ball velocity
     * @return new ball velocity after collison
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}