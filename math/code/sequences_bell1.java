int[][] bell = new int[n+1][];
bell[0] = new int[]{1};
for (int i = 1; i <= n; i++) {
	bell[i] = new int[i+1];
	bell[i][0] = bell[i-1][bell[i-1].length - 1];
	for (int j = 1; j <= i; j++) bell[i][j] = bell[i][j-1] + bell[i-1][j-1];
}