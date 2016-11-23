package graph.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by Roman Korsun on 30.07.2016.
 */
public class Graph {
    private final Map<String, Vertex> graph;

    /** One edge of the graph (only used by Graph constructor) */
    public static class  Edge {
        public final String ver1;
        public final String ver2;
        public final int dist;
        public Edge(String ver1, String ver2, int dist) {
            this.ver1 = ver1;
            this.ver2 = ver2;
            this.dist = dist;
        }
    }
    /** One vertex of the graph, complete with mappings to neighbouring vertices */
    public static class Vertex implements Comparable<Vertex> {
        public final String name;
        public  int dist = Integer.MAX_VALUE;// MAX_VALUE assumed to be infinity
        public Vertex previous = null;
        public final Map<Vertex, Integer> neighbours = new HashMap<>();

        public Vertex(String name) {
            this.name = name;
        }

        private void printPath() {
            if(this == this.previous) {
                System.out.printf("%s", this.name);
            } else if (this.previous == null) {
                System.out.printf("%s(unreached)", this.name);
            } else {
                this.previous.printPath();
                System.out.printf(" -> %s(%d)", this.name, this.dist);
            }
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(dist, other.dist);
        }
    }

    /** Builds a graph from a set of edges */
    public Graph(Edge[] edges) {
        graph = new HashMap<>(edges.length);

        //one pass to find all vertices
        for (Edge e: edges) {
            if(!graph.containsKey(e.ver1)) graph.put(e.ver1, new Vertex(e.ver1));
            if(!graph.containsKey(e.ver2)) graph.put(e.ver2, new Vertex(e.ver2));
        }

        //another pass to set neighbouring vertices
        for (Edge e : edges ) {
            graph.get(e.ver1).neighbours.put(graph.get(e.ver2), e.dist);
            //graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
        }
    }

    /** Runs dijkstra using a specified source vertex */
    public void dijkstra (String startName) {
        if(!graph.containsKey(startName)) {
            System.err.printf("Graph does not contain start vertex \"%s\"\n", startName);
            return;
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<>();

        //set-up vertices
        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }
        dijkstra(q);
    }

    /** Implementation of dijkstra's algorithm using a binary heap */
    private void  dijkstra(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {
            u = q.pollFirst(); //vertex with shortest distance (first iteration returns source)
            if(u.dist == Integer.MAX_VALUE) break; // we can ignere u (and any other remaining vertices) since they are unreachable


            //Look at distances to each neighbour
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if(alternateDist < v.dist) { //shortest path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /** Prints a path from the source to the specified vertex */
    public void printPath(String endName) {
        if(!graph.containsKey(endName)) {
            System.err.printf("Graph does not contain end vertex \"%s\"\n", endName);
            return;
        }
        graph.get(endName).printPath();
        System.out.println();
    }
    /** Prints the path from the source to every vertex (output order is not guaranteed) */
    public void printAllPaths() {
        for (Vertex v: graph.values()) {
            v.printPath();
            System.out.println();
        }
    }
}
