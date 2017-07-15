int[] phi = new int[n+1];
for (int i = 0; i <= n; i++) phi[i] = i;
for (int i = 2; i <= n; i++) 
    // If you don't have a prime sieve, 'if(phi[i] == i)' also works.
	if (!isComposite[i])
		for (int j = i; j <= n; j += i)
		    phi[j] -= phi[j] / i;