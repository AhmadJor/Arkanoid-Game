/**
 * The type Score tracking listener.
 * @author Ahmad Jorban
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter is the scores in the game
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * this is a getter method to get the number of scores.
     *
     * @return the number of current scores
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * this method adds 5 each time hit a block .
     *
     * @param beingHit the block that is being hit
     * @param hitter   the ball that hits
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }

    /**
     * this method is to add i (100) scores min the end.
     *
     * @param i is the number of scores to add
     */
    public void addScore(int i) {
        this.currentScore.increase(i);

    }
}
