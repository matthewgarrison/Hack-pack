static String lcs(int[][] memo, char[] a, char[] b, int i, int j){
	if (i == 0 || j == 0) return "";
	else if (a[i-1] == b[j-1]) return lcs(memo, a, b, i-1, j-1) + a[i-1];
	else {
		if (memo[i][j-1] > memo[i-1][j]) return lcs(memo, a, b, i, j-1);
		else return lcs(memo, a, b, i-1, j);
	}
}
