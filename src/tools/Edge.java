package tools;

import java.util.Comparator;
import java.util.Objects;

public class Edge {
    public final String start;
    public final String end;
    public final int weight;

    public Edge(String start, String  end, int weight) {
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    public static class QueueEntry {
        public final Edge edge;
        public final int priority;
        public QueueEntry(Edge edge, int priority) {
            this.edge = edge;
            this.priority = priority;
        }
    }

    public static class edgeComparator implements Comparator<QueueEntry> {
        @Override
        public int compare(QueueEntry o1, QueueEntry o2) {
            return o1.priority - o2.priority;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight && Objects.equals(start, edge.start) && Objects.equals(end, edge.end);
    }

}
