import tools.Edge;
import tools.Graph;
import tools.Utilities;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {


    public static String furthestNode(String filePath, String startNode) {

        // Get edge list
        ArrayList<Edge> edgeList = Utilities.edgeListFromFile(filePath);

        // Convert to adjacency list
        HashMap<String,ArrayList<Edge>> adjList = Utilities.adjacencyListFromEdgeList(edgeList);

        // Create graph with adjacency list
        Graph graph = new Graph(adjList);

        // Get all paths from startNode
        HashMap<String,ArrayList<Edge>> paths = graph.allShortestPathsAdvanced(startNode);

        // Return the longest path
        return Utilities.findLongestPath(paths);

    }
}
