package mcollison.pong;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
/**
 * An class containing the user interface components to enable keyboard inputs and display of the graphics through a
 * configured window.
 * @author Matt Collison
 * @version 1.0
 */
public class UI {
    PongCanvas canvas;// the custom drawing canvas (class extends awt Canvas)
    JFrame frame;
    public UI(GamePhysics game) {
        canvas = new PongCanvas(game);
        canvas.setSize(400, 410);

        frame = new JFrame("Pong");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyboardInput(game);
    }

    /**
     * A private subroutine called only from within the constructor to isolate the logic behind keyboard inputs.
     * @param game contains all the game objects and physics objects including those that can be controlled by the user.
     */
    private void keyboardInput(GamePhysics game){
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        canvas.repaint(game.paddle.getPosition()[0],
                                game.paddle.getPosition()[1],
                                game.paddle.getWidth(),
                                game.paddle.getHeight());
                        game.left();
                        canvas.repaint(game.paddle.getPosition()[0],
                                game.paddle.getPosition()[1],
                                game.paddle.getWidth(),
                                game.paddle.getHeight());
                        break;
                    case KeyEvent.VK_RIGHT:
                        canvas.repaint(game.paddle.getPosition()[0],
                                game.paddle.getPosition()[1],
                                game.paddle.getWidth(),
                                game.paddle.getHeight());
                        game.right();
                        canvas.repaint(game.paddle.getPosition()[0],
                                game.paddle.getPosition()[1],
                                game.paddle.getWidth(),
                                game.paddle.getHeight());
                        break;
                    case KeyEvent.VK_B:
                        game.gameShapes.add(
                                new Ball(10, new int[]{50, 50})
                        );

                }
            }
        });

    }

}
