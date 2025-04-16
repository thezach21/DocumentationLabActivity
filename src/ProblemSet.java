import tools.Edge;
import tools.Graph;
import tools.Utilities;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {


    public String furthestNode(String filePath, String startNode) {

        // Get edge list
        ArrayList<Edge> edgeList = Utilities.edgeListFromFile(filePath);

        // Convert to adjacency list
        HashMap<String,ArrayList<Edge>> adjList = Utilities.adjacencyListFromEdgeList(edgeList);

        // Create graph with adjacency list
        Graph graph = new Graph(adjList);

        // Get all paths from startNode
        HashMap<String,ArrayList<Edge>> paths = graph.allShortestPathsAdvanced(startNode);

        // Find the longest path
        //TODO: maybe make this simpler?
        String furthestNode = "";
        int longestPathLength = Integer.MIN_VALUE;
        for (String endNode : paths.keySet()) {
            int pathLength = Utilities.totalPathWeight(paths.get(endNode));
            if (pathLength > longestPathLength) {
                furthestNode = endNode;
                longestPathLength = pathLength;
            }
        }

        // Return result
        return furthestNode;
    }
}
