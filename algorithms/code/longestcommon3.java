int i = a.length, j = b.length;
String LCS = "";
while(i > 0 && j > 0) {
	if (a[i-1] == b[j-1]) {
		LCS = a[i-1] + LCS;
		i--; j--;
	}
	else if (memo[i-1][j] >= memo[i][j-1]) i--;
	else j--;
}
