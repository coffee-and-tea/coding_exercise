package coffee_and_tea.coding_exercise.data_structure.graph;

public interface Edge extends Comparable<Edge> {
    int either();
    int other(int v);
    double getWeight();
}
