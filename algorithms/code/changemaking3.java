int[] memo = new int[numCents+1];
for (int c = 1; c <= numCoins; c++)
	for (int v = 0; v <= numCents; v++) {
		int tempIndex = v - coins[c-1];
		if (tempIndex >= 0) {
			int take = 1 + memo[tempIndex];
			if (take < memo[v] || memo[v] == 0)
				memo[v] = take;
		}
	}