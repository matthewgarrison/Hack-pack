static int numVertexes, source, sink;
static Vertex[] vertexes;
static int[] dist;
static boolean[] blocked;
static ArrayDeque<Integer> queue;
static void createGraph(int n) {
	// You can remove or change these two lines if you want source and sink to
	// be different vertexes.
	source = n++; sink = n++; numVertexes = n;
	vertexes = new Vertex[n];
	for (int i = 0; i < n; i++) vertexes[i] = new Vertex(i);
	dist = new int[n]; blocked = new boolean[n];
	queue = new ArrayDeque<>();
}
static void addEdge(int v1, int v2, int cap) {
	Edge e = new Edge(v1, v2, cap);
	vertexes[v1].edges.add(e);
	vertexes[v2].edges.add(e.rev);
}
// Only necessary if you are running Dinic's on the same graph multiple times.
static void clear() {
	for (Vertex v : vertexes) for (Edge e : v.edges) e.flow = 0;
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
	dist[sink] = 0;
	queue.clear();
	queue.add(sink);
	while (!queue.isEmpty()) {
		int curr = queue.poll();
		if (curr == source) return true;
		for (Edge e : vertexes[curr].edges) {
			if (dist[e.to] == -1 && e.rev.flow < e.rev.cap) {
				dist[e.to] = dist[curr] + 1;
				queue.add(e.to);
			}
		}
	}
	return (dist[source] > 0); // Did we reach the source?
}
static int dfs(int curr, int min) {
	// min is the minimum residual capacity encountered further up our call stack.
	if (curr == sink) return min;
	
	int flow = 0;
	for (Edge e : vertexes[curr].edges) {
		// Check to make sure the path is not blocked and that this is a 
		// valid path according to our level graph.
		if (!blocked[e.to] && dist[e.to] == dist[curr] - 1 && e.cap > e.flow) {
			// Assign as much flow as we can still fit along this path.
			int push = dfs(e.to, Math.min(min - flow, e.cap - e.flow));
			flow += push;
			e.flow += push;
			e.rev.flow -= push;
		}
		// We can stop if we can't push any more flow.
		if (flow == min) return flow;
	}
    // If what we pushed (ie. what's available further down the path) doesn't 
    // equal min, then we filled a bottleneck along this path, so we can mark 
    // it as blocked. This provides speedups if we go down this path again 
    // because we backtracked and tried a different route. This is basically 
    // memoizing our failures.
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
