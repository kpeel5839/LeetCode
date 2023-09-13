class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        int ans = 0;
        int value = 1;
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            boolean left = (i == 0) ? true : ratings[i - 1] >= ratings[i];
            boolean right = (i == n - 1) ? true : ratings[i + 1] >= ratings[i];
            ans += value;
            arr[i] = value;

            if (left && right) {
                ans += ((i - index + 1) * (1 - value));
                arr[i] = 1;

                if (0 <= index - 1 && ratings[index] < ratings[index - 1] && arr[index - 1] < (i - index + 2)) {
                    ans += (i - index + 2) - arr[index - 1];
                }

                index = i + 1;
                
                if (i != n - 1 && ratings[i] < ratings[i + 1]) {
                    value = 2;
                } else {
                    value = 1;
                }
            } else if (i != n - 1 && ratings[i] < ratings[i + 1]) { 
                value++;
                index = i + 1;
            } else {
                if (value <= 1) {
                    value--;
                } else {
                    value = 1;
                    index = i + 1;
                }
            }
        }

        return ans;
    }
}