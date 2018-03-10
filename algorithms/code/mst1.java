DisjointSet djset = new DisjointSet(numNodes);
int edgeCount = 0, mstWeight = 0;
Arrays.sort(edges);
for (int i = 0; i < edges.size() && edgeCount < numNodes - 1; i++) {
	if (djset.union(edges[i].vertex1, edges[i].vertex2)) {
		edgeCount++;
		mstWeight += edges.get(i).cost;
	}
}
if (edgeCount != numNodes-1) { /* Graph is not connected */ }