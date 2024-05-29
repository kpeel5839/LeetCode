class Solution {
public:
    int specialArray(vector<int>& nums) {
        int n=nums.size();
        int answer=-1;
        for(int i=0;i<=1000;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i<=nums[j]){
                    cnt++;
                }
            }
            if(cnt==i){
                answer=i;
            }
        }
        return answer;
    }
};