static int[] findKthPerm(int[] data, int n, int k) {
	int[] indices = new int[n];
	// Find the factoradic representation of k. 
	int divisor = 1;
	for (int place = 1; place <= n; place++) {
		if (k / divisor == 0) break;
		indices[n - place] = (k / divisor) % place;
		divisor *= place;
	}
    // Use it to build the permutation.
	for (int i = 0; i < n; i++) {
		int index = indices[i] + i;
		if(index != i) {
			int temp = data[index];
			for (int j = index; j > i; j--) data[j] = data[j-1];
			data[i] = temp;
		}
	}
	return data;
}