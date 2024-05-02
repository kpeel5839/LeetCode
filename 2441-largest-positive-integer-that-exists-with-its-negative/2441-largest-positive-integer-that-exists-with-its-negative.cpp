class Solution {
public:
    int findMaxK(vector<int>& nums) {
        map<int,int>m;
        for(auto v:nums){
            m[v]++;
        }
        int answer=-1;
        for(auto v:nums){
            if(m[-v]){
                answer=max(answer,abs(v));
            }
        }
        return answer;
    }
};