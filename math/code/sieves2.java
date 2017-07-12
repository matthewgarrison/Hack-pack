if (numPrimeFactors[i] == 0)
    for (int j = i*2; j <= upperBound; j += i) 
		numPrimeFactors[j]++;