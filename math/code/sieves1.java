boolean[] isComposite = new boolean[n+1];
isComposite[0] = isComposite[1] = true;
for (int i = 2; i*i <= n; i++) {
	if (!isComposite[i])
        for (int j = i*i; j <= n; j += i) 
			isComposite[j] = true;
}
return isComposite;