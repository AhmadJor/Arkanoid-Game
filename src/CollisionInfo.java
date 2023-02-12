//Ahmad Jorban 211437223

/**
 * The type Collision info.
 *
 * @author Ahmad Jorban
 */
public class CollisionInfo {
    private final Point collPoint;
    private final Collidable box;
    // the point at which the collision occurs.

    /**
     * construct CollisionInfo from params.
     *
     * @param collPoint c
     * @param box       box
     */
    public CollisionInfo(Point collPoint, Collidable box) {
        this.collPoint = collPoint;
        this.box = box;
    }

    /**
     * Collision point point.
     *
     * @return collision points
     */
    public Point collisionPoint() {
        return this.collPoint;
    }
    // the collidable object involved in the collision.

    /**
     * Collision object collidable.
     *
     * @return collison object
     */
    public Collidable collisionObject() {
        return this.box;
    }
}
