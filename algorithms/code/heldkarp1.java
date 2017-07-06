static int numCities;	
static int[][] dist, memo;
static int TSP(int pos, int bitmask) {
	The round trip has been completed.
	if (bitmask == (1 << numCities) - 1)
		return dist[pos][0];

	if (memo[pos][bitmask] != -1) return memo[pos][bitmask];

	int answer = Integer.MAX_VALUE;
	for (int i = 0; i <= numCities; i++) {
		int pow = (1 << i);
		if ((bitmask & pow) == 0) {
			answer = Math.min(answer, dist[pos][i] + TSP(i, bitmask | pow));
		}
	}

	memo[pos][bitmask] = answer;
	return answer;
}
