static void solve(int n, String A, String B, String C) {
	if (n == 1) {
		println(A + " -> " + pole3Name);
	} else {
		solve(n - 1, A, C, B);
		println(A + " -> " + C);
		solve(n - 1, B, A, C);
	}
}