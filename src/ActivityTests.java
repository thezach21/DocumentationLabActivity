import org.junit.Test;
import tools.Edge;
import tools.Graph;
import tools.Utilities;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ActivityTests {

    @Test
    public void test() {
        ArrayList<Edge> edgeList = Utilities.edgeListFromFile("data/input1.csv");
        HashMap<String,ArrayList<Edge>> adjList = Utilities.adjacencyListFromEdgeList(edgeList);
        Graph graph = new Graph(adjList);
        ArrayList<Edge> result = graph.shortestPathSimple("1","8");
        int x = Utilities.totalPathWeight(result);
    }

    @Test
    public void testTheSecond() {
        ArrayList<Edge> edgeList = Utilities.edgeListFromFile("data/input3.csv");
        HashMap<String,ArrayList<Edge>> adjList = Utilities.adjacencyListFromEdgeList(edgeList);
        Graph graph = new Graph(adjList);
        ArrayList<Edge> result = graph.shortestPathAdvanced("1","8");
        int x = Utilities.totalPathWeight(result);
    }

    @Test
    public void testTheThird() {
        assertEquals("6",ProblemSet.furthestNode("data/input3.csv","1"));
    }

}
