void paint(long s, long t, int c) { // [s, t)
	int p = get(t);  map.subMap(s, t).clear();
	if (s != Long.MIN_VALUE && map.lowerEntry(s).getValue() != c) 
		map.put(s, c);
	if (t != Long.MAX_VALUE && p != c) map.put(t, p);
}