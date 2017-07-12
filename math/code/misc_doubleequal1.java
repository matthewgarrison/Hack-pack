static double EPSILON = 1E-9;
static boolean equals(double one, double two) {
	// Absolute equality.
	if (Math.abs(one - two) < EPSILON) return true;
	// Relative equality.
	if (Math.abs(one - two) < EPSILON * Math.max(Math.abs(one), 
	        Math.abs(two))) return true;
	return false;
}