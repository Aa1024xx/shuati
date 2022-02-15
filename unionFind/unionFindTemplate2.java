class UnionFind {
	Map<Integer, Integer> father;
	public UnionFind(int n){
		father = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			father.put(i, i);
		}
	}

	public int find(int x) {
		int root = father.get(x);
		while (root != father.get(root)) {
			root = father.get(root);
		}
		return root;
	}

	public void union(int x, int y) {
		int root_a = find(x);
		int root_b = find(y);
		if (root_a != root_b) {
			father.put(root_a, root_b);
		}
	}
}