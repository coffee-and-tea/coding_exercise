package coffee_and_tea.coding_exercise.data_structure.graph;

import org.jetbrains.annotations.NotNull;

public class EdgeImpl implements Edge{

    private final int v, w;
    private final double weight;

    public EdgeImpl(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int either() {
        return v;
    }

    @Override
    public int other(int vertex) {
        return vertex == v ? w: v;
    }

    @Override
    public int compareTo(@NotNull Edge that) {
        return Double.compare(weight, that.getWeight());
    }
}
