import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * FinalFour class.
 * the fourth level in the game.
 */
public class FinalFour implements LevelInformation {
    private final int numBalls = 1;
    private final int paddleSpeed = 10;
    private final int paddleWidth = 250;
    private final int numOfBlocks = 1;
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        /* creating the list of the velocities and initialize them as needed */
        List<Velocity> velocityArrayList = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(345 + i * 15, 4);
            velocityArrayList.add(velocity);
        }

        /* returning the list of the velocities */
        return velocityArrayList;
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Block backGround = new Block(new Rectangle(new Point(10, 30), 780, 590),
                Color.CYAN.darker());
        return backGround;
    }

    @Override
    public List<Block> blocks() {
        List<Block> listOfBlocks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                int xValue = 10;
                listOfBlocks.add(new Block(new Rectangle(new Point(xValue + 52 * j, (i * 20) + 70),
                        52, 20), createColor(i)));
            }
        }
        for (int j = 0; j < 15; j++) {
            listOfBlocks.add(new Block(new Rectangle(new Point(10 + 52 * j, 70),
                    52, 20), Color.GRAY));
        }
        return listOfBlocks;
    }

    /**
     * createColor method.
     *
     * @param loop number to create the color as needed.
     * @return the color to the blocks creator loop.
     */
    private Color createColor(int loop) {
        if (loop == 0) {
            return Color.GRAY;
        }
        if (loop == 1) {
            return Color.red;
        }
        if (loop == 2) {
            return Color.YELLOW;
        }
        if (loop == 3) {
            return Color.GREEN;
        }
        if (loop == 4) {
            return Color.WHITE;
        }
        if (loop == 5) {
            return Color.PINK;
        }
        if (loop == 6) {
            return Color.CYAN;
        }
        return Color.GRAY;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 120;
    }

    @Override
    public Sprite getScreenAnimation(DrawSurface d) {
        return new DisplayForthScreen(d);
    }
}