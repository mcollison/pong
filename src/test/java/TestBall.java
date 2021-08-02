import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import mcollison.pong.Rectangle;
import mcollison.pong.Ball;

public class TestBall {
    Rectangle r1;
    Ball b1, b2, b3, b4;

    @Test
    public void testOverlaps(){
        r1 = new Rectangle(50,100,new int[]{0,0});
        b1 = new Ball( 10,new int[]{0,0});
        b2 = new Ball( 100,new int[]{0,0});
        b3 = new Ball( 100,new int[]{-100,0});
        b4 = new Ball( 100,new int[]{-50,0});
        System.out.println(r1);
        System.out.println(b1);
        assertTrue(b1.overlaps(r1));
        assertTrue(r1.overlaps(b1));
        assertTrue(b1.overlaps(b2));
        assertTrue(b3.overlaps(b4));
        assertFalse(b3.overlaps(b2));
    }

    @Test
    public void testMove(){
        b1 = new Ball( 10,new int[]{0,0});
        System.out.println(b1);
        b1.move();
        assertTrue(b1.getPosition()[0] == 2);
        assertTrue(b1.getPosition()[1] == 1);
    }

    @Test
    public void testBall(){
        b1 = new Ball( 10,new int[]{0,0});
        assertTrue(b1.getPosition()[0] == 0);
        assertTrue(b1.getPosition()[1] == 0);
        assertTrue(b1.getWidth() == 10);
        assertTrue(b1.getHeight() == 10);
        assertTrue(b1.getHeight() == b1.getWidth());
    }

}
