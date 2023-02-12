//Ahmad Jorban 211437223
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Sprite collection.
 *
 * @author Ahmad Jorban
 */
public class SpriteCollection {
    private final List<Sprite> sprites = new ArrayList<>();

    /**
     * Add sprite.
     *
     * @param s adds s to sprites
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> clone = new ArrayList<>(sprites);
        for (Sprite s: clone) {
            s.timePassed();
        }
    }

    /**
     * Draw all on.
     *
     * @param d call drawOn(d) on all sprites.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s:sprites) {
            s.drawOn(d);
        }
    }

}
