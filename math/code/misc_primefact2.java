static int[] sieve(int n) {
	int[] sieve = new int[n+1];
	for (int i = 2; i <= n; i++) sieve[i] = i;
	for (int i = 2; i <= n; i++) 
		if (sieve[i] == i) for (int j = i*2; j <= n; j += i) sieve[j] = i;
	return sieve;
}
static HashSet<Integer> primeFactors(int n) {
	HashSet<Integer> factors = new HashSet<>();
	while (n != 1) {
		factors.add(sieve[n]);
		n /= sieve[n];
	}
	return factors;
}