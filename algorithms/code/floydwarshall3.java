ArrayList<Integer> indexes = new ArrayList<Integer>();
indexes.add(end);
// Loop through each previous vertex until you get back to start.
while (path[start][end] != start) {
	indexes.add(path[start][end]);
	end = path[start][end];
}
indexes.add(start);