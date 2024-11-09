class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        int a=0;
        for(int i=0;i<nums.size();i++){
            a^=nums[i];
        }
        int n=nums.size();
        vector<int>answer;
        for(int i=n-1;-1<=i;i--){
            if(i==-1){
                break;
            }
            int result=0;
            for(int j=0;j<maximumBit;j++){
                if(((1<<j)&a)==0){
                    result|=(1<<j);
                }
            }
            answer.push_back(result);
            a^=nums[i];
        }
        return answer;
    }
};