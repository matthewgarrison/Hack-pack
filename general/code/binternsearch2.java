static int firstSearch(int[] arr, int key) {
	int lo = 0, hi = arr.length-1, firstOccurance = -1;
	while (lo <= hi) {
		int mid = (lo + hi) >> 1;
		if (arr[mid] == key) {
			firstOccurance = mid;
			hi = mid - 1;
		} else if (arr[mid] > key) hi = mid - 1;
		else lo = mid + 1;
	}
	return firstOccurance;
}