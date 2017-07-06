PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
// We can start from any node, so starting from the first node is simplest.
used[0] = true;
pq.addAll(vertexes[0].edges);
// If a single MST is not guaranteed to exist, vertexCount is required to tell 
// if a single MST exists for this graph.
int mstWeight = 0, vertexCount = 1;
	
while (!pq.isEmpty()) {
	Edge current = pq.poll();
	
	if (used[current.vertex2]) continue;
		
	mstWeight += current.cost;
	used[current.vertex2] = true;
	vertexCount++;
	pq.addAll(vertexes[current.vertex2].edges);
}