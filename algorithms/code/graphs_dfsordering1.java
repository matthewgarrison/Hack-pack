static int idx = -1;
static void dfs_order(Vertex curr) {
	curr.startIdx = ++idx;
	for (Vertex v : curr.children) dfs_order(v);
	curr.endIdx = idx;
}