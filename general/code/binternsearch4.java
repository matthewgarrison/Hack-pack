int lo = 0, hi = arr.length-1, ans = -1;
while (lo <= hi) {
	int mid = lo + (hi - lo)/2;
	int cmp = arr[mid].compareTo(key);
	if (cmp == 0) return mid;
	else if (cmp > 0) hi = mid - 1;
	else lo = mid + 1;
}