int lo = 0, hi = arr.length-1, ans = -1;
while (lo <= hi) {
	int mid = lo + (hi - lo)/2;
	if (arr[mid] == key) { ans = mid; break; }
	else if (arr[mid] > key) hi = mid - 1;
	else lo = mid + 1;
}