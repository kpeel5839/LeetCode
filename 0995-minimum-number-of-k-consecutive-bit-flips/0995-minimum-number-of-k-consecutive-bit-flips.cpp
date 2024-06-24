class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        int cnt=0;
        int n=nums.size();
        vector<int>diff(n+1,0);
        int answer=0;
        for(int i=0;i<n;i++){
            cnt+=diff[i];
            if((nums[i]+cnt)%2!=1){
                cnt++;
                answer++;
                if(i+k<=n){
                    diff[i+k]--;
                }else{
                    return -1;
                }
            }
        }
        return answer;
    }
};