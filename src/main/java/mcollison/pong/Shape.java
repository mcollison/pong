package mcollison.pong;

import java.util.Arrays;

/**
 * An abstract base class for all objects that have physics in the game.
 * @author Matt Collison
 * @version 1.0
 */
public abstract class Shape {
    private int width;
    private int height;
    private int[] position;
    /** direction vector important even for stationary objects as this decides the 'deflection' effect */
    private int[] direction = new int[2];
    public abstract boolean overlaps(Rectangle r); //currently this wouldn't need to be abstract
    public abstract boolean overlaps(Circle c);

    public Shape(int width, int height, int[] position, int[] direction) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.direction = direction;
    }

    public Shape(int width, int height, int[] position) {
        this(width, height, position, new int[]{ 0,0,});
    }

    public Shape(int width, int height) {
        this(width, height, new int[]{ 0,0,}, new int[]{ 0,0,});
    }

    /**
     *
     * @param s Shape inputs provides generic entrypoint and will be split afterwards.
     * @return true if shapes overlap.
     * @throws Exception if Shape is not Circle or Rectangle.
     */
    public boolean overlaps(Shape s) throws Exception{
        if(s instanceof Rectangle){
            return overlaps((Rectangle) s);
        }else if(s instanceof Circle){
            return overlaps((Circle) s);
        }else{
            throw new Exception("Shape subclass not recognised: " + s.getClass());
        }
    }

    /**
     * @return clear string containing key attribute data including concrete class type.
     */
    @Override
    public String toString() {
        return getClass() + "{" +
                "width=" + width +
                ", height=" + height +
                ", position=" + Arrays.toString(position) +
                ", direction=" + Arrays.toString(direction) +
                '}';
    }

    //getters and setters
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    public int[] getPosition() { return position; }
    public void setPosition(int[] position) { this.position = position; }
    public int[] getDirection() { return direction; }
    public void setDirection(int[] direction) { this.direction = direction; }
}
