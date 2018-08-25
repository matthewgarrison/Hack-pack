static int editDistance(String a, String b, int addCost, int delCost, int subCost) {	
	int[][] memo = new int[a.length()+1][b.length()+1];
	for (int i = 0; i <= a.length(); i++) memo[i][0] = i;
	for (int i = 0; i <= b.length(); i++) memo[0][i] = i;
	
	for (int i = 1; i <= a.length(); i++) {
		for (int j = 1; j <= b.length(); j++) {
			if (a.charAt(i-1) == b.charAt(j-1)) memo[i][j] = memo[i-1][j-1];
			else {
				memo[i][j] = min(addCost + memo[i][j-1], delCost + memo[i-1][j], subCost + memo[i-1][j-1]);
			}
		}
	}
	
	return memo[a.length()][b.length()];
}
