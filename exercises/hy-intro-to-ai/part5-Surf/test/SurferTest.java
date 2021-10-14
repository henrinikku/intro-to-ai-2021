import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;

@Points("Surfer")
public class SurferTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testEmptyBoard() {
        assertTrue(true);
    }
}
