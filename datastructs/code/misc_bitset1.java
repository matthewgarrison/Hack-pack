static BitSet shiftLeft(BitSet bs, int amt) {
    long[] tmp = bs.toLongArray();
    long[] arr = new long[(bs.length() + amt + 63) / 64];
    int a = amt / 64, b = amt % 64, c = 64 - b;
    for(int i = 0; i < tmp.length; i++) {
        if (i + a < arr.length) arr[i + a] |= tmp[i] << b;
        if (i + a + 1 < arr.length && c != 64) arr[i + a + 1] |= tmp[i] >>> c;
    }
    return BitSet.valueOf(arr);
}