PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
used[0] = true;
pq.addAll(vertexes[0].edges);
int mstWeight = 0, vertexCount = 1;
while (!pq.isEmpty()) {
	Edge current = pq.poll();
	if (used[current.vertex2]) continue;
	mstWeight += current.cost;
	used[current.vertex2] = true;
	vertexCount++;
	pq.addAll(vertexes[current.vertex2].edges);
}