int[][] expo(int[][] matrix, int n) {
    // identity() returns an identity matrix of the given size
	int[][] result = identity(matrix.length);
	while (n > 0) {
		if ((n & 1) != 0) result = multiply(result, matrix);
		n >>= 1;
		matrix = multiply(matrix, matrix);
	}
	return result;
}