String postfixToInfix(String postfix) {
	ArrayDeque<Expression> stack = new ArrayDeque<>();
	for (String token : postfix.split(" +")) {
		int opIndex = OPERATORS.indexOf(token);
		if (opIndex != -1) {
			Expression one = stack.pollFirst(), two = stack.pollFirst();
			Expression combo = new Expression(two, one, token.charAt(0));
			stack.addFirst(combo);
		} else {
			stack.addFirst(new Expression(token));
		}
	}
	return stack.pollFirst().expression;
}