package mcollison.pong;
/**
 * A concrete subclass of Rectangle and Shape that enables the user controlled input to be formally distinguished.
 * @author Matt Collison
 * @version 1.0
 */
public class Paddle extends Rectangle {
    public Paddle(int width, int height, int[] position, int[] direction) {
        super(width, height, position, direction);
    }

    public Paddle(int width, int height, int[] position) {
        super(width, height, position);
    }
}
