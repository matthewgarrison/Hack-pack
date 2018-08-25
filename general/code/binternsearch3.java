int lo = 0, hi;
while (lo <= hi) {
	int mid = (lo + hi) >> 1;
	if (isValid(mid)) hi = mid - 1;
	else lo = mid + 1;
}