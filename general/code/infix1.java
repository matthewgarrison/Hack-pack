final String OPERATORS = "-+/*^";
String convert(String infix) {
	StringBuilder output = new StringBuilder();
	ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	for (String token : infix.split(" +")) {
		char c = token.charAt(0);
		int opIndex = OPERATORS.indexOf(c);
		// Check if it is an operator.
		if (opIndex != -1) {
			if (stack.isEmpty()) {
				stack.addFirst(opIndex);
			} else {
				// While the operator on the stack has higher precedence than the
				// current operator, add the operator on the stack to the output.
				while (!stack.isEmpty()) {
					int prec1 = opIndex / 2, prec2 = stack.peekFirst() / 2;
					if (prec2 > prec1 || (prec2 == prec1 && c != '^')) { 
                        output.append(operators.charAt(stack.pollFirst())).
                                append(' ');
					} else break;
				}
				stack.addFirst(opIndex);
			}
		} else if (c == '(') {
			// -2 represents a '('.
			stack.addFirst(-2);
		} else if (c == ')') {
			// Add operators to the output string until you reach a '(' on 
			// the stack.
			int n;
			while ((n = stack.pollFirst()) != -2)
				output.append(operators.charAt(n)).append(' ');
		} else {
			// Add the number to the output string.
			output.append(token).append(' ');
		}
	}
	// Add any remaining operators on the stack to the output string.
	while (!stack.isEmpty()) {
        output.append(operators.charAt(stack.pollFirst())).append(' ');
	}
	// Remove trailing spaces and return it.
	return output.deleteCharAt(output.length()-1).toString();
}
