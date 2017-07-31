static int numVertexes, source, sink;
static Vertex[] vertexes;
static int[] dist;
static boolean[] blocked;
static ArrayDeque<Integer> queue;
static void createGraph(int n) {
	// You can remove or change these two lines if you want source and sink to
	// be different vertexes.
	source = n++;
	sink = n++;
	numVertexes = n;
	vertexes = new Vertex[n];
	for (int i = 0; i < n; i++) vertexes[i] = new Vertex(i);
	dist = new int[n];
	blocked = new boolean[n];
	queue = new ArrayDeque<>();
}
static void addEdge(int v1, int v2, int cap) {
	Edge e = new Edge(v1, v2, cap);
	vertexes[v1].edges.add(e);
	vertexes[v2].edges.add(e.rev);
}
// Only necessary if you are running Dinic's on the same graph multiple times.
static void clear() {
	for (Vertex v : vertexes)
        for (Edge e : v.edges) e.flow = 0;
}
static int dinics() {
	clear();
	int flow = 0;
	while (bfs()) {
		Arrays.fill(blocked, false);
		flow += dfs(source, Integer.MAX_VALUE);
	}
	return flow;
}
static boolean bfs() {
	Arrays.fill(dist, -1);
	dist[source] = 0;
	queue.clear();
	queue.add(source);
	while (!queue.isEmpty()) {
		int curr = queue.poll();
		for (Edge e : vertexes[curr].edges) {
			int v = e.to;
			if (dist[v] == -1 && e.flow < e.cap) {
				dist[v] = dist[curr] + 1;
				queue.add(v);
			}
		}
	}
	// Returns whether we made it to the source from the sink.
	return (dist[sink] > 0);
}
static int dfs(int curr, int min) {
	// The min parameter refers to the minimum residual capacity encountered 
	// further up our call stack.
	if (curr == sink) return min;
	
	int flow = 0;
	for (Edge e : vertexes[curr].edges) {
		int v = e.to;
		// Check to make sure the path is not blocked and that this is a valid 
		// path according to our level graph.
		if (!blocked[v] && dist[v] == dist[curr] + 1 && e.cap > e.flow) {
			// Assign as much flow as we can still fit along this path.
			int push = dfs(v, Math.min(min - flow, e.cap - e.flow));
			flow += push;
			e.flow += push;
			e.rev.flow -= push;
		}
		// We can stop if we can't push any more flow.
		if (flow == min) return flow;
	}
	/*
	If what we pushed, that is, what was available further down the path, is 
	not equal to what was available up our call stack, that means we filled up
	a bottleneck along this path, so we can just mark it as blocked. This 
	means speed-ups in the event that we go down this path again if we end up 
	backtracking and trying a different route.
	*/
	blocked[curr] = (flow != min);
	return flow;
}
static void removeEdge(int v1, int v2) {
	Edge e;
	for (int i = 0; i < vertexes[v1].edges.size(); i++) {
		e = vertexes[v1].edges.get(i);
		if (e.to == v2 && e.cap != 0) vertexes[v1].edges.remove(i--);
	}
	for (int i = 0; i < vertexes[v2].edges.size(); i++) {
		e = vertexes[v2].edges.get(i);
		if (e.to == v1 && e.cap == 0) vertexes[v2].edges.remove(i--);
	}
}
