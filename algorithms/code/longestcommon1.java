int[][] memo = new int[a.length+1][b.length+1];
for (int i = 1; i <= a.length; i++) {
	for (int j = 1; j <= b.length; j++) {
		if (a[i-1] == b[j-1]) memo[i][j] = memo[i-1][j-1] + 1;
		else memo[i][j] = Math.max(memo[i][j-1], memo[i-1][j]);
	}
}