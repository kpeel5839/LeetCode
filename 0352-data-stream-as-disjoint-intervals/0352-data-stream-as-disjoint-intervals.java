class SummaryRanges {
    public int min;
    public int max;
    public boolean[] isExist;
    public boolean isChanged;
    public int[] parent;
    public int count;
    public int[][] intervals;

    public SummaryRanges() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        isExist = new boolean[10000 + 1];
        isChanged = false;
        parent = new int[10000 + 1];
        
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        count = 0;
    }
    
    public void addNum(int value) {
        min = Math.min(min, value);
        max = Math.max(max, value);
        
        if (!isExist[value]) {
            isChanged = true;
            isExist[value] = true;
            
            if (value != 0 && isExist[value - 1]) { // 뒤에 있는 경우            
                union(value - 1, value);
            }
            
            if (value != 10000 && isExist[value + 1]) { // 앞에 있는 경우
                union(value, value + 1); // 또 union
            }
            
            if (value != 0 && value != 10000 && isExist[value - 1] && isExist[value + 1]) { // 양쪽에 있는 경우 -1
                count--;
            } else if ((value != 0 && isExist[value - 1]) || (value != 10000 && isExist[value + 1])) {
                count += 0;
            } else {
                count++;
            }
        }
    }
    
    public int[][] getIntervals() {
        if (isChanged) {
            intervals = new int[count][2];
            int index = 0;                    
            
            for (int i = min; i <= max; i++) {
                if (isExist[i]) {
                    int end = find(i);
                    intervals[index][0] = i;
                    intervals[index++][1] = end;
                    i = end;
                }
            }
            
            isChanged = false; // 다시 isChanged false 로
        }
        
        return intervals;
    }
    
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }    
        
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a > b) {
            parent[b] = a;
        } else {
            parent[a] = b;   
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */