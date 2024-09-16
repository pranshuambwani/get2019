package CountChar;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pranshu
 */
public class CountCharactersTest {
    
    @Test
    public void testCountCharacters() {
        CountCharacters CountChar=new CountCharacters();
        assertEquals(11,CountChar.CountChracters("metacubepvtltd"));
    }
    
    
}