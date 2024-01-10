/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
let maxDepth
let graph: Array<Array<number>>

function makeGraph(cur: TreeNode): void {
    if (!cur) {
        return
    }
    
    if (cur.left) {
        graph[cur.val].push(cur.left.val)
        graph[cur.left.val].push(cur.val)
        makeGraph(cur.left)
    }
    
    if (cur.right) {
        graph[cur.val].push(cur.right.val)
        graph[cur.right.val].push(cur.val)
        makeGraph(cur.right)
    }
}

function dfs(parent: number, current: number, depth: number): number {
    for (let i = 0; i < graph[current].length; i++) {
        if (graph[current][i] === parent) {
            continue
        }
        
        dfs(current, graph[current][i], depth + 1)
    }
    
    return maxDepth = Math.max(maxDepth, depth)
}

function amountOfTime(root: TreeNode | null, start: number): number {
    maxDepth = 0
    graph = new Array<Array<number>>()
    
    for (let i = 0; i < 100_001; i++) {
        graph[i] = new Array<number>(0)
    }
    
    makeGraph(root)
    return dfs(-1, start, 0)
};