int mstWeight = 0, vertexCount = 0;
boolean[] used = new boolean[numVertexes];
int[] dist = new int[numVertexes];
Arrays.fill(dist, INFINITY);
dist[0] = 0; // Start with an arbitrary vertex.
for (int i = 0; i < numVertexes; i++) {
	// Find the edge with the smallest weight and who's vertexes aren't
	// already used.
	int curr = 0;
	for (int j = 1; j < numVertexes; j++) 
        if (!used[j] && dist[j] < dist[curr]) curr = j;
	
	if (dist[curr] == INFINITY) break; // We're done.
	
	for (int j = 0; j < numVertexes; j++)
		if (!used[j]) dist[j] = Math.min(dist[j], adj[curr][j]);
	
	vertexCount++;
	mstWeight += dist[curr];
	dist[curr] = INFINITY;
	used[curr] = true;
}