class Solution {
public:
    int minSwaps(vector<int>& nums) {
        int cnt=0;
        int n=nums.size();
        for(int i=0;i<nums.size();i++){
            if(nums[i]==1){
                cnt++;
            }
        }
        if(cnt==n){
            return 0;
        }
        int l=0;
        int r=cnt-1;
        int answer=1e9;
        int newCnt=0;
        for(int i=0;i<=r;i++){
            if(nums[i]==1){
                newCnt++;
            }
        }
        for(int i=0;i<n;i++){
            answer=min(answer,cnt-newCnt);
            r=(r+1)%n;
            newCnt+=nums[r]==1?1:0;
            newCnt-=nums[l]==1?1:0;
            l=(l+1)%n;
        }
        return answer;
    }
};