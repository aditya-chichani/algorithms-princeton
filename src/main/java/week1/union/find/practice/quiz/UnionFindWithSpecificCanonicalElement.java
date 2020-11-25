package week1.union.find.practice.quiz;

import week1.union.find.impl.WeightedQuickUnionWithPathCompressionUF;

public class UnionFindWithSpecificCanonicalElement extends WeightedQuickUnionWithPathCompressionUF {
    int[] max;

    public UnionFindWithSpecificCanonicalElement(int N) {
        super(N);
        max = new int[N];
        System.arraycopy(id, 0, max, 0, N);
    }

    @Override
    public void union(int node1, int node2) {
        int root1 = root(node1);
        int root2 = root(node2);

        if (root1 == root2) return;

        if (size[root1] <= size[root2]) {
            id[root1] = root2;
            size[root2] += size[root1];
            max[root2] = Math.max(max[root1], max[root2]);
        } else {
            id[root2] = root1;
            size[root1] += size[root2];
            max[root1] = Math.max(max[root1], max[root2]);
        }
    }

    public int find(int node) {
        return max[root(node)];
    }

}
