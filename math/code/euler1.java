int result = n;
for (int i = 2; i <= n; i++) if (isPrime(i)) result -= result / i;