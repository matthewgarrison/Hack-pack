int maxLength = 1, maxEnd = 1, start = 0, end = 1;
for (; end < arr.length; end++) {
	// The current substring is no longer increasing.
	if (arr[end] <= arr[end-1]) {
		if (end - start > maxLength) {
			maxLength = end - start;
			maxEnd = end - 1;
		}
		start = end;
	}
}
if (end - start > maxLength) {
	maxLength = end - start; maxEnd = end - 1;
}

