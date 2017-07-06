int sourceIndex = scan.nextInt();
vertexes[sourceIndex].distanceFromSource = 0;
PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
pq.add(vertexes[sourceIndex]);

while (!pq.isEmpty()) {
	Vertex curr = pq.poll();
	
    // If there's a single known destination index, you can use a break 
    // statement here.

	curr.visited = true;
	for (int i : curr.neighbors) {
		if (vertexes[i].visited) continue;
		
		int newDistance = curr.distanceFromSource + distances[curr.index][i];
			
		if(newDistance < vertexes[i].distanceFromSource){
			pq.remove(vertexes[i]);
			vertexes[i].distanceFromSource = newDistance;
			pq.add(vertexes[i]);
			vertexes[i].prev = curr.index;
		}
	}
}