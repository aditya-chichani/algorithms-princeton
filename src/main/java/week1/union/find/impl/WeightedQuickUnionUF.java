package week1.union.find.impl;

import java.util.Arrays;

public class WeightedQuickUnionUF extends QuickUnionUF {
    public int[] size;

    public WeightedQuickUnionUF() {
    }

    public WeightedQuickUnionUF(int N) {
        super(N);
        size = new int[N];
        Arrays.fill(size, 1);
    }

    @Override
    public void union(int node1, int node2) {
        int root1 = root(node1);
        int root2 = root(node2);
        if (root1 == root2) return;

        if (size[root1] <= size[root2]) {
            id[root1] = root2;
            size[root2] += size[root1];
        } else {
            id[root2] = root1;
            size[root1] += size[root2];
        }
    }
}
