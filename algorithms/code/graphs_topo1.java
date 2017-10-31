ArrayList<Vertex> inputTopoSort;
for (Vertex v : inputTopoSort) {
    v.visited = true;
    for (Vertex next : v.children) {
        if (next.visited) // INVALID TOPO SORT
    }
}