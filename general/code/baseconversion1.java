static String baseString = "02468ACE";
static int convertToBaseTen(String input, int radix) {
	int sum = 0, pow = 1;
	for (int i = input.length()-1; i>=0; i--, pow *= radix) {
		sum += pow * baseString.indexOf(input.charAt(i));
	}
	return sum;
}