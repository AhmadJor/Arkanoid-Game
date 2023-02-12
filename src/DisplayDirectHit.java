import biuoop.DrawSurface;
import java.awt.Color;

/**
 * DisplayDirectHit class.
 * the animation background of level one in the game.
 */
public class DisplayDirectHit implements Sprite {
    private DrawSurface surface;

    /**
     * constructor method.
     * @param d the drawsurface of the game.
     */
    public DisplayDirectHit(DrawSurface d) {
        this.surface = d;
    }

    @Override
    public void drawOn(DrawSurface d) {

        /* drawing the lines */
        d.setColor(Color.BLUE);
        d.drawLine(400, 75, 400, 375);
        d.drawLine(250, 225, 550, 225);

        /* three circles */
        d.drawCircle(400, 225, 60);
        d.drawCircle(400, 225, 90);
        d.drawCircle(400, 225, 120);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel game) {
    }
}