package coffee_and_tea.coding_exercise.data_structure.graph;

import java.util.HashSet;
import java.util.Set;

public class GraphAdjacencyListImpl implements Graph{

    private Set<Integer>[] adj;
    private int V;
    private int E;

    public GraphAdjacencyListImpl(int V) {
        this.V = V;
        adj = new Set[V];
        for(int i = 0; i < V; i++){
            adj[i] = new HashSet<>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < V; i++) {
            sb.append(i + "-" + adj[i].toString()+"\n");
        }
        return sb.toString();
    }
}
