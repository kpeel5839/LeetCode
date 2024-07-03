class Solution {
public:
    int minDifference(vector<int>& nums) {
        int n=nums.size();
        if(n<=4){
            return 0; 
        }
        sort(nums.begin(),nums.end());
        int mi=nums[0];
        int ma=nums.back();
        int finalDiff=0;
        int leftPointer=0;
        int rightPointer=n-1;
        for(int i=0;i<8;i++){
            int diff=0;
            int leftPointer=0;
            int rightPointer=n-1; for(int j=0;j<3;j++){
                if((i&(1<<j))!=0){
                    diff+=nums[leftPointer+1]-nums[leftPointer];
                    leftPointer++;
                }else{
                    diff+=nums[rightPointer]-nums[rightPointer-1];
                    rightPointer--;
                }
            }
            finalDiff=max(finalDiff,diff);
        }
        return ma-mi-finalDiff;
    }
};