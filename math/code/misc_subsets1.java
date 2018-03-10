for (int subset = (1 << k) - 1; subset < (1 << n); ) {
	// Do your subset stuff.
	if (subset == 0) break;
	int a = subset & -subset, b = subset + a;
	subset = (((subset ^ b) >> 2) / a) | b;
}