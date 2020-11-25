package week1.union.find.impl;

import week1.union.find.UF;

public class QuickFindUF extends UF {

    public QuickFindUF(int N) {
        super(N);
    }

    @Override
    public void union(int node1, int node2) {
        if (find(node1, node2)) // Already connected
            return;
        // O(N)
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[node2]) id[i] = id[node1];
        }
    }

    @Override
    public int root(int node) {
        // O(1)
        return id[node];
    }
}
