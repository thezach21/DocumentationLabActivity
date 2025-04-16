package tools;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementation of a graph using an adjacency list.
 * @implNote This code is intentionally obfuscated a bit, to make it better for demonstrating the
 * concepts of this activity. Do not look to any of this for ideas on good code practice, even
 * if you can understand part or all of it.
 */
public class Graph {

    public final HashMap<String,ArrayList<Edge>> adjList;

    /**
     * Constructs a new {@code Graph} with the specified map as its adjacency list.
     * @param adjacencyList the map to be used as this graph's adjacency list.
     */
    public Graph(HashMap<String,ArrayList<Edge>> adjacencyList) {
        this.adjList = adjacencyList;
    }

    /**
     * Computes the shortest path between the specified nodes on the graph.
     * Does not work properly on graphs with negative edge weights.
     * @param start a {@code String} representing the node in the graph
     *              that the path should start on.
     * @param end a {@code String} representing the node in the graph
     *            that the path should end on.
     * @return an {@code ArrayList} of the edges in the computed path
     * starting at {@code start} and ending at {@code end}.
     */
    public ArrayList<Edge> shortestPathSimple(String start, String end) {
        return allShortestPathsSimple(start).get(end);
    }

    /**
     * Computes the shortest path between the specified nodes on the graph.
     * Can work on graphs with negative edge weights.
     * @param start a {@code String} representing the node in the graph
     *              that the path should start on.
     * @param end a {@code String} representing the node in the graph
     *            that the path should end on.
     * @return an {@code ArrayList} of the edges in the computed path
     * starting at {@code start} and ending at {@code end}.
     */
    public ArrayList<Edge> shortestPathAdvanced(String start, String end) {
        return allShortestPathsAdvanced(start).get(end);
    }

    /**
     * Computes the shortest paths to each node in the graph starting at the specified node.
     * Does not work properly on graphs with negative edge weights.
     * @param start a {@code String} representing the node on the graph
     *              that the paths should start from.
     * @return a {@code HashMap} of all the computed paths. The keys of this map are
     * {@code Strings} representing the end node of the corresponding path.
     */
    public HashMap<String,ArrayList<Edge>> allShortestPathsSimple(String start) {
        //TODO: this
        return null;
    }

    /**
     * Computes the shortest paths to each node in the graph starting at the specified node.
     * Can work on graphs with negative edge weights.
     * @param start a {@code String} representing the node on the graph
     *              that the paths should start from.
     * @return a {@code HashMap} of all the computed paths. The keys of this map are
     * {@code Strings} representing the end node of the corresponding path.
     */
    public HashMap<String,ArrayList<Edge>> allShortestPathsAdvanced(String start) {
        //TODO: also this
        return null;
    }


}
