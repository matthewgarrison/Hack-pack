class Expression {
	String expression;
	int prec;
	public Expression(String s) {
		this.expression = s;
		this.prec = 100;
	}
	public Expression(Expression left, Expression right, char op) {
		this.prec = OPERATORS.indexOf(op) / 2;
		if (left.prec < this.prec || (left.prec == this.prec && op == '^'))
			left.expression = "( " + left.expression +  " )";
		if (right.prec < this.prec || (right.prec == this.prec && op == '^'))
			right.expression = "( " + right.expression +  " )";
		this.expression = left + " " + op + " " + right;
	}
	public String toString() {
		return this.expression;
	}
}