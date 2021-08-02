package mcollison.pong;

/**
 * An concrete subclass of Shape to represent circles.
 * @author Matt Collison
 * @version 1.0
 */
public class Circle extends Shape {
    public Circle(int radius, int[] position, int[] direction) {
        super(radius, radius, position, direction);
    }

    public Circle(int radius, int[] position) {
        super(radius, radius, position);
        setDirection(new int[]{0,0});
    }

    /**
     * The methods checks top and bottom then sides for dimensions outside of possible overlap before returning true if
     * all holds and false if conditions are broken. A bounding box is used to approximate the circle boundary so we
     * assume rectangles can't be tilted.
     * @param r A Rectangle shape
     * @return true if bounding box of circle overlaps
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
     * Overlaps between circles are detected with pythagoras between the coordinates and combined radii.
     * @param c the circle to be compared against
     * @return true if there is an overlapping area between the shape dimensions.
     */
    public boolean overlaps(Circle c){
        int asq = (int) Math.pow( Math.abs(c.getPosition()[0] - getPosition()[0]), 2 );
        int bsq = (int) Math.pow( Math.abs(c.getPosition()[1] - getPosition()[1]), 2 );
        if ( ( getWidth() + c.getWidth() ) > Math.sqrt(asq + bsq) ){
            return true;
        }
        return false;
    }
}
