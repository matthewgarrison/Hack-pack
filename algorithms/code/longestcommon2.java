int[][] memo = new int[2][b.length+1];
for (int i = 1; i <= a.length; i++) {
	for (int j = 1; j <= b.length; j++) {
		if (a[i-1] == b[j-1] ) memo[1][j] = memo[0][j-1] + 1;
		else memo[1][j] = Math.max(memo[0][j], memo[1][j-1]);
	}
	// Copies the second row to the first, and then overwrites the second.
	if (i < a.length) {
		memo[0] = memo[1];
		memo[1] = new int[b.length+1];
	}
}
