class UnionFindImprovedWithRank {
	int[] parent;
	int[] rank;
	public UnionFindImprovedWithRank(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		Arrays.fill(rank, 1);
	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		} 
		return parent[x] = find(parent[x]);
	}

	public void union(int a, int b) {
		int root_a = find(a);
		int root_b = find(b);

		if (root_a == root_b) {
			return;
		}

		if (rank[root_a] < rank[root_b]) {
			parent[root_a] = root_b;
		} else if (rank[root_a] > rank[root_b]) {
			parent[root_b] = root_a;
		} else { // 只有当rank相同时，才需要维护rank
			parent[root_a] = root_b;
			rank[root_b]++;
		}
	}
}