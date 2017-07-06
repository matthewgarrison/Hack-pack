class Vertex implements Comparable<Vertex> {
    boolean visited;
	int index, distanceFromSource, prev;
	ArrayList<Integer> neighbors;

	public Vertex(int index) {
		this.index = index;
		this.distanceFromSource = INFINITY;
		this.prev = -1;
		this.neighbors = new ArrayList<Integer>();
	}

	void addNeighbor(int index) {
		this.neighbors.add(index);
	}

	public int compareTo(Vertex v) {
		return this.distanceFromSource - v.distanceFromSource;
	}
}
