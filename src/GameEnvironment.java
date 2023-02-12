//Ahmad Jorban 211437223
import java.util.ArrayList;
import java.util.List;

/**
 * The type Game environment.
 *
 * @author Ahmad Jorban
 */
public class GameEnvironment {
    // add the given collidable to the environment.
    private final List<Collidable> collidables = new ArrayList<>();

    /**
     * Add collidable.
     *
     * @param c add collidable to collidables list
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * Gets collidables.
     *
     * @return this collidables
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * Gets closest collision.
     *
     * @param trajectory checks if trajectory collides with collidables
     * @return collision info
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> pointArrayList = new ArrayList<>();
        for (int i = 0; i < collidables.size(); i++) {
            Collidable box = collidables.get(i);
            Point point = trajectory.closestIntersectionToStartOfLine(box.getCollisionRectangle());
            if (point != null) {
                pointArrayList.add(point);
            }
        }
        if (pointArrayList.isEmpty()) {
            return null;
        }
        Point min = pointArrayList.get(0);
        if ((min.getY() == 0 || min.getX() == 0) && pointArrayList.size() > 1) {
            min = pointArrayList.get(1);
        }

        for (int i = 0; i < pointArrayList.size(); i++) {
            Point p = pointArrayList.get(i);
            if (min.distance(trajectory.start()) >= p.distance(trajectory.start())) {
                min = p;
            }
        }
        int temp = -1;
        for (int i = 0; i < collidables.size(); i++) {
            Collidable box = collidables.get(i);
            if (min.equals(trajectory.closestIntersectionToStartOfLine(box.getCollisionRectangle()))) {
                temp = collidables.indexOf(box);
                break;
            }
        }
        return new CollisionInfo(min, collidables.get(temp));
    }

}