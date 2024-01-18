function climbStairs(n: number): number { 
    let dp: number[] = [1, 1];
    
    for (let i = 2; i <= n; i++) {
        dp.push(dp[i - 2] + dp[i - 1])
    }

    return dp[n];
}
