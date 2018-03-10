TreeMap<Integer, Integer> factors = new TreeMap<>();
for (int i = 2, origNum = num; i*i <= origNum; i++)
	while (num % i == 0) {
		factors.put(i, factors.getOrDefault(i, 0) + 1);
		num /= i;
	}
if (num != 1) factors.put(num, 1);