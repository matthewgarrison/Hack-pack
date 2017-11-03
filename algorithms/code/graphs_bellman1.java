boolean flag = false; // true if a distance was updated in the inner loop
for (int i = 0; i < numVertexes; i++) {
    flag = false;
    for (Edge e : edges) {
        if (vertexes[e.to].dist > vertexes[e.from] + e.cost) {
            vertexes[e.to].dist = vertexes[e.from] + e.cost;
            flag = true;
        }
    }
    if (!flag) break;
}
if (flag) System.out.println("Negative cycle: PANIC");