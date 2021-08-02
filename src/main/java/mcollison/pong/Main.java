package mcollison.pong;

/**
 * A class to control the game loop which calls the physics loop and the graphics loop.
 * This class contains the main method for the game application.
 * @author Matt Collison
 * @version 1.0
 */
public class Main {

    /** A forced delay between frames. Reduce this attribute to speed up the game. */
    public static int delay = 10;

    public static void main(String[] args) {
        GamePhysics game = new GamePhysics();
        UI ui = new UI(game);

        boolean live = true;

        while (live) {
            try {
                //A hard delay between frames
                Thread.sleep(delay);
                //process physics
                live = game.runPhysics();
                //move objects and render next frame
                ui.canvas.render(game);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}