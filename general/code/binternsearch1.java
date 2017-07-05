static int binarySearch(int[] arr, int key) {
	int lo = 0, hi = arr.length-1;
	while (lo <= hi) {
		int mid = lo + (hi - lo)/2;
		if (arr[mid] == key) return mid;
		else if (arr[mid] > key) hi = mid - 1;
		else lo = mid + 1;
	}
	return -1;
}