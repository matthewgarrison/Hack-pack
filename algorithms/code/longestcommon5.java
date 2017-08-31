static HashSet<String> lcs(int[][] memo, char[] a, char[] b, int i, int j) {
	HashSet<String> LCS = new HashSet<>();

	if (i == 0 || j == 0) {
		LCS.add("");
	} else if (a[i - 1] == b[j - 1]) {
		for(String s : lcs(memo, a, b, i - 1, j - 1)) {
			LCS.add(s + a[i - 1]);
		}
	} else {
		if (memo[i - 1][j] >= memo[i][j - 1]) {
			LCS.addAll(lcs(memo, a, b, i - 1, j));
		}
		if (memo[i][j - 1] >= memo[i - 1][j]) {
			LCS.addAll(lcs(memo, a, b, i, j - 1));
		}
	}
	return LCS;
}
