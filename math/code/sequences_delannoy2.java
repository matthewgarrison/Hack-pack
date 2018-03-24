long res = 1, prev = 1;
for (long c = 1; c <= n; c++) { 
    prev = (prev * (n - c + 2)) / c;  res += prev * prev * (1 << c);
}