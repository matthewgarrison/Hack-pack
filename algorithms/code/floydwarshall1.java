int[][] path = new int[n][n];
for (int i = 0; i < n; i++)
	for (int j = 0; j < n; j++) {
		if (adj[i][j] == INFINITY) path[i][j] = -1;
		else path[i][j] = i;
	}