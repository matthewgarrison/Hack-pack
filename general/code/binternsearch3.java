static double binarySearch(double key) {
	double lo = 0, hi = Math.PI;
	for (int i = 0; i < 100; i++) {
		double mid = lo + (hi - lo)/2.0;
		double ans = formula(mid);
		if (equals(ans, key)) return mid;
		else if (ans > key) hi = mid;
		else lo = mid;
	}
	return -1;
}