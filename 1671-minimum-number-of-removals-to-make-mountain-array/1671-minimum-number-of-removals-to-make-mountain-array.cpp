class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int minimumMountainRemovals(vector<int>& nums) {
        int n=nums.size();
        vi rightLis(n);
        vi leftLis(n);
        for(int i=0;i<n;i++){
            int ma=0;
            for(int j=0;j<i;j++){
                if(nums[i]<=nums[j]){
                    continue;
                }
                ma=max(ma,rightLis[j]);
            }
            rightLis[i]=ma+1;
        }

        for(int i=n-1;0<=i;i--){
            int ma=0;
            for(int j=n-1;i<j;j--){
                if(nums[i]<=nums[j]){
                    continue;
                }
                ma=max(ma,leftLis[j]);
            }
            leftLis[i]=ma+1;
        }
        
        int answer=1e9;
        for(int i=1;i<n-1;i++){
            int leftCount=i+1-leftLis[i];
            int rightCount=n-i-rightLis[i];
            if(leftLis[i]==1||rightLis[i]==1){
                continue;
            }
            answer=min(answer,leftCount+rightCount);
        }
        return answer;
    }
};