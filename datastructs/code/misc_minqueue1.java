class MinQueue<E extends Comparable<E>> {
	ArrayDeque<E> queue = new ArrayDeque<>(), mins = new ArrayDeque<>();
	void addLast(E val) {
		queue.addLast(val);
		while (!mins.isEmpty() && val.compareTo(mins.peekLast()) < 0)
			mins.removeLast();
		mins.addLast(val);
	}
	E pollFirst() {
		E val = queue.pollFirst();
		if (val.compareTo(mins.peekFirst()) == 0) mins.pollFirst();
		return val;
	}
	E min() { return mins.peekFirst(); }
}