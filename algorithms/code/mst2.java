PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
used[0] = true;
pq.addAll(vertexes[0].edges);
int mstWeight = 0, vertexCount = 1;
while (!pq.isEmpty()) {
	Edge curr = pq.poll();
	if (used[curr.v1] && used[curr.v2]) continue;
	int unusedVert = (used[curr.v1] ? curr.v2 : curr.v1);
	mst.add(curr.idx);
	used[unusedVert] = true;
	pq.addAll(verts[unusedVert].edges);
	mstWeight += curr.cost;
	vertexCount++;
}
if (vertexCount != numNodes) { /* Graph is not connected */ }