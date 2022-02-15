public class UnionFind {
	private int[] father = null;

	public UnionFind(int n) {
		father = new int[n];
		for (int i = 0; i < n; i++) {
			father[i] = i;
		}
	}

	public int find(int x) {
		if (father[x] == x) {
			return x;
		}
		// path compression
		return father[x] = find(father[x]); 
		// without compression, it would be return find(father[x])
	}

	public void union(int a, int b) {
		int root_a = find(a);
		int root_b = find(b);
		if (root_a != root_b) {
			father[root_a] = root_b;
		}
	}
}