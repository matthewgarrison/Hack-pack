static boolean isPrime(int n) {	
	if (n <= 1) return false;
	else if (n < 4) return true;
	else if (n % 2 == 0) return false;
	else if (n < 9) return true;
	else if (n % 3 == 0) return false;
	else {
		int boundary = (int)Math.sqrt(n)+1;
        // Only numbers of the form 6k - 1 and 6k + 1 can be prime (but they 
        // are not guaranteed to be prime). 
        for(int i = 6; i <= boundary; i += 6) {
            if (n % (i-1) == 0) return false;
            if (n % (i+1) == 0) return false;
        }
		return true;
	}
}