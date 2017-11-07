class DisjointSet {
	int[] parents, ranks;
	
	public DisjointSet(int numNodes) {
		this.parents = new int[numNodes];
		this.ranks = new int[numNodes];
		for (int i = 0; i < numNodes; i++) parents[i] = i;
	}
	
	int findRoot(int idx) {
		if (parents[idx] != idx) parents[idx] = findRoot(parents[idx]);
        return parents[idx];
    }
    
	// Union by rank. Returns false if the union did not occur.
	boolean union(int index1, int index2) {
		int root1 = findRoot(index1);
		int root2 = findRoot(index2);
		if (root1 == root2) return false;
		
		if (ranks[root1] < ranks[root2]) parents[root1] = root2;
		else if (ranks[root1] > ranks[root2]) parents[root2] = root1;
		else { parents[root1] = root2; ranks[root2]++; }
        
        return true;
	}
}