/**
 * The type Block remover.
 * @author Ahmad Jorban
 */
// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game          is the game
     * @param removedBlocks is the number of remaining blocks in the game
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }



    /**
     * Blocks that are hit should be removed.
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit is the block that is being hit
     * @param hitter the ball the hits
     */

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(beingHit.getHitListener().get(0));
        this.game.removeSprite(beingHit);
        this.game.removeCollidable(beingHit);
    }

    /**
     * this method is to increase the number of blocks in block remover.
     *
     * @param number is the number of blocks to be increased
     */
    public void addBlock(int number) {
        remainingBlocks.increase(number);
    }

    /**
     * Remained blocks int.
     *
     * @return the remaining number of blocks in the game
     */
    public int remainedBlocks() {
        return remainingBlocks.getValue();
    }
}