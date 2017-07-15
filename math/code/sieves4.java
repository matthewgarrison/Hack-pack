int[] modInverse = new int[n+1];
modInverse[1] = 1;
for (int i = 2; i <= n; i++) 
    modInverse[i] = ( -(m/i) * modInverse[m % i] ) % m + m;