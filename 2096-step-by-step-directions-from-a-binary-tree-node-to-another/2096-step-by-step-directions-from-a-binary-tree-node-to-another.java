import java.util.ArrayList;
import java.util.List;

class Solution {
    static final int MAX_SIZE = 100000;
    static final int UP = 0;
    static final int LEFT = 1;
    static final int RIGHT = 2;
    List<List<int[]>> graph;
    List<int[]> track;

    public void makeGraph(TreeNode cur) {
        if (cur == null) {
            return;
        }
        if (cur.left != null) {
            graph.get(cur.val).add(new int[]{cur.left.val, LEFT});
            graph.get(cur.left.val).add(new int[]{cur.val, UP});
            makeGraph(cur.left);
        }
        if (cur.right != null) {
            graph.get(cur.val).add(new int[]{cur.right.val, RIGHT});
            graph.get(cur.right.val).add(new int[]{cur.val, UP});
            makeGraph(cur.right);
        }
    }

    public boolean dfs(int cur, int prev, int destination) {
        if (cur == destination) {
            return true;
        }
        for (int[] next : graph.get(cur)) {
            if (next[0] != prev) {
                track.set(next[0], new int[]{cur, next[1]});
                if (dfs(next[0], cur, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String tracking(int start, int destination) {
        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int cur = destination;
        while (cur != start) {
            int[] a = track.get(cur);
            cur = a[0];
            if (a[1] == UP) {
                temp.append('U');
            } else if (a[1] == LEFT) {
                temp.append('L');
            } else {
                temp.append('R');
            }
        }
        answer.append(temp.reverse());
        return answer.toString();
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        graph = new ArrayList<>(MAX_SIZE + 1);
        for (int i = 0; i <= MAX_SIZE; i++) {
            graph.add(new ArrayList<>());
        }
        track = new ArrayList<>(MAX_SIZE + 1);
        for (int i = 0; i <= MAX_SIZE; i++) {
            track.add(null);
        }
        makeGraph(root);
        dfs(startValue, -1, destValue);
        return tracking(startValue, destValue);
    }
}
