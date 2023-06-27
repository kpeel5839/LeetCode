class Solution {

    public class Node {
        int l;
        int r;
        int v;
        
        public Node(int l, int r, int[] nums1, int[] nums2) {
            this.l = l;
            this.r = r;
            this.v = nums1[l] + nums2[r];
        }
    }
    
    public class Line {
        int l;
        int r;

        public Line(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public boolean equals(Object o) {
            Line line = (Line) o;
            
            return this.l == line.l && this.r == line.r;
        }

        public int hashCode() {
            return Objects.hash(l, r); 
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        long kk = Math.min(k, (long) nums1.length * (long) nums2.length);
        
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.v - o2.v);
        Set<Line> visited = new HashSet<>();
        q.add(new Node(0, 0, nums1, nums2));
        visited.add(new Line(0, 0));
        int[] dl = {0, 1};
        int[] dr = {1, 0};

        while (kk-- > 0) {
            Node node = q.poll();
            ans.add(List.of(nums1[node.l], nums2[node.r]));
            
            for (int i = 0; i < 2; i++) {
                int l = node.l + dl[i];
                int r = node.r + dr[i];
                
                Line line = new Line(l, r);
                if (nums1.length <= l || nums2.length <= r|| visited.contains(line)) {
                    continue;
                }
                
                visited.add(line);
                q.add(new Node(l, r, nums1, nums2));
            }
        }

        return ans;
    }
}