class Vector {
	final double x, y, direction, magnitude;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
		this.direction = Math.atan2(y, x);
		this.magnitude = Math.hypot(x, y);
	}

	public Vector(double x1, double y1, double x2, double y2) {
		this(x2 - x1, y2 - y1);
	}

	double crossProduct(Vector v) {
		return this.x * v.y - v.x * this.y;
	}

	double dotProduct(Vector v) {
		return this.x * v.x + this.y * v.y;
	}

	Vector scale(double n) {
		return new Vector(n * this.x, n * this.y);
	}

	Vector add(Vector v) {
		return new Vector(this.x + v.x, this.y + v.y);
	}
}