import mcollison.pong.Ball;
import mcollison.pong.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestRectangle {
    Rectangle r1, r2, r3, r4;
    Ball b1, b2, b3, b4;

    @Test
    public void testOverlaps(){
        r1 = new Rectangle(50,100,new int[]{0,0});
        r2 = new Rectangle( 100, 200,new int[]{0,0} );
        r3 = new Rectangle( 100, 10, new int[]{-100,0} );
        r4 = new Rectangle( 100,50, new int[]{-50,0} );
        b1 = new Ball( 10,new int[]{0,0});
        System.out.println(r1);
        System.out.println(b1);
        assertTrue(r1.overlaps(r1));
        assertTrue(r1.overlaps(r2));
        assertFalse(r2.overlaps(r3));
        assertTrue(r1.overlaps(b1));
        assertTrue(r2.overlaps(b1));
    }

    @Test
    public void testRectangle(){
        r1 = new Rectangle( 10, 100,new int[]{0,0});
        assertTrue(b1.getPosition()[0] == 0);
        assertTrue(b1.getPosition()[1] == 0);
        assertTrue(b1.getWidth() == 10);
        assertTrue(b1.getHeight() == 100);
        assertTrue(b1.getDirection()[0] == 0);
        assertTrue(b1.getDirection()[1] == 0);
    }

}
