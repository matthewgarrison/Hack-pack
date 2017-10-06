TreeMap<Integer, Integer> factors = new TreeMap<>();
int origNum = num;
for (int i = 2; i <= origNum; i++) {			
	while (num % i == 0) {
		if (factors.containsKey(i)) factors.put(i, factors.get(i) + 1);
		else factors.put(i, 1);
		num /= i;
	}
	if (num == 1) break;
}