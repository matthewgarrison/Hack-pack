int max = Integer.MIN_VALUE, sum = 0, start = 0, end = 0, i = 0;
for (int j = 0; j < arr.length; j++) {
	sum += arr[j];
	if (sum > max) {
		max = sum;
		start = i;
		end = j;
	} else if (sum < 0) {
		i = j + 1;
		sum = 0;
	}
}