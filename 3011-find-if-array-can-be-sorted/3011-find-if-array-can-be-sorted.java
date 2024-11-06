class Solution {
    public int countBit(int number) {
        int count = 0;
        
        while (number != 0) {
            if (number % 2 == 1) {
                count++;
            }
            
            number /= 2;
        }
        
        return count;
    }
    
    public boolean canSortArray(int[] nums) {
        List<int[]> list = new ArrayList<>();
        int[] bits = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            bits[i] = countBit(nums[i]);
        }
        
        int[] a = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && bits[i - 1] != bits[i]) {
                list.add(a);
                a = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
            }
            
            a[0] = Math.min(a[0], nums[i]);
            a[1] = Math.max(a[1], nums[i]);
        }
        
        list.add(a);
        
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1)[0] < list.get(i)[1]) {
                return false;
            }
        }
        
        return true;
    }
}