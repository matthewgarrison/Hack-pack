static int[] getNextPerm(int[] data, int[] currPerm) {
	int[] nextPerm = Arrays.copyOf(currPerm, data.length);
	
	int first = -1, second = -1;
	for (int i = 0; i < data.length - 1; i++) {
		if (currPerm[i] < currPerm[i+1]) first = i;
		if (currPerm[i+1] > currPerm[first]) second = i + 1;
	}
	swap(nextPerm, first, second);
	Arrays.sort(nextPerm, first+1, second+1);
	
	return nextPerm;
}