double lo = 0, hi = Math.PI, ans = -1;
for (int i = 0; i < 100; i++) {
	double mid = lo + (hi - lo)/2.0;
	double val = formula(mid);
	if (equals(val, key)) { ans = mid; break; }
	else if (val > key) hi = mid;
	else lo = mid;
}