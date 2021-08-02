package mcollison.pong;

/**
 * An concrete subclass of Shape to represent rectangles.
 * @author Matt Collison
 * @version 1.0
 */
public class Rectangle extends Shape{
    public Rectangle(int width, int height, int[] position, int[] direction) {
        super(width, height, position, direction);
    }

    public Rectangle(int width, int height, int[] position) {
        super(width, height, position);
    }

    /**
     * The methods checks top and bottom then sides for dimensions outside of possible overlap before returning true if
     * all holds and false if conditions are broken. A bounding box is used to approximate the circle boundary so we
     * assume rectangles can't be tilted.
     * @param r A Rectangle shape
     * @return true if rectangles share any overlapping pixels
     */
    public boolean overlaps(Rectangle r){
        int left = r.getPosition()[0];
        int right = r.getPosition()[0] + r.getWidth();
        int top = r.getPosition()[1];
        int bottom = r.getPosition()[1] + r.getHeight();

        if ( ( getPosition()[0] + getWidth() > left )
                && ( getPosition()[0] < right ) ) {
            if ((bottom > getPosition()[1] )
                    && (top < getPosition()[1] + getHeight() )) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method to detect overlaps between circles and rectangles.
     * Treats circle as square for bounding box so assumes no tilting.
     * @param c circle shape
     * @return true if there is an overlap
     */
    public boolean overlaps(Circle c){
        int left = c.getPosition()[0];
        int right = c.getPosition()[0] + c.getWidth();
        int top = c.getPosition()[1];
        int bottom = c.getPosition()[1] + c.getHeight();

        if ( ( getPosition()[0] + getWidth() > left )
                && ( getPosition()[0] < right ) ) {
            if ((bottom > getPosition()[1] )
                    && (top < getPosition()[1] + getHeight() )) {
                return true;
            }
        }
        return false;
    }
}
