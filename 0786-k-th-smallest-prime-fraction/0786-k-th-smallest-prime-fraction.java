class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<double[]>pq=new PriorityQueue<>((o1,o2)->Double.compare(o1[2],o2[2]));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                pq.add(new double[]{(double)i,(double)j,(double)arr[i]/arr[j]});
            }
        }
        int cnt=0;
        while(cnt<k){
            cnt++;
            double[] v=pq.poll();
            if(cnt==k){
                return new int[]{arr[(int)v[0]],arr[(int)v[1]]};
            }
        }
        return new int[]{-1,-1};
    }
}