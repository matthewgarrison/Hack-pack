class FastScanner {
	BufferedReader br;
	StringTokenizer st;
	public FastScanner(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
		st = new StringTokenizer("");
	}
	String next() throws IOException {
		while(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	String nextLine() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken("\n");
	}
	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	long nextLong() throws Exception {
		return Long.parseLong(next());
	}
	double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}
}