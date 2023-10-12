/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    public MountainArray arr;
    public int n;
    public int target;

    public int findMountain() {
        int l = 0;
        int r = n - 1;
        int ans = -1;

        while (l <= r) {
            int m = (l + r) / 2;
            int b = arr.get(m);
            int a = m == 0 ? Integer.MIN_VALUE : arr.get(m - 1);
            int c = m == n - 1 ? Integer.MIN_VALUE : arr.get(m + 1);
            
            if (a < b && c < b) {
                return m;
            }

            if (a < b && b < c) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }

    public int leftSearch(int findIndex) {
        int l = 0;
        int r = findIndex - 1; 

        while (l <= r) {
            int m = (l + r) / 2;
            int value = arr.get(m);
            
            if (value < target) {
                l = m + 1;
            } else if (value == target) {
                return m;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public int rightSearch(int findIndex) {
        int l = findIndex + 1;
        int r = n - 1; 

        while (l <= r) {
            int m = (l + r) / 2;
            int value = arr.get(m);
            
            if (value < target) {
                r = m - 1;
            } else if (value == target) {
                return m;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.arr = mountainArr;
        this.n = arr.length();
        this.target = target;
        int index = findMountain();

        if (arr.get(index) == target) {
            return index;
        }
        
        int a = leftSearch(index);
        int b = rightSearch(index);
        
        if (a != -1) {
            return a;
        }

        return b;
    }
}