package coffee_and_tea.coding_exercise.data_structure.graph;

public abstract class Graph {

    public abstract void addEdge(int v, int w);
    public abstract Iterable<Integer> adj(int v);
    public abstract int V();
    public abstract int E();
    public abstract String toString();
}
