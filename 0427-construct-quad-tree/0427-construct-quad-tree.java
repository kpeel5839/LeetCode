/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node dfs(int y, int x, int n, int[][] grid) {
        Node cur = new Node();
        Set<Integer> set = new HashSet<>();
        int value = 0;
        
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                set.add(grid[i][j]);
                value = grid[i][j];
            }
        }
        
        if (set.size() == 1) {
            cur.isLeaf = true;
            cur.val = value == 0 ? false : true;
            return cur;
        } else {
            cur.isLeaf = false;
            cur.val = false;
        }
        
        int divide = n / 2;
        cur.topLeft = dfs(y, x, divide, grid);
        cur.topRight = dfs(y, x + divide, divide, grid);
        cur.bottomLeft = dfs(y + divide, x, divide, grid);
        cur.bottomRight = dfs(y + divide, x + divide, divide, grid);
        return cur;
    }
    
    public Node construct(int[][] grid) {    
        return dfs(0, 0, grid.length, grid);
    }
}