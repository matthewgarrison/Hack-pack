int[] memo = new int[numCents+1];
memo[0] = 1;
for (int c = 0; c < numCoins; c++)
	for (int v = 0; v <= numCents; v++) {
		int tempIndex = v - coins[c];
		if (tempIndex >= 0) memo[v] += memo[tempIndex];
	}
