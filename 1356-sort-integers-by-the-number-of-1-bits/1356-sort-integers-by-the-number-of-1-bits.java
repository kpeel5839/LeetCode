class Solution {

    public int count(int number) {
        int ans = 0;

        while (number != 0) {
            if (number % 2 == 1) {
                ans++;
            }

            number /= 2;
        }
        
        return ans;
    }

    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[] {count(arr[i]), arr[i]});
        }

        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i)[1];
        }
        
        return ans;
    }
}