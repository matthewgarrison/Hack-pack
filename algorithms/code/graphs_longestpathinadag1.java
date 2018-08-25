ArrayList<Vertex> topoSort = getTopoSort(vertexes);
topoSort.get(0).dist = 0;
for (Vertex v : topoSort) {
	// We check the parents of v, since that's where we came from.
	for (Edge e : v.in) {
		v.dist = Math.max(v.dist, e.cost + e.from.dist);
	}
}