import tools.Edge;
import tools.Graph;
import tools.Utilities;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {


    /**
     * Finds the node in the graph in the given file that has the distance of its
     * shortest path from the given starting node maximized.
     * @param filePath the path of the file to be read from to obtain the graph.
     * @param startNode the node in the graph to compute the furthest node from.
     * @return the node in the graph that is the furthest from the starting node
     * according to the distance of its shortest path.
     */
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
