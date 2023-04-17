class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();    
        List<Boolean> ans = new ArrayList<>();
        Arrays.stream(candies).forEach(v -> ans.add(max <= v + extraCandies));
        return ans;
    }
}