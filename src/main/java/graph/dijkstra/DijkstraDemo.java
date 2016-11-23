package graph.dijkstra;

/**
 * Created by Roman Korsun on 30.07.2016.
 * Demo of dijkstra's algorithm using Graph class, HashMap and binary heap
 */
public class DijkstraDemo {
    private static final Graph.Edge[] GRAPH = {
            new Graph.Edge("a", "b", 7),
            new Graph.Edge("a", "c", 9),
            new Graph.Edge("a", "f", 14),
            new Graph.Edge("b", "c", 10),
            new Graph.Edge("b", "d", 15),
            new Graph.Edge("c", "d", 11),
            new Graph.Edge("c", "f", 2),
            new Graph.Edge("d", "e", 6),
            new Graph.Edge("e", "f", 9),
    };

    private static final String START = "a";
    private static final String END = "e";

    public static void main(String[] args) {
        Graph graph = new Graph(GRAPH);
        graph.dijkstra(START);
        graph.printPath(END);
    }
}
