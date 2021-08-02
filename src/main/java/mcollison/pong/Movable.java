package mcollison.pong;

/**
 * An interface to note objects that move and change direction on collisions.
 * @author Matt Collison
 * @version 1.0
 */
public interface Movable {
    /** A method that will be called on each game loop. */
    public void move();
}
