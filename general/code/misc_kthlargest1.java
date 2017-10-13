static int quickSelect(int[] arr, int left, int right, int k) {
	if (left == right) return arr[left];
	int pivotIdx = left + (int)(Math.random() % (right - left + 1));
	pivotIdx = partition(arr, left, right, pivotIdx);
	if (k == pivotIdx) return arr[k];
	else if (k < pivotIdx) return quickSelect(arr, left, pivotIdx-1, k);
	else return quickSelect(arr, pivotIdx+1, right, k);
}
static int partition(int[] arr, int left, int right, int pivotIdx) {
	int pivotVal = arr[pivotIdx];
	swap(arr, pivotIdx, right);
	int storeIdx = left;
	for (int i = left; i < right; i++) {
		if (arr[i] < pivotVal) {
			swap(arr, storeIdx++, i);
		}
	}
	swap(arr, right, storeIdx);
	return storeIdx;
}