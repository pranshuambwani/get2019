package Cricket;
import static org.junit.Assert.*;

import org.junit.Test;


public class Crickettest2 {

    @Test
    public void testSequence() {
        BowlingStrategy object=new BowlingStrategy(5,3);
        object.addBowler("bowler1", 5);
        object.addBowler("bowler2", 7);
        object.addBowler("bowler3", 4);
        String[] sequence=object.getSequence();
        String[] expected={"bowler2","bowler2","bowler2","bowler1","bowler1"};
        assertArrayEquals(expected,sequence);
    }

}