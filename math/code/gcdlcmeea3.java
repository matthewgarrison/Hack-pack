static void extendedEuclideanAlgorithm(int a, int b) {
	if (a < b) extendedEuclideanAlgorithm(b, a);
	int s = 0, t = 1, r = b;
	int oldS = 1, oldT = 0, oldR = a;
	while (r != 0) {
		int quotient = oldR / r;
		int temp = r;
		r = oldR - (quotient * temp);
		oldR = temp;
		temp = s;
		s = oldS - (quotient * temp);
		oldS = temp;
		temp = t;
		t = oldT - (quotient * temp);
		oldT = temp;
	}
	print("Bezout coefficients: " + oldS + ", " + oldT);
	print("GCD: " + oldR);
	print("Quotients by the GCD: " + t + ", " + s);
}