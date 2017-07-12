double low = 0, high = Math.PI;
for (int i = 0; i < 100; i++) {
	double lowThird = ((2 * low) + high) / 3;
	double highThird = (low + (2 * high)) / 3;
	if (calc(lowThird) > calc(highThird)) low = lowThird;
	else high = highThird;
}