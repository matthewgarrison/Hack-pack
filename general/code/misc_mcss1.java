int max = Integer.MIN_VALUE, sum = 0;
for (int i = 0; i < arr.length; i++) {
	sum += arr[i];
	max = Math.max(max, sum);
	if (sum < 0) sum = 0;
}