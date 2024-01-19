function isOutOfRanage(x: number, range) {
    return x < 0 || x >= range;
}

function minFallingPathSum(matrix: number[][]): number {
    const dx = [-1, 0, 1];
    let dp = [];
    
    for (let i = 0; i < matrix.length; i++) {
        dp.push([]);
        dp[0].push(matrix[0][i]);
    }

    for (let i = 1; i < matrix.length; i++) {
        dp.push([]);

        for (let j = 0; j < matrix[i].length; j++) {
            let minimumValue = Number.MAX_VALUE;
            for (let dir = 0; dir < 3; dir++) {
                const nx = j + dx[dir];

                if (isOutOfRanage(nx, matrix[i].length)) {
                    continue;
                }

                minimumValue = Math.min(minimumValue, dp[i - 1][nx]);
            }
            dp[i].push(minimumValue + matrix[i][j]);
        }
    }
    
    let min = Number.MAX_VALUE;
    for (let i = 0; i < matrix[0].length; i++) {
        min = Math.min(min, dp[matrix.length - 1][i]);
    }
    return min;
}
