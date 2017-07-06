int[][] result = new int[a.length][b[0].length];
for (int i = 0; i < result.length; i++) {
	for (int j = 0; j < result[0].length; j++) {
		int sum = 0;
		for (int k = 0; k < b.length; k++) {
			sum += a[i][k] * b[k][j];
		}
		result[i][j] = sum;
	}
}