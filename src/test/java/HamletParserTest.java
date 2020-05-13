import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String testShakespeare = hamletParser.changeHamletToLeon();
        Assert.assertFalse(testShakespeare.contains("Hamlet"));
        Assert.assertFalse(testShakespeare.contains("HAMLET"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String testShakespeare = hamletParser.changeHoratioToTariq();
        Assert.assertFalse(hamletText.contains("Horatio"));
        Assert.assertFalse(hamletText.contains("HORATIO"));
    }

    @Test
    public void testFindHoratio() {
        Assert.assertFalse(hamletText.contains("Horatio"));

    }

    @Test
    public void testFindHamlet() {
        Assert.assertFalse(hamletText.contains("Hamlet"));
    }
}