class Edge implements Comparable<Edge> {
	int vertex1, vertex2, cost;
	public Edge(int v1, int v2, int c) {
		this.vertex1 = v1;
		this.vertex2 = v2;
		this.cost = c;
	}
	public int compareTo(Edge e) {
		return this.cost - e.cost;
	}
}