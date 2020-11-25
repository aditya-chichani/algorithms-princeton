package week1.union.find.impl;

public class WeightedQuickUnionWithPathCompressionUF extends WeightedQuickUnionUF {

    public WeightedQuickUnionWithPathCompressionUF(int N) {
        super(N);
    }

    @Override
    public int root(int node) {
        while (id[node] != node) {
            id[node] = id[id[node]];
            node = id[node];
        }
        return node;
    }
}
