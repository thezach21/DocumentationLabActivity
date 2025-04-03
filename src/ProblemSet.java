import tools.Edge;
import tools.Graph;
import tools.Utilities;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {


    public String furthestNode(String filePath, String startNode) {
        ArrayList<Edge> edgeList = Utilities.edgeListFromFile(filePath);
        HashMap<String,ArrayList<Edge>> adjList = Utilities.adjacencyListFromEdgeList(edgeList);
        Graph g = new Graph(adjList);

        // might make a Path class to make this part simpler
        ArrayList<ArrayList<Edge>> paths = g.allPathsByWeight(startNode);
        ArrayList<Edge> maxPath = new ArrayList<>();
        for (ArrayList<Edge> path : paths) {
            if (Utilities.totalPathWeight(path) > Utilities.totalPathWeight(maxPath)) {
                maxPath = path;
            }
        }
        return maxPath.getLast().end;
    }
}
