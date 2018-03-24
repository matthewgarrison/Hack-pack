class Vector implements Comparable<Vector> {
	final double x, y, z, magnitude;
	private double theta = 420; // 420 is impossible sentinel value.
	public Vector(double x, double y, double z) {
		this.x = x;  this.y = y;  this.z = z;
		this.magnitude = Math.sqrt(this.dotProduct(this));
	}
	// atan2 is expensive, so we only define theta when we need to.
	double theta() {
		if (theta == 420) {
			this.theta = Math.atan2(y, x);
			if (this.theta < 0) theta += 2 * Math.PI;
		}
		return this.theta;
	}
	Vector normalize() {
		return new Vector(this.x / this.magnitude, this.y / this.magnitude, 
		        this.z / this.magnitude);
	}
	double dotProduct(Vector v) {
		return (this.x * v.x) + (this.y * v.y) + (this.z * v.z);
	}
	Vector crossProduct(Vector v) {
		double newX = this.y * v.z - this.z * v.y;
		double newY = this.z * v.x - this.x * v.z;
		double newZ = this.x * v.y - this.y * v.x;
		return new Vector(newX, newY, newZ);
	}
	// Determinate of two 2D vectors is the Z parameter of their cross-product.
	double det(Vector v) { return this.x * v.y - this.y * v.x; }
    // Generally, you'll want to precompute sin and cosine, because they're slow.
	Vector rotate(double theta) {
		return new Vector(x * Math.cos(theta) - y * Math.sin(theta), 
				x * Math.sin(theta) + y * Math.cos(theta), z);
	}
	// Returns this vector rotated 90 degrees clockwise.
    public Vector rotate90CW() { return new Vector(y, -x, z); }
    // Returns this vector rotated 90 degrees counter-clockwise.
    public Vector rotate90CCW() { return new Vector(-y, x, z); }
	double angleTo(Vector v) {
		double theta = Math.atan2(this.crossProduct(v).magnitude, this.dotProduct(v));
		if (theta < 0) theta += 2 * Math.PI;
		return theta;
	}
	// Sorts the vectors radially, without having to compute the angles. Useful 
	// problems where using the angles is too imprecise, so we just store x and 
	// as longs.
	public int compareTo(Vector v) {
		int res = 0;
		if (this.x < 0) res += (this.y >= 0 ? 1 : 2);
		else if (this.y < 0) res += 3;
		if (v.x < 0) res -= (v.y >= 0 ? 1 : 2);
		else if (v.y < 0) res -= 3;
		if (res == 0) return -(int)Math.signum(this.det(v));
		return res;
	}
	// Radially compares, but goes "across" the positive x-axis. (If it returns 
	// 0, make sure to check if p is in the same or opposite direction of this 
	// vector.)
	int radialCompareTo(Vector v) { return (int)Math.signum(this.det(v)); }
}