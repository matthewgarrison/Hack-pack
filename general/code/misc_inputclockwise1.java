long[] dx = {1, 0, -1, 0};
long[] dy = {0, 1, 0, -1};

String[] distances = br.readLine().split(" ");
Line2D.Double[] paths = new Line2D.Double[distances.length];

long currX = 0;
long currY = 0;
for (int j = 0; j < distances.length; j++) {
	long prevX = currX;
	long prevY = currY;
	currX += dx[j%4] * Long.parseLong(distances[j]);
	currY += dy[j%4] * Long.parseLong(distances[j]);
    paths[j] = new Line2D.Double(prevX, prevY, currX, currY);
}