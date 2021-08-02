package mcollison.pong;

import java.awt.Canvas;
import java.awt.Graphics;
/**
 * A class extended from awt Canvas to handle the drawing of graphics.
 * @author Matt Collison
 * @version 1.0
 */
public class PongCanvas extends Canvas {
    private GamePhysics game;
    public PongCanvas(GamePhysics game){
        this.game = game;
    }

    /**
     * The paint method displays the objects on the first frame.
     * @param g the graphics object integrated in the UI from awt.
     */
    public void paint(Graphics g) {
        for (Shape s : game.gameShapes){
            if (s instanceof Rectangle) {
                g.fillRect(s.getPosition()[0], s.getPosition()[1],
                        s.getWidth(), s.getHeight());
            } else if (s instanceof Circle) {
                g.fillOval(s.getPosition()[0], s.getPosition()[1],
                        s.getWidth(), s.getHeight());
            }
        }
    }

    /**
     * The render method calls the 'move' method and creates the graphic for all Movable objects in their new
     * position using the java.awt.Canvas repaint method.
     */
    public void render(GamePhysics game) {
        for (Shape s : game.gameShapes){
            if (s instanceof Movable ){
                repaint(s.getPosition()[0], s.getPosition()[1],
                        s.getWidth(), s.getHeight()); // Clear old area to background
                ((Movable) s).move();
                repaint(s.getPosition()[0], s.getPosition()[1],
                        s.getWidth(), s.getHeight()); // Clear old area to background
            }
        }
    }
}
