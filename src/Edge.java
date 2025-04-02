public class Edge {
    public final Edge start;
    public final Edge end;
    public final int weight;

    public Edge(Edge start, Edge end, int weight) {
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
}
