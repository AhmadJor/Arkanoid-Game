
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * DirectHit class.
 * all the methods in the level classes.
 */
public class DirectHit implements LevelInformation {
    private final int numBalls = 1;
    private final int paddleSpeed = 5;
    private final int paddleWidth = 100;
    private final int numOfBlocks = 1;
    @Override
    public int numberOfBalls() {
        return numBalls;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        /* creating the list of the velocities and initialize them as needed */
        List<Velocity> list = new ArrayList<>();
        Velocity v = new Velocity(0, -3);
        list.add(v);
        /* returning the list of the velocities */
        return list;
    }
    @Override
    public int paddleSpeed() {
        return paddleSpeed;
    }
    @Override
    public int paddleWidth() {
        return paddleWidth;
    }
    @Override
    public String levelName() {
        return "Direct Hit";
    }
    @Override
    public Sprite getBackground() {
        Block backGround = new Block(new Rectangle(new Point(10, 30), 780, 590), Color.BLACK);
        return backGround;
    }
    @Override
    public List<Block> blocks() {
        List<Block> listBlocks = new ArrayList<>();
        Block b = new Block(new Rectangle(new Point(375, 200), 50, 50), Color.red);
        listBlocks.add(b);
        return listBlocks;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return numOfBlocks;
    }
    @Override
    public Sprite getScreenAnimation(DrawSurface d) {
        return new DisplayDirectHit(d);
    }
}