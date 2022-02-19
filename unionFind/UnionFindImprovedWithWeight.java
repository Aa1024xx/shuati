class UnionFindImprovedWithWeight {
	int parent[];
	int size[];
	public UnionFindImprovedWithWeight(int n) {
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		Arrays.fill(size, 1);
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

		if(root_a == root_b) {
			return;
		}

		if (size[root_a] <= size[root_b]) {
			parent[root_a] = root_b;
			size[root_b] += size[root_a];
		} else {
			parent[root_b] = root_a;
			size[root_a] += size[root_b];
		}
	}
}