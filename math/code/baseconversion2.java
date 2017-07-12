static String baseString = "02468ACE";
static String convertFromBaseTen(int input, int radix) {
	StringBuilder output = new StringBuilder();
	while (input > 0) {
		int index = input % radix;
		output.insert(0, baseString.charAt(index));
		input /= radix;
	}
	return output.toString();
}
