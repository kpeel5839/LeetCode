class Solution {
public:
    typedef vector<int>vi;
    typedef vector<bool>vb;
    typedef vector<int>vii;
    vector<bool> isArraySpecial(vector<int>& nums, vector<vector<int>>& queries) {
        int n=nums.size();
        vi sum(n,0);
        for(int i=1;i<n;i++){
            if(nums[i]%2==nums[i-1]%2){
                sum[i]++;
            }
            sum[i]+=sum[i-1];
        }
        vb answer;
        for(int i=0;i<queries.size();i++){
            int a=queries[i][0];
            int b=queries[i][1];
            int result=0;
            result=sum[b]-sum[a];
            answer.push_back(!(result>0));
        }
        return answer;
    }
};