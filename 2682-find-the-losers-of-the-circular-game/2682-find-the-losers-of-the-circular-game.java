class Solution {
    public int[] circularGameLosers(int n, int k) {
        int[] r = new int[n];
        int index = 0;
        int multiple = 1;
        r[0] = 1;
        
        while (true) {
            index = (index + k * multiple++) % n;
            
            if (r[index] == 1) {
                break;
            }
            
            r[index] = 1;
        }
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (r[i] == 0) {
                arr.add(i + 1);
            }
        }
        
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        
        return ans;
    }
}