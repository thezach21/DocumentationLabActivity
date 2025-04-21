package tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A set of static helper methods to be used for graph operations.
 */
public class Utilities {

    /**
     * Reads the file at the given path as an edge list of a
     * weighted directed graph.
     * @param pathName the path of the file to be read.
     * @return an {@code ArrayList} containing the  graph's edges.
     */
    public static ArrayList<Edge> edgeListFromFile(String pathName) {
        ArrayList<Edge> out = new ArrayList<>();
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(pathName)));
            for (String line : lines) {
                String[] l = line.split(",");
                out.add(new Edge(l[0],l[1],Integer.parseInt(l[2])));
            }
        } catch (IOException _) {}
        return out;
    }

    /**
     * Converts the given directed weighted edge list to an adjacency list.
     * @param edgeList the edge list to get the adjacency list from.
     * @return an adjacency list representation of the graph represented by the given edge list.
     */
    public static HashMap<String,ArrayList<Edge>> adjacencyListFromEdgeList(ArrayList<Edge> edgeList) {
        HashMap<String,ArrayList<Edge>> out = new HashMap<>();
        for (Edge e : edgeList) {
            if (!out.containsKey(e.start)) {
                out.put(e.start,new ArrayList<>());
            }
            if (!out.containsKey(e.end)) {
                out.put(e.end,new ArrayList<>());
            }
            out.get(e.start).add(e);
        }
        return out;
    }

    /**
     * Converts the given directed weighted adjacency list to an edge list.
     * @param adjList the edge list to get the adjacency list from.
     * @return an edge list representation of the graph represented by the given adjacency list.
     */
    public static ArrayList<Edge> edgeListFromAdjacencyList(HashMap<String,ArrayList<Edge>> adjList) {
        ArrayList<Edge> out = new ArrayList<>();
        for (ArrayList<Edge> s : adjList.values()) {
            for (Edge e : s) {
                if (!out.contains(e)) {
                    out.add(e);
                }
            }
        }
        return out;
    }

    /**
     * Computes the total number of vertices in the given graph.
     * @param adjList an adjacency list representing the graph to be counted.
     * @return the number of unique vertices in the given graph.
     */
    public static int vertexCount(HashMap<String,ArrayList<Edge>> adjList) {
        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<Edge> edges = edgeListFromAdjacencyList(adjList);
        for (Edge e : edges) {
            if (!vertices.contains(e.end)) vertices.add(e.end);
            if (!vertices.contains(e.start)) vertices.add(e.start);
        }
        return vertices.size();
    }

    /**
     * Computes the total weight of a given path.
     * @param path the path to find the total weight of.
     * @return the total weight of the given path.
     */
    public static int totalPathWeight(ArrayList<Edge> path) {
        int c = 0;
        for (Edge e : path) {
            c += e.weight;
        }
        return c;
    }

    /**
     * Finds and returns the longest path in a list of paths that would
     * be returned by methods in the {@code Graph} class.
     * @param paths a {@code HashMap} mapping Strings representing nodes
     *              to the paths from some start node to that node. This map
     *              is in the same format that would be returned by the
     *              {@code allShortestPathsSimple} and {@code allShortestPathsAdvanced}
     *              methods of the {@code Graph} class.
     * @return a String representing the node that has the longest corresponding path in the input.
     */
    public static String findLongestPath(HashMap<String,ArrayList<Edge>> paths) {
        String out = "";
        int longestPathLength = Integer.MIN_VALUE;
        for (String endNode : paths.keySet()) {
            int pathLength = Utilities.totalPathWeight(paths.get(endNode));
            if (pathLength > longestPathLength) {
                out = endNode;
                longestPathLength = pathLength;
            }
        }
        return out;
    }

}
