class SnapshotArray {

    public int snapId = 0;
    public List<Integer> snapTime = new ArrayList<>();
    public List<int[]>[] arr;
    public int count = 0;
    
    public SnapshotArray(int length) {
        arr = new List[length];
        
        for (int i = 0; i < length; i++) {
            arr[i] = new ArrayList<>();
            arr[i].add(new int[] {0, count});
        }
    }
    
    public void set(int index, int val) {
        count++;
        arr[index].add(new int[] {val, count});
    }
    
    public int snap() {
        snapId++;
        snapTime.add(count);
        return snapId - 1;
    }
    
    public int get(int index, int snap_id) {
        int time = snapTime.get(snap_id);
        int left = 0;
        int right = arr[index].size() - 1;
        int ans = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[index].get(mid)[1] <= time) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return arr[index].get(ans)[0]; 
    }
}
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */