static int gcd(int a, int b) {
	if (a < b) return gcd(b, a);
	return ( b == 0 ? a : gcd(b, a%b) );
}
