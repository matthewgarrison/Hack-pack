PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
used[0] = true; // Start with an arbitrary vertex.
pq.addAll(vertexes[0].edges);
// If a single MST is not guaranteed to exist, vertexCount is required to  
// determine is there is a single MST.
int mstWeight = 0, vertexCount = 1;
	
while (!pq.isEmpty()) {
	Edge current = pq.poll();
	if (used[current.vertex2]) continue;
		
	mstWeight += current.cost;
	used[current.vertex2] = true;
	vertexCount++;
	pq.addAll(vertexes[current.vertex2].edges);
}