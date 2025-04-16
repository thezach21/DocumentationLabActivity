package tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Utilities {

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

    public static int totalPathWeight(ArrayList<Edge> path) {
        int c = 0;
        for (Edge e : path) {
            c += e.weight;
        }
        return c;
    }

}
