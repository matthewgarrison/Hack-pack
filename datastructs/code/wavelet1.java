class WaveletTree {
	int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
	// leftCount[i] is the count of numbers "going left" (ie. less than mid)
	// at index i in arr.
	int[] arr, leftCount, rightCount;
	WaveletTree left = null, right = null;
	WaveletTree (int[] arr) {
		this.arr = arr;
		for (int i : arr) {
			low = Math.min(low, i); high = Math.max(high, i);
		}
		leftCount = new int[arr.length + 1];
		rightCount = new int[arr.length + 1];
		int mid = low + (high - low) / 2;
		for (int i = 0; i < arr.length; i++) {
			leftCount[i+1] = leftCount[i];
			rightCount[i+1] = rightCount[i];
			if (arr[i] > mid) rightCount[i+1]++;
			else leftCount[i+1]++;
		}
		if (low == high) return;
		int[] leftArr = new int[leftCount[arr.length]];
        int[] rightArr = new int[rightCount[arr.length]];
		for (int i = 0; i < arr.length; i++) {
			if (rightCount[i] == rightCount[i+1]) leftArr[leftCount[i]] = arr[i];
			else rightArr[rightCount[i]] = arr[i];
		}
		left = new WaveletTree(leftArr); right = new WaveletTree(rightArr);
	}
	// Finds the k-th lowest number in [leftIdx, rightIdx).
	int kthLowest(int k, int leftIdx, int rightIdx){
		if (low == high) return arr[leftIdx + k - 1];
		if (leftCount[rightIdx] - leftCount[leftIdx] >= k) 
			return left.kthLowest(k, leftCount[leftIdx], leftCount[rightIdx]);
		return right.kthLowest(k - leftCount[rightIdx] + 
			 leftCount[leftIdx], rightCount[leftIdx], rightCount[rightIdx]);
	}
	// Counts the number of values on [lo, hi] in indexes [leftIdx, rightIdx).
	int count(int lo, int hi, int leftIdx, int rightIdx){
		if (lo <= low && high <= hi) return rightIdx - leftIdx;
		if (low == high) return 0;
		// All the values are in the left subtree.
		if (hi < right.low) return left.count(lo, hi, leftCount[leftIdx], 
		        leftCount[rightIdx]);
		// All the values are in the right subtree.
		if (left.high < lo) return right.count(lo, hi, rightCount[leftIdx], 
		        rightCount[rightIdx]);
		return left.count(lo, hi, leftCount[leftIdx], leftCount[rightIdx])
				+ right.count(lo, hi, rightCount[leftIdx], rightCount[rightIdx]);
	}
}