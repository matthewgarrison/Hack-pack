long findTrailingZeros(long  n){
	long count = 0;
	for (int i = 5; n/i >= 1; i *= 5) count += n/i;
	return count;
}