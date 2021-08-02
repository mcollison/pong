package mcollison.pong;
/**
 * An concrete subclass of Circle and Shape to represent movable circles.
 * @author Matt Collison
 * @version 1.0
 */
public class Ball extends Circle implements Movable{
    public Ball(int radius, int[] position) {
        super(radius, position);
        super.setDirection(new int[]{1,1});
    }

    public Ball(int[] position) {
        this(10, position);
    }

    /**
     * The move method is called on every physics loop and adds the direction attribute to the position.
     * This method overrides the abstract method from the Movable interface.
     */
    @Override
    public void move() {
        setPosition(new int[]{
                getPosition()[0] + getDirection()[0],
                getPosition()[1] + getDirection()[1]
        });
    }
}
