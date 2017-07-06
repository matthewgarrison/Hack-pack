int idx = 0, mask = 1;
while (mask != (1 << numCities) - 1) {
	System.out.println(idx);
	idx = path[idx][mask];
	mask |= 1 << idx;
}