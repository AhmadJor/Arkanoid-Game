//Ahmad Jorban 211437223
import biuoop.DrawSurface;

/**
 * The interface Sprite.
 *
 * @author Ahmad Jorban
 */
public interface Sprite {
    /**
     * Draw on.
     *
     * @param d draw the sprite to the screen d
     */
    void drawOn(DrawSurface d);

    /**
     * // notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * Add to game.
     *
     * @param game adds sprite to game g
     */
    void addToGame(GameLevel game);
}
