class FenwickTree {
	int size, ft[];
	public FenwickTree(int n) {
		this.ft = new int[n+1];
		this.size = n;
	}
	public FenwickTree(int[] arr) {
		this(arr.length);
		for (int i = 0; i < arr.length; i++) update(i+1, i+1, arr[i]);
	}
	// Updates the values at the point p.
	void update(int p, int val) {
		for (; p <= size; p += p&(-p)) ft[p] += val; 
	}
	// Updates the values on the range [a, b].
	void update(int a, int b, int val) {
		update(a, val);
		update(b + 1, -val);
	}
	// Queries the value at the point p.
	int query(int p) {
		int sum = 0;
		for (; p > 0; p -= p&(-p)) sum += ft[p];
		return sum;
	}
}
