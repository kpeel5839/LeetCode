class Solution {
public:
    typedef vector<int>vi;
    int numberOfSubarrays(vector<int>& nums, int k) {
        int n=nums.size();
        vi oddIndex;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                oddIndex.push_back(i);
            }
        }
        if(oddIndex.size()==0){
            return 0;
        }
        int answer=0;
        int pointer=0;
        for(int i=0;i<n;i++){
            if(pointer!=oddIndex.size()&&oddIndex[pointer]==i){
                pointer++;
            }
            if(k>pointer){
                continue;
            }
            //pointer가 0번째라면 그렇지만, 1번
            if(pointer-k==0){
                answer+=(oddIndex[pointer-k]+1);
            }else{
                answer+=(oddIndex[pointer-k]+1-(oddIndex[pointer-k-1]+1));
            }
        }
        return answer;
    }
};