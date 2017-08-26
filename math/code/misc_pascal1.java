int[][] pascals = new int[n+1][];
pascals[0] = new int[]{1};
for (int i = 1; i <= n; i++) {
	pascals[i] = new int[i+1];
	pascals[i][0] = 1;
	pascals[i][i] = 1;
	for (int j = 1; j <= i - 1; j++) 
		pascals[i][j] = pascals[i-1][j-1] + pascals[i-1][j];
}