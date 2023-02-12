import biuoop.DrawSurface;
import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {

    /**
     * Number of balls int.
     *
     * @return the int
     */
    int numberOfBalls();
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * @return The initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the int
     */
    int paddleWidth();

    /**
     * Level name string.
     *
     * @return the string
     */
// the level name will be displayed at the top of the screen.
    String levelName();

    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();
    // its size, color and location.

    /**
     * @return The Blocks that make up this level, each block contains.
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * @return  Number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();

    /**
     * @param drawSurface draws the surface.
     * @return sprite.
     */
    Sprite getScreenAnimation(DrawSurface drawSurface);
}