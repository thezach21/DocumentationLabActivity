package tools;

import java.util.Comparator;

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
        public QueueEntry(Edge e, int prio) {
            edge = e;
            priority = prio;
        }
    }

    public static class edgeComparator implements Comparator<QueueEntry> {
        @Override
        public int compare(QueueEntry o1, QueueEntry o2) {
            return o1.priority - o2.priority;
        }
    }

}
