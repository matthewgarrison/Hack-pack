int[] ldsLengths = new int[arr.length];
int[] prev = new int[arr.length];

int longestLDS = -1, longestIndex = -1;
for (int i = 0; i < arr.length; i++) {
	int maxLength = -1, maxIndex = -1;
	for (int j = 0; j < i; j++) {
		if (arr[i] < arr[j] && ldsLengths[j] > maxLength) {
			maxLength = ldsLengths[j];
			maxIndex = j;
		}
	}
	if (maxLength > 0) {
		maxLength++;
		ldsLengths[i] = maxLength;
		prev[i] = maxIndex;
		if (maxLength > longestLDS) {
			longestLDS = maxLength;
			longestIndex = i;
		}
	} else {
		ldsLengths[i] = 1;
		prev[i] = -1;
	}
}
int[] LDS = new int[longestLDS];
for (int i = longestLDS-1; i >= 0; i--) {
	LDS[i] = arr[longestIndex];
	longestIndex = prev[longestIndex];
}