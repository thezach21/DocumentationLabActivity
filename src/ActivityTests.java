import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTests {

    @Test
    public void testNoNegativeEdges() {
        assertEquals("8",ProblemSet.furthestNode("data/input1.csv","1"));
        assertEquals("6",ProblemSet.furthestNode("data/input1.csv","7"));
        assertEquals("8",ProblemSet.furthestNode("data/input1.csv","11"));
    }

    @Test
    public void testNegativeEdges() {
        assertEquals("6",ProblemSet.furthestNode("data/input3.csv","1"));
        assertEquals("6",ProblemSet.furthestNode("data/input3.csv","7"));
        assertEquals("8",ProblemSet.furthestNode("data/input2.csv","1"));
        assertEquals("4",ProblemSet.furthestNode("data/input4.csv","1"));
    }

}
