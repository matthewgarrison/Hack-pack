static int[] getNextPerm(int[] data, int[] currPerm) {
	int[] nextPerm = Arrays.copyOf(currPerm, data.length);
	
	int firstIdx = -1, secondIdx = -1;
	for (int i = 0; i < data.length - 1; i++) {
		if (currPerm[i] < currPerm[i+1]) firstIdx = i;
		if (currPerm[i+1] > currPerm[firstIdx]) secondIdx = i + 1;
	}
	swap(nextPerm, firstIdx, secondIdx);
	Arrays.sort(nextPerm, firstIdx+1, secondIdx+1);
	
	return nextPerm;
}