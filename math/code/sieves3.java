int[] phi = new int[n+1];
for (int i = 0; i <= n; i++) phi[i] = i;
for (int i = 2; i <= n; i++) 
	if (!isComposite[i]) // Alternatively, 'if (phi[i] == i)'
		for (int j = i; j <= n; j += i)
		    phi[j] -= phi[j] / i;