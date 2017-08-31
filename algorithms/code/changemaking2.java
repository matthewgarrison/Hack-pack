static int recur(int cents, int index) {
    if (index >= coins.length) return 0;
    if (cents < 0) return 0;
    if (cents == 0) return 1;
    if (memo[index][cents] != -1) return memo[index][cents];
    
    int val = recur(cents - coins[index], index) + recur(cents, index+1);
    
    return memo[index][cents] = val;
}
