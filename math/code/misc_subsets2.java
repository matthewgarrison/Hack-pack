for (int subset = 0; subset < (1 << n); ) {
	// Do your subset stuff.
	if (k == 0) break;
	subset = (Integer.bitCount(subset)<k ? subset+1 : (subset|(subset-1))+1);
}