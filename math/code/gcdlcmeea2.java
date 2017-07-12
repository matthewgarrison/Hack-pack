static int gcd(int a, int b) {
	if (a < b) return gcd(b, a);
	while (b != 0) {
		int temp = b;
		b = a % b;
		a = temp;
	}
	return a;
}