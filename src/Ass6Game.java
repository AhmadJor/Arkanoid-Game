import biuoop.GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ass6Game class
 * the class that calls for the Game class to start the game.
 */
public class Ass6Game {

    /**
     * main method.
     * thats the method that creates the game object, initialize the game and runs it.
     * @param args not get any parameters.
     */
    public static void main(String[] args) {
        List<LevelInformation> levelInformationArrayList = new ArrayList<>();
        List<LevelInformation> runner = new ArrayList<>();
        LevelInformation directHit = new DirectHit();
        runner.add(directHit);
        LevelInformation wideEasy = new WideEasy();
        runner.add(wideEasy);
        LevelInformation greenThree = new GreenThree();
        runner.add(greenThree);
        LevelInformation finalFour = new FinalFour();
        runner.add(finalFour);
        /* create the list from the arguments */
        Arrays.stream(args).forEach(s -> {
            if (s.equals("1")) {
                levelInformationArrayList.add(directHit);
            }
            if (s.equals("2")) {
                levelInformationArrayList.add(wideEasy);
            }
            if (s.equals("3")) {
                levelInformationArrayList.add(greenThree);
            }
            if (s.equals("4")) {
                levelInformationArrayList.add(finalFour);
            }
        });
        GUI gui = new GUI("GAME", 800, 600);
        AnimationRunner animationRunner = new AnimationRunner(gui);
        GameFlow gameFlow = new GameFlow(animationRunner, gui.getKeyboardSensor(), gui);

        /* if the list from the arguments is empty, it runs a default list of levels */
        if (levelInformationArrayList.isEmpty()) {
            gameFlow.runLevels(runner);
        }
        if (args.length == 0) {
            gameFlow.runLevels(runner);
        }
        gameFlow.runLevels(levelInformationArrayList);
        gui.close();
    }
}
