int dx = Math.abs(x1 - x2), dy = Math.abs(y1 - y2);
if (dx < dy) { int t = dx; dx = dy; dy = t; }
if (dx == 1 && dy == 0) return 3;
if (dx == 2 && dy == 2) return 4;
double delta = dx - dy, divisor = (dy > delta ? 3 : 4);
return (int)(delta - 2 * Math.floor((delta - dy) / divisor));