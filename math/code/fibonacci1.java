static long fiboMatrix(long n) {
	long[][] fibo = {{1, 1}, {1, 0}};
	// result is initially the 2x2 identity matrix.
	long[][] result = {{1, 0}, {0, 1}};
	while (n > 0) {
		if ((n & 1) == 1) {
			result = multiply(result, fibo);
		}
		n >>= 1;
		fibo = multiply(fibo, fibo);
	}
	return result[1][0];
}