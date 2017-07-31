class Edge {
	int from, to, cap, flow;
	Edge rev;
	public Edge(int from, int to, int cap) {
		this(from, to, cap, null);
		// Change 0 to cap for undirected edges.
		this.rev = new Edge(to, from, 0, this);
	}
	private Edge(int from, int to, int cap, Edge rev) {
		this.from = from;
		this.to = to;
		this.cap = cap;
		this.rev = rev;
	}
}