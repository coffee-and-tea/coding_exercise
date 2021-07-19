package coffee_and_tea.coding_exercise.algorithms.graphs;

import coffee_and_tea.coding_exercise.data_structure.graph.Graph;

public interface Paths {
    boolean hasPathTo(int v);
    Iterable<Integer> pathTo(int v);
}
