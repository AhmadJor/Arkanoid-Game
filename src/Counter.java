/**
 * Counter class.
 * counting things in the game like the blocks and balls.
 */
public class Counter {
    private int value;

    /**
     * constructor method.
     *
     * @param startVal integer.
     */
    public Counter(int startVal) {
        this.value = startVal;
    }

    /**
     * increase method.
     *
     * @param number integer.
     */
    void increase(int number) {
        this.value = this.value + number;
    }

    /**
     * decrease method.
     *
     * @param number integer.
     */
    void decrease(int number) {
        this.value = this.value - number;
    }

    /**
     * getValue method.
     *
     * @return integer. value
     */
    int getValue() {
        return this.value;
    }
}