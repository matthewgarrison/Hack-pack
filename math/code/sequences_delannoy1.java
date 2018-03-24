long[][] delannoy = new long[n][n];
for (int i = 0; i < n; i++) delannoy[i][0] = delannoy[0][i] = 1;
for (int i = 1; i < n; i++) for (int j = 1; j < n; j++)
    delannoy[i][j] = (delannoy[i-1][j-1] + delannoy[i-1][j] + delannoy[i][j-1]);