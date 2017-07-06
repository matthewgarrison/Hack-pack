int[][] arr = new int[height][width];
runSum = new int[height+1][width+1];
for (int y = 0; y < height; y++) {
	for (int x = 0; x < width; x++) {
		arr[y][x] = scan.nextInt();
		runSum[y+1][x+1] = runSum[y+1][x] + arr[y][x];
	}
}
// Add the columns.
for (int x = 0; x < width; x++) {
	for (int y = 0; y < height; y++) {
		runSum[y+1][x+1] += runSum[y][x+1];
	}
}