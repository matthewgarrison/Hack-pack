// NOTE: T(n, k) is stored at mahonian[n-1][k]
long[][] mahonian = new long[n+1][n * n + 2];
mahonian[0][0] = 1;
for (int i = 1, sz = 2; i <= n; sz += i + 1, i++) {
	mahonian[i][0] = 1;
	for (int j = 1; j < sz; j++) {
		mahonian[i][j] = mahonian[i][j - 1] + mahonian[i-1][j];
		if (j > i) mahonian[i][j] -= mahonian[i-1][j - i - 1];
	}
}