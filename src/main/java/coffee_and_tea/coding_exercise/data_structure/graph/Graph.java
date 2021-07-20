package coffee_and_tea.coding_exercise.data_structure.graph;

public interface Graph {

    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
    int V();
    int E();
    String toString();
}
