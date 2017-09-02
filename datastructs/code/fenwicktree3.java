class FenwickTree {
	int size, ft1[], ft2[];
	public FenwickTree(int n) {
		this.ft1 = new int[n+1];
		this.ft2 = new int[n+1];
		this.size = n;
	}
	public FenwickTree(int[] arr) {
	    this(arr.length);
		for (int i = 0; i < arr.length; i++) update(i+1, i+1, arr[i]);
	}
	// Updates the values at the point p.
	void update(boolean isOne, int p, int val) {
		for (; p <= size; p += p&(-p)) {
			if (isOne) ft1[p] += val;
			else ft2[p] += val; 
		}
	}
	// Updates the values on the range [a, b].
	void update(int a, int b, int val) {
		update(true, a, val);
		update(true, b + 1, -val);
		update(false, a, val * (a-1));
		update(false, b + 1, -val * b);
	}
    // Queries the value at the point p.
	int query(boolean isOne, int p) {
		int sum = 0;
		for (; p > 0; p -= p&(-p))
			if (isOne) sum += ft1[p];
			else sum += ft2[p];
		return sum;
	}
	// Queries at point p.
	int query(int p) {
		return query(true, p) * p - query(false, p);
	}
	// Queries the sum of the values on the range [a, b].
	int query(int a, int b) {
		return query(b) - query(a-1);
	}
}
