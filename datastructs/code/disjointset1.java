class DisjointSet {
	int[] parents, ranks;
	
	public DisjointSet(int numNodes) {
		this.parents = new int[numNodes];
		this.ranks = new int[numNodes];
		for (int i = 0; i < numNodes; i++) parents[i] = i;
	}
	
	int findRoot(int index) {
		if (parents[index] != index) 
			parents[index] = findRoot(parents[index]);
        return parents[index];
    }
	
	// Union by rank. Returns false if the union did not occur.
	boolean union(int index1, int index2) {
		int root1 = findRoot(index1);
		int root2 = findRoot(index2);
		if (root1 == root2) return false;
		
		/*
		We put the tree with the lower rank directly under the root of the 
		other tree. If they have the same rank, we arbitrarily decide to place 
		the first under the second.
		*/
        if (ranks[root1] <= ranks[root2]) parents[root1] = root2;
		else parents[root2] = root1;
		/*
		This is the only thing that differs from the case where the first 
		tree's rank is less than the rank of the second tree.
		*/
		if (ranks[root1] == ranks[root2]) ranks[root2]++;

        return true;
	}
}