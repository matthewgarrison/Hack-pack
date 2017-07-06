// The sum of all the negative numbers in the set is the offset.
int length = target - negativeSum;
boolean memo[][] = new boolean[numNums+1][length+1];
for (int i = 0; i <= numNums; i++) memo[i][0] = true;
for (int n = 1; n <= numNums; n++) {
	for (int i = 0; i <= length; i++) {
		int withOffset = nums[n] - negativeSum;
		memo[n][i] = memo[n-1][i];
		if (i >= withOffset) memo[n][i] |= memo[n-1][i - withOffset];
	}
}