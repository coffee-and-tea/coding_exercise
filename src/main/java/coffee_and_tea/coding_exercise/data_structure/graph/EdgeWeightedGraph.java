package coffee_and_tea.coding_exercise.data_structure.graph;

public interface EdgeWeightedGraph {

    void addEdge(Edge edge);
    Iterable<Edge> adj(int v);
    Iterable<Edge> edges();
    int V();
    int E();
    String toString();
}
