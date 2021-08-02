package mcollison.pong;

import java.util.ArrayList;

/**
 * An class that contains an ArrayList of shapes involved in collisions in the game and provides the logic for a
 * physics loop that detects collisions through the overlap method and sets the rules for collision response. This
 * includes changing the direction of Movable shapes and stopping play in the endzone.
 * @author Matt Collison
 * @version 1.0
 */
public class GamePhysics {
    private int points = 0;

    private Rectangle topWall = new Rectangle(400,5,new int[]{0,0},new int[]{1,-1});
    private Rectangle leftWall = new Rectangle(5,400,new int[]{0,0},new int[]{-1,1});
    private Rectangle rightWall = new Rectangle(5,400,new int[]{395,0},new int[]{-1,1});

    /** the endZone is crucial for the completion state for the game */
    private Rectangle endZone = new Rectangle(400,5,new int[]{0,395},new int[]{0,0});

    /** paddle attribute is the main player control and it's position is also adjusted from the UI class */
    protected Paddle paddle = new Paddle(100,5,new int[]{50,350}, new int[]{1,-1});
    private Ball ball = new Ball(10,new int[]{250,50});
    /** gameShapes is the main data structure for all game objects that have physics. Also modified from the UI class */
    protected ArrayList<Shape> gameShapes = new ArrayList<Shape>(){{
        add(paddle);
        add(ball);
        add(topWall);
        add(endZone);
        add(leftWall);
        add(rightWall);
    }};

    /**
     * This is the physics loop to determine if game objects have collided during gameplay and the actions to take.
     * Notably, the ball direction should be inverted from hohrizontal and vertical walls due to their 'direction'
     * attribute, a point is added when the paddle collides with the ball and the method returns false when a ball
     * enters the endZone Rectangle.
     * @return true if the game is still live and false if a Movable object enters the endZone Rectangle.
     * @throws Exception
     */
    public boolean runPhysics() throws Exception {
        //move all movable pieces and render new position
        for (Shape s1 : gameShapes){
            if (s1 instanceof Movable){
                for (Shape s2 : gameShapes){
                    if ( s1 != s2 && s1.overlaps(s2) ){
                        s1.getDirection()[0] = s1.getDirection()[0]*s2.getDirection()[0];
                        s1.getDirection()[1] = s1.getDirection()[1]*s2.getDirection()[1];
                        if ( s2 instanceof Paddle ){
                            points++;
                        }
                        if ( s2 == endZone ) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /** Changing the position of the paddle controller.*/
    public void left(){
        this.paddle.getPosition()[0] = paddle.getPosition()[0]-20;
    }
    /** Changing the position of the paddle controller.*/
    public void right(){
        this.paddle.getPosition()[0] = paddle.getPosition()[0]+20;
    }
}
