function findWinners(matches: number[][]): number[][] {
    const size: number = 100000
    let answer: Array<number[]> = new Array<number[]>()
    let count: Array<number[]> = new Array<number[]>()
    answer.push([])
    answer.push([])

    for (let i = 0; i <= size; i++) {
        count.push([])
        count[i].push(0);
        count[i].push(0);
    }

    for (let i = 0; i < matches.length; i++) {
        count[matches[i][0]][0]++;
        count[matches[i][1]][1]++;
    }

    for (let i = 0; i <= size; i++) {
        if (count[i][0] == 0 && count[i][1] == 0) {
            continue;
        }

        if (count[i][1] == 0) {
            answer[0].push(i);
        }

        if (count[i][1] == 1) {
            answer[1].push(i);
        }
    }

    return answer;
};
