class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int p = -2;
        int a = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                a += (i - p - 2) / 2;
                p = i;
            }
        }

        a += (flowerbed.length - p - 1) / 2;
        return n <= a;
    }
}