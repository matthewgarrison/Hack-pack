int[] totients = new int[n+1];
for (int i = 0; i <= n; i++) totients[i] = i;
for (int i = 1; i <= n; i++) 
	if (!isComposite[i]) 
		for (int j = i; j <= n; j += i)
		    totients[j] -= totients[j] / i;