int ans = runSum[highY][highX] - runSum[lowY-1][highX] -
        runSum[highY][lowX-1] + runSum[lowY-1][lowX-1];