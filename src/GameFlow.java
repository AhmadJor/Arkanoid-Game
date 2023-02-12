import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * GameFlow class.
 * controls the game flow - winning and loosing in the game.
 */
public class GameFlow {
    private final AnimationRunner animationRunner;
    private final KeyboardSensor ks;
    private final GUI gui;
    private final Counter gameScore = new Counter(0);
    private GameEnvironment gameEnvironment;

    /**
     * constructor method.
     *
     * @param animationRunner  the animation runner.
     * @param ks  the keyboard sensor of the gui.
     * @param gui the gui animator.
     */
    public GameFlow(AnimationRunner animationRunner, KeyboardSensor ks, GUI gui) {
        this.animationRunner = animationRunner;
        this.ks = ks;
        this.gui = gui;
    }

    /**
     * runLevels method.
     *
     * @param levels the levels that it has to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        /* going over the levels in the given list*/
        for (LevelInformation levelInfo : levels) {
            /* creating the gamelevel object */
            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.ks, this.gui, gameScore);
            level.initialize();
            while (level.getNumOfBlocks().getValue() != 0 && level.getNumOfBalls().getValue() != 0) {
                level.run();
                if (this.ks.isPressed("p") || this.ks.isPressed("P")) {
                    this.animationRunner.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                            new PauseScreen(this.ks)));
                }
                if (level.getNumOfBalls().getValue() == 0) {
                    this.animationRunner.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                            new EndLoseScreen(ks, gameScore)));
                    gui.close();
                    return;
                }
            }
            if (level.getNumOfBalls().getValue() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                        new EndLoseScreen(ks, gameScore)));
                gui.close();
                return;
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                new EndWinScreen(ks, gameScore)));
        gui.close();

    }
}