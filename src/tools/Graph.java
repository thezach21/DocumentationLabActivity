package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

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
     * starting at {@code start} and ending at {@code end}. An empty
     * list implies that the node is the starting node, and a return
     * value of {@code Null} implies that the node is not reachable from
     * the start node or not in the graph.
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
     * starting at {@code start} and ending at {@code end}. An empty
     * list implies that the node is the starting node, and a return
     * value of {@code Null} implies that the node is not reachable from
     * the start node or not in the graph.
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
     * {@code Strings} representing the end node of the corresponding path. An empty
     * list as a value implies that the string is the starting node, and any nodes not
     * reachable from the starting node will not be included in the output.
     */
    public HashMap<String,ArrayList<Edge>> allShortestPathsSimple(String start) {
        HashMap<String,Integer> distances = new HashMap<>();
        HashMap<String,Edge> previous = new HashMap<>();
        PriorityQueue<Edge.QueueEntry> queue = new PriorityQueue<>(new Edge.edgeComparator());
        distances.put(start,0);
        previous.put(start,null);
        for (String s : adjList.keySet()) {
            if (!s.equals(start)) {
                distances.put(s,Integer.MAX_VALUE);
            }
        }
        for (Edge e : adjList.get(start)) {
            queue.add(new Edge.QueueEntry(e,e.weight));
            previous.put(e.end,e);
            distances.put(e.end,e.weight);
        }

        while (!queue.isEmpty()) {
            Edge current = queue.poll().edge;
            for (Edge e : adjList.get(current.end)) {
                if (e.weight + distances.get(current.end) < distances.get(e.end)) {
                    previous.put(e.end,e);
                    distances.put(e.end,e.weight + distances.get(current.end));
                    queue.add(new Edge.QueueEntry(e,e.weight + distances.get(current.end)));
                }
            }
        }

        HashMap<String,ArrayList<Edge>> out = new HashMap<>();
        for (String s : previous.keySet()) {
            out.put(s,new ArrayList<>());
            String c = s;
            while (c != null && previous.get(c) != null) {
                out.get(s).addFirst(previous.get(c));
                c = previous.get(c).start;
            }
        }
        return out;
    }

    /**
     * Computes the shortest paths to each node in the graph starting at the specified node.
     * Can work on graphs with negative edge weights, but does not work on graphs with negative cycles.
     * @param start a {@code String} representing the node on the graph
     *              that the paths should start from.
     * @return a {@code HashMap} of all the computed paths. The keys of this map are
     * {@code Strings} representing the end node of the corresponding path. An empty
     * list as a value implies that the string is the starting node, and any nodes not
     * reachable from the starting node will not be included in the output.
     */
    public HashMap<String,ArrayList<Edge>> allShortestPathsAdvanced(String start) {
        ArrayList<Edge> eList = Utilities.edgeListFromAdjacencyList(adjList);
        HashMap<String,Integer> distances = new HashMap<>();
        HashMap<String,Edge> previous = new HashMap<>();
        for (String s : adjList.keySet()) {
            distances.put(s,Integer.MAX_VALUE);
        }
        distances.put(start,0);

        for (int i = 0; i < Utilities.vertexCount(adjList); i++) {
            for (Edge e : eList) {
                if (distances.get(e.start) != Integer.MAX_VALUE) {
                    int newDist = distances.get(e.start) + e.weight;
                    if (newDist < distances.get(e.end)) {
                        distances.put(e.end,newDist);
                        previous.put(e.end,e);
                    }
                }
            }
        }

        HashMap<String,ArrayList<Edge>> out = new HashMap<>();
        for (String s : previous.keySet()) {
            out.put(s,new ArrayList<>());
            String current = s;
            while (previous.get(current) != null) {
                out.get(s).addFirst(previous.get(current));
                current = previous.get(current).start;
            }
        }
        return out;
    }

}
