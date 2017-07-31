static int[] data, perms;
static boolean[] used;
static void perms(int position, int len) {
	if (position >= len) {
		// Process the permutation (it's stored in the perms array).
	} else {
		for (int i = 0; i < data.length; i++) {
			if (!used[i]) {
				used[i] = true;
				perms[position] = data[i];
				perms(position+1, len);
				used[i] = false;
			}
		}
	}
}
