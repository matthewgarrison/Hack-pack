static boolean isPerfectSquare(long n) {
    if (0xC840C04048404040L << n >= 0) return false;
    int q = Long.numberOfTrailingZeros(n);
    if ((q & 1) != 0) return false;
    n >>= q;
    if ((n & (7|Long.MIN_VALUE)) != 1) return n == 0;
    long t = (long) Math.sqrt(n);
    return t*t==n;
}