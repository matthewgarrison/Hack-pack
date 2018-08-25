static class SparseTable {
	long[][] logCabin;

	public SparseTable(long[] values) {
		int n = values.length;
		int maxLog = Integer.numberOfTrailingZeros(Integer.highestOneBit(n)) + 2;
		logCabin = new long[maxLog][n];

		for (int i = 0; i < n; i++) logCabin[0][i] = values[i];
		for (int lg = 1, lastRange = 1; lg < maxLog; lg++, lastRange *= 2) {
			for (int i = 0; i < n; i++) {
				logCabin[lg][i] = func(logCabin[lg - 1][i], 
				        logCabin[lg - 1][Math.min(i + lastRange, n - 1)]);
			}
		}
	}

	// [low, hi], for idempotent functions, ie. f(a,a) = a
	long iQuery(int low, int hi) {
		int range = hi - low + 1;
		int exp = Integer.highestOneBit(range);
		int lg = Integer.numberOfTrailingZeros(exp);
		return func(logCabin[lg][low], logCabin[lg][hi - exp + 1]);
	}

	// [low, hi], for non-idempotent functions, ie. f(a,a) != a
	long nQuery(int low, int hi) {
		int range = hi - low + 1;
		int exp = Integer.highestOneBit(range);
		int lg = Integer.numberOfTrailingZeros(exp);
		long ans = logCabin[lg][low];
		for (int i = lg - 1, j = low + (1 << lg); i >= 0; i--) {
			if ((range & (1 << i)) != 0) {
				ans = func(ans, logCabin[i][j]);
				j += (1 << i);
			}
		}
		return ans;
	}
}