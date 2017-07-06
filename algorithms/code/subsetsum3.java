boolean[] willUse = new boolean[numNums+1];
for (int n = numNums, t = target; n > 0; n--) {
    if (isUsed[n][t]) { 
        t -= nums[n];
        willUse[n] = true;
    }
}