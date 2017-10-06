static int fastExpo(int x, int n) {
	if (n == 0) return 1;
	else if (n == 1) return x;
	else if ((n & 1) == 0) return fastExpo(x * x, n >> 1);
	else return x * fastExpo(x * x, n >> 1);
}