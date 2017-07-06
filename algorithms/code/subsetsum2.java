if (memo[n-1][t]) {
	memo[n][t] = true;
	continue;
}
boolean take = false;
if (t >= nums[n]) take = memo[n-1][t - nums[n]];
if (take) isUsed[n][t] = true;
memo[n][t] = take;