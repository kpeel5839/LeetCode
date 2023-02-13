class Solution {
    public int countOdds(int low, int high) {
        return (int) (Math.ceil((double) high / 2) - Math.floor((double) low / 2));
    }
}