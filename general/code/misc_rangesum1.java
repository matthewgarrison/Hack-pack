int[] arr = new int[length];
int[] runSum = new int[length+1];
for (int i = 0; i < length; i++) {
	arr[i] = scan.nextInt();
	runSum[i+1] = runSum[i] + arr[i];
}