int[][] pascals = new int[n+1][];
int[] currentRow = {1};
pascals[0] = currentRow;
for (int i = 1; i <= n; i++) {
	currentRow = new int[i+1];
	currentRow[0] = 1;
	currentRow[i] = 1;
	for (int j = 1; j <= i - 1; j++) {
		currentRow[j] = pascals[i-1][j-1] + pascals[i-1][j];
	}
	pascals[i] = currentRow;
}