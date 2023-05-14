MOD = 1000000007

class Tree:
    def __init__(self, v):
        self.v = v
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.root = None
        self.ans = 1
        self.f = [0] * 1001

    def insert(self, c, v):
        if c.v < v:
            if c.right is None:
                c.right = Tree(v)
            else:
                self.insert(c.right, v)
        else:
            if c.left is None:
                c.left = Tree(v)
            else:
                self.insert(c.left, v)
                
    def init(self):
        self.f[0] = 1;
        for i in range(1, 1001):
            self.f[i] = i * self.f[i - 1];

    def dfs(self, c):
        a, b = 0, 0

        if c.left is not None:
            a = self.dfs(c.left)

        if c.right is not None:
            b = self.dfs(c.right)
        
        self.ans = (self.ans * (self.f[a + b] // (self.f[a] * self.f[b]))) % MOD
        return a + b + 1

    def numOfWays(self, nums: List[int]) -> int:
        self.root = Tree(nums[0])
        self.init()

        for i in range(1, len(nums)):
            self.insert(self.root, nums[i])

        self.dfs(self.root)

        return int((self.ans - 1) % MOD)