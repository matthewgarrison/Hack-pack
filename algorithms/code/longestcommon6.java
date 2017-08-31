int[][] memo = new int[2][b.length+1];
int maxLength = 0;
HashSet<Integer> lcsIndexes = new HashSet<Integer>();

for (int i = 1; i <= a.length; i++) {
	for (int j = 1; j <= b.length; j++) {
		if (a[i-1] == b[j-1]) {
			memo[1][j] = memo[0][j-1] + 1;

			if (memo[1][j] > maxLength) {
				maxLength = memo[1][j];
				lcsIndexes.clear();
				lcsIndexes.add(i);
			} else if (memo[1][j] == maxLength) lcsIndexes.add(i);
		}
	}
	// Copies the second row to the first, and then overwrites the second.
	if (i < a.length) {
		memo[0] = memo[1];
		memo[1] = new int[b.length+1];
	}
}
// Prints all the LCS's.
for (int i : lcsIndexes) {
    System.out.println(String.valueOf(a, i-maxLength, maxLength));
}
