boolean[][] memo = new boolean[numNums+1][target+1];	
// If the sum is 0, then we know we can make that sum.
for(int i = 0; i <= numNums; i++) memo[i][0] = true;
for (int n = 1; n <= numNums; n++) {
	for (int t = 1; t <= target; t++) {		
		memo[n][t] = memo[n-1][t];
		if (t >= nums[n]) memo[n][t] |= memo[n-1][t - nums[n]];
	}
}