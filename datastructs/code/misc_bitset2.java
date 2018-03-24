if (i - a >= 0) arr[i - a] |= tmp[i] >>> b;
if (i - a - 1 >= 0 && c != 64) arr[i - a - 1] |= tmp[i] << c;