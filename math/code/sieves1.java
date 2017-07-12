boolean[] isComposite = new boolean[n+1];
isComposite[0] = isComposite[1] = true;
int boundary = (int)Math.sqrt(n);
for (int i = 2; i <= boundary; i++) {
	if (!isComposite[i])
        for (int j = i*i; j <= n; j += i) 
			isComposite[j] = true;
}
return isComposite;