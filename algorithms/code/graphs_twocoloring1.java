outerLoop : for (int i = 0; i < numVertexes; i++) {
    if (vertexes[i].color != NONE) continue;
    
    ArrayDeque<Vertex> queue = new ArrayDeque<>();
    queue.add(vertexes[i]);
    vertexes[i].color = RED;
    while (!queue.isEmpty()) {
        Vertex curr = queue.poll();
		int otherColor = otherColor(curr.color);
		
		for (Vertex neighbor : curr.neighbors) {
			if (curr.color == neighbor.color) {
				// We're trying to color two neighbors the same color.
				isPossible = false;
				break outerLoop;
			}
			
			if (neighbor.color == NONE) {
				// If it's uncolored, color it and add it to the queue.
			    neighbor.color = otherColor;
				queue.add(neighbor);
			}
		}
    }
}