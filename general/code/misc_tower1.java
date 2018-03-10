static void solve(int n, String A, String B, String C) {
	if (n == 1) {
		System.out.println(A + " -> " + pole3Name);
	} else {
		solve(n - 1, A, C, B);
		System.out.println(A + " -> " + C);
		solve(n - 1, B, A, C);
	}
}