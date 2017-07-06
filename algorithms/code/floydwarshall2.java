for (int k = 0; k < n; k++) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			// If you’re not using the path array, use this:
			adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
			// Otherwise, use this:
			if (adj[i][j] > adj[i][k] + adj[k][j]){
				adj[i][j] = adj[i][k] + adj[k][j];
				path[i][j] = path[k][j];
			}
		}
	}
}