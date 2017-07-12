static int[] data, perms;
static boolean[] used;
static void perms(int position, int len) {
	if (position >= len) {
		// Process the permutation (it's stored in the perms array).
	} else {
		for (int j = 0; j < data.length; j++) {
			if (!used[j]) {
				used[j] = true;
				perms[position] = data[j];
				perms(position+1, len);
				used[j] = false;
			}
		}
	}
}
