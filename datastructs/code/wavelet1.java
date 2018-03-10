class WaveletTree {
	int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	int[] arr, leftCount, rightCount;
	WaveletTree left = null, right = null;
	public WaveletTree(int[] arr) {
		this.arr = arr;
		for (int i : arr) {	min = Math.min(min, i);  max = Math.max(max, i); }
		leftCount = new int[arr.length + 1];  rightCount = new int[arr.length + 1];
		int mid = min + (max - min) / 2;
		for (int i = 0; i < arr.length; i++) {
			leftCount[i+1] = leftCount[i];  rightCount[i+1] = rightCount[i];
			if (arr[i] > mid) rightCount[i+1]++;
			else leftCount[i+1]++;
		}
		if (min == max) return;
		int[] leftArr = new int[leftCount[arr.length]];
		int[] rightArr = new int[rightCount[arr.length]];
		for (int i = 0; i < arr.length; i++) {
			if (rightCount[i] == rightCount[i+1]) leftArr[leftCount[i]] = arr[i];
			else rightArr[rightCount[i]] = arr[i];
		}
		left = new WaveletTree(leftArr); right = new WaveletTree(rightArr);
	}
	// Counts the number of values on [lo, hi] in indexes [leftIdx, rightIdx).
	int count(int lo, int hi, int leftIdx, int rightIdx) {
		if (lo <= min && max <= hi) return rightIdx - leftIdx;
		if (min == max || leftIdx >= rightIdx) return 0;
		// All the values are in the left subtree.
		if (hi < right.min) return left.count(lo, hi, leftCount[leftIdx], 
		        leftCount[rightIdx]);
		// All the values are in the right subtree.
		if (left.max < lo) return right.count(lo, hi, rightCount[leftIdx], 
		        rightCount[rightIdx]);
		return left.count(lo, hi, leftCount[leftIdx], leftCount[rightIdx])
				+ right.count(lo, hi, rightCount[leftIdx], rightCount[rightIdx]);
	}
	// Finds the k-th lowest number in [leftIdx, rightIdx), where k is 1-indexed.
	int kthLowest(int k, int leftIdx, int rightIdx){
		if (min == max) return arr[leftIdx + k - 1];
		if (leftCount[rightIdx] - leftCount[leftIdx] >= k) 
			return left.kthLowest(k, leftCount[leftIdx], leftCount[rightIdx]);
		return right.kthLowest(k - leftCount[rightIdx] + 
				leftCount[leftIdx], rightCount[leftIdx], rightCount[rightIdx]);
	}
}