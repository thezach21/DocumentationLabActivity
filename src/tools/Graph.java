package tools;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementation of a graph using an adjacency list.
 */
public class Graph {

    public final HashMap<String,ArrayList<Edge>> adjList;

    /**
     * Constructs a new {@code tools.Graph} with the specified map as its adjacency list.
     * @param adjacencyList the map to be used as this graph's adjacency list
     * @implNote Normally it would be silly to have a graph class's constructor take an adjacency list as
     * a parameter, since there is little reason to have a graph class if you already have an adjacency list.
     * We do it here purely for the sake of demonstration.
     */
    public Graph(HashMap<String,ArrayList<Edge>> adjacencyList) {
        this.adjList = adjacencyList;
    }

    /**
     * Computes the shortest path by edge weight between the two specified strings in the graph.
     * Defaults to -1 if either string is not in the graph or if the strings are not connected.
     * @param start a {@code String} of the starting node in the path
     * @param end a {@code String} of the final node in the path
     * @return an {@code ArrayList} of the computed path
     */
    public ArrayList<Edge> shortestPathByWeight(String start, String end) {
        return null;
    }

    /**
     * Computes the shortest path by number of edges between the two specified
     * strings in the graph. Defaults to -1 if either string is not in the graph
     * or if the strings are not connected.
     * @param start a {@code String} of the starting node in the path
     * @param end a {@code String} of the final node in the path
     * @return an {@code ArrayList} of the computed path
     */
    public ArrayList<Edge> shortestPathEdgeCount(String start, String end) {
        return null;
    }

    public ArrayList<ArrayList<Edge>> allPathsByWeight(String start) {
        ArrayList<ArrayList<Edge>> out = new ArrayList<>();
        for (String endNode : this.adjList.keySet()) {
            out.add(this.shortestPathByWeight(start,endNode));
        }
        return out;
    }

    public ArrayList<ArrayList<Edge>> allPathsEdgeCount(String start) {
        ArrayList<ArrayList<Edge>> out = new ArrayList<>();
        for (String endNode : this.adjList.keySet()) {
            out.add(this.shortestPathEdgeCount(start,endNode));
        }
        return out;
    }

}
