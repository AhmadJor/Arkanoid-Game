import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Countdown animation.
 *
 * @author Ahmad Jorban. class.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int currentCount;
    private SpriteCollection gameScreen;
    private boolean stop;
    private double currentTime;

    /**
     * constructor method.
     *
     * @param collection the screen of the game with all the sprites.
     */
    public CountdownAnimation(SpriteCollection collection) {
        this.currentCount = 3;
        this.numOfSeconds = 2;
        this.gameScreen = collection;
        this.stop = false;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        if (this.currentCount == 0) {
            this.stop = true;
        }
        Color color = Color.RED.darker();
        d.setColor(color);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, displayTimer(), 50);
    }

    /**
     * calculating the time to show new number.
     *
     * @return the number to show on the screen as a string.
     */
    public String displayTimer() {
        double timer = System.currentTimeMillis();
        if (!(timer - currentTime > numOfSeconds / (this.currentCount + 1) * 1000)) {
            return this.currentCount != 0 ? "" + this.currentCount + "" : "";
        }
        this.currentTime = System.currentTimeMillis();
        this.currentCount -= 1;
        /* returning the number to print on the screen as a string. */
        return this.currentCount != 0 ? "" + this.currentCount + "" : "";
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}