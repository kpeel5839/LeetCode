class Solution {
    public int MOD = 1_000_000_007;
    public Tree root;
    public long ans = 1;
    public long[] f = new long[1001];

    public class Tree {
        int v;
        Tree left;
        Tree right;

        public Tree(int v) {
            this.v = v;
        }
    }
    
    public void init() {
        f[0] = 1;
        for (int i = 1; i < 1001; i++) {
            f[i] = (i * f[i - 1]) % MOD;
        }
    }

    public void insert(Tree c, int v) {
        if (c.v < v) {
            if (c.right == null) {
                c.right = new Tree(v);
            } else {
                insert(c.right, v);
            }
        } else {
            if (c.left == null) {
                c.left = new Tree(v);
            } else {
                insert(c.left, v);
            }
        }
    }

    public int dfs(Tree c) {
        int a = 0;
        int b = 0;

        if (c.left != null) {
            a = dfs(c.left);
        }

        if (c.right != null) {
            b = dfs(c.right);
        }
    
        long res = (f[a + b] * modInv(f[a], MOD) % MOD * modInv(f[b], MOD) % MOD) % MOD;
        ans = (ans * res) % MOD;
        return a + b + 1;
    }
    
    private long modInv(long a, int p) {
        long res = 1;
        for (int exp = p - 2; exp > 0; exp >>= 1) {
            if ((exp & 1) == 1) {
                res = (res * a) % p;
            }
            a = (a * a) % p;
        }
        return res;
    }

    public int numOfWays(int[] nums) {
        init();
        root = new Tree(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            insert(root, nums[i]);
        }

        dfs(root);

        return (int) ((ans - 1) % MOD);
    }
}