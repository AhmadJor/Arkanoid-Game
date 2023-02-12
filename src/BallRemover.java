/**
 * The type Ball remover.
 * @author Ahmad Jorban
 */
public class BallRemover implements HitListener {
    private GameLevel game;      /* the game */
    private Counter remainingBalls;     /* the counter of the balls */

    /**
     * the constructor.
     *
     * @param game          the game
     * @param removedBlocks the counter of the balls
     */
    BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBalls = removedBlocks;
    }



    /**
     * Blocks that are hit should be removed.
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit the block
     * @param hitter   the ball
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);
    }

    /**
     * addBalls is a method to increase the number of balls .
     *
     * @param i the number of new balls
     */
    public void addBalls(int i) {
        remainingBalls.increase(i);
    }

    /**
     * this method is to get the number of balls.
     *
     * @return the number of remain ing balls
     */
    public int getRemainingBalls() {
        return remainingBalls.getValue();
    }
}
