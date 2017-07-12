int[] previousRow;
int[] currentRow = {1};
previousRow = currentRow;
for (int i = 1; i <= n; i++) {
	currentRow = new int[i+1];
	currentRow[0] = 1;
	currentRow[i] = 1;
	for (int j = 1; j <= i - 1; j++) {
		currentRow[j] = previousRow[j-1] + previousRow[j];
	}
	previousRow = currentRow;
}