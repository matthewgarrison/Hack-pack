double calc(String postfix) {
	ArrayDeque<Double> stack = new ArrayDeque<>();
	for (String token : postfix.split(" +")) {
		int opIndex = OPERATORS.indexOf(token);
		if (opIndex != -1) {
			double one = stack.pollFirst(), two = stack.pollFirst(), newNum;
			if (opIndex == 0) newNum = two - one;
			else if (opIndex == 1) newNum = two + one;
			else if (opIndex == 2) newNum = two / one;
			else if (opIndex == 3) newNum = two * one;
			else newNum = Math.pow(two, one);
			stack.addFirst(newNum);
		} else stack.addFirst(Double.parseDouble(token));
	}
	return stack.pollFirst();
}
