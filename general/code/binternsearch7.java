while(lo < hi) {
    int mid = (lo + hi) >> 1;
    if (calc(mid) > calc(mid+1)) hi = mid;
    else lo = mid+1;
}