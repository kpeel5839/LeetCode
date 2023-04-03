class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);    
        int ans = 0;
        int r = people.length - 1;
        
        for (int i = 0; i < people.length; i++) {
            ans++;
            
            while (i != r && limit < people[i] + people[r]) {
                ans++;
                r--;
            }
            
            r--;
            
            if (r <= i) {
                break;
            }        
        }
        
        return ans;
    }
}