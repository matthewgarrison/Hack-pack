ArrayList<Integer> indexes = new ArrayList<Integer>();
indexes.add(end);
while (path[start][end] != start) {
	indexes.add(path[start][end]); 	end = path[start][end];
}
indexes.add(start);