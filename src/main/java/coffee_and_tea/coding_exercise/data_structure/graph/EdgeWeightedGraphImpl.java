package coffee_and_tea.coding_exercise.data_structure.graph;

import java.util.HashSet;
import java.util.Set;

public class EdgeWeightedGraphImpl implements EdgeWeightedGraph{

    private final int V;
    private final Set<Edge>[] adj;

    public EdgeWeightedGraphImpl(int V) {
        this.V = V;
        adj = (Set<Edge>[]) new HashSet[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new HashSet<Edge>();
        }
    }

    @Override
    public void addEdge(Edge edge) {
        int v = edge.either(), w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
    }

    @Override
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    @Override
    public Iterable<Edge> edges() {
        return null;
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return 0;
    }
}
