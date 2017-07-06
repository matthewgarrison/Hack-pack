class Fraction implements Comparable<Fraction> {
	final int numerator;
	final int denominator;
	public Fraction(int numer, int denom) {	
		// Swap the negatives.
		if (denom < 0) {
			numer *= -1;
			denom *= -1;
		}
		// Reduce the fraction.
		int gcd = gcd(numer, denom);
		numer /= gcd;
		denom /= gcd;

		this.numerator = numer;
		this.denominator = denom;
	}
	Fraction add(Fraction other) {
		return new Fraction((this.numerator * other.denominator) + 
	            (other.numerator * this.denominator), 
                this.denominator * other.denominator);
	}
	Fraction subtract(Fraction other) {
		return new Fraction((this.numerator * other.denominator) - 
                (other.numerator * this.denominator), 
                this.denominator * other.denominator);
	}
	Fraction multiply(Fraction other) {
		return new Fraction(this.numerator * other.numerator,
                this.denominator * other.denominator);
	}
	Fraction divide(Fraction other) {
		return new Fraction(this.numerator * other.denominator, 
                this.denominator * other.numerator);
	}
	int compareTo(Fraction other) {
		return numerator * other.denominator - 
		        other.numerator * this.denominator;
	}
	String toString() {
		return this.numerator + "/" + this.denominator;
	}
	double toDouble() {
		return (double)numerator / denominator;
	}
	
	static int gcd(int a, int b) {
		if (a < b) return gcd(b, a);
		return ( b == 0 ? a : gcd(b, a%b) );
	}
}