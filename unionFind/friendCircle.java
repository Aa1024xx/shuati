class UnionFind {
    public int[] parents;
    public int[] rank;
    public int count;
    public UnionFind(int n) {
        parents = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    public int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a == root_b) {
            return;
        }

        if (rank[root_a] < rank[root_b]) {
            parents[root_a] = root_b;
        } else if (rank[root_a] > rank[root_b]) {
            parents[root_b] = root_a;
        } else {
            parents[root_a] = root_b;
            rank[root_b]++;
        }
        count--;
    }
}
public class Solution {
    /**
     * @param M: a matrix
     * @return: the total number of friend circles among all the students
     */

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}