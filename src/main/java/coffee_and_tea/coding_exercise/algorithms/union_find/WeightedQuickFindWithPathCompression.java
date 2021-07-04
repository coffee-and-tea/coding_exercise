package coffee_and_tea.coding_exercise.algorithms.union_find;

public class WeightedQuickFindWithPathCompression extends WeightedQuickFind {

    @Override
    protected int root(int i) {
        while(graph[i] !=  i) {
            graph[i] = graph[graph[i]];
            i = graph[i];
        }
        return i;
    }

    public static void main(String[] args) {
        WeightedQuickFindWithPathCompression unionFind = new WeightedQuickFindWithPathCompression();

        test(unionFind);
    }
}
