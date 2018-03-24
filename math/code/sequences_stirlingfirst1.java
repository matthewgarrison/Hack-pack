int[][] stirling = new int[n+1][k+1];  stirling[0][0] = 1;
for (int y = 1; y <= n; y++)
	for (int x = 1; x <= y && x <= k; x++)
		stirling[y][x] = (y-1)*stirling[y-1][x] + stirling[y-1][x-1];