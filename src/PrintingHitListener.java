/**
 * The type Printing hit listener.
 */
public class PrintingHitListener implements HitListener {
    /**
     * prints for test.
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}