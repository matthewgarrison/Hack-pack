int fastExpo(int x, int n) {
	int result = 1;
	while (n > 0) {
		if ((n & 1) != 0){
			result *= x;
		}
		n >>= 1;
		x *= x;
	}
	return result;
}