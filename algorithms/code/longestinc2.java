int maxLength = 0;
int[] indexOfLastElement = new int[arr.length+1];
int[] previous = new int[arr.length];
for (int i = 0; i < arr.length; i++) {
    // Binary search for the largest positive j <= maxLength such that
    // arr[indexOfLastElement[j]] < arr[i]
	int lo = 1, hi = maxLength;
	while (lo <= hi) {
		int mid = (lo + hi) / 2;
		if (arr[indexOfLastElement[mid]] < arr[i]) lo = mid + 1;
		else hi = mid - 1;
	}
	// Now, lo is 1 greater than the length of the longest prefix of arr[i].
	int newMaxLength = lo;
	// The predecessor of arr[i] is the last index of the subsequence of 
	// length newMaxLength-1.
	previous[i] = indexOfLastElement[newMaxLength-1];
	indexOfLastElement[newMaxLength] = i;
	if (newMaxLength > maxLength) maxLength = newMaxLength;
}
// Reconstruct the LIS.
int[] LDS = new int[maxLength];
int k = indexOfLastElement[maxLength];
for (int i = maxLength-1; i >= 0; i--) {
	LDS[i] = arr[k]; k = previous[k];
}