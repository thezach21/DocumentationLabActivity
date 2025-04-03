import org.junit.Test;
import tools.Edge;
import tools.Utilities;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void test() {
        ArrayList<Edge> e = Utilities.edgeListFromFile("data/input1.csv");
        assertNotNull(e);
        HashMap<String,ArrayList<Edge>> adjList = Utilities.adjacencyListFromEdgeList(e);
    }

}
