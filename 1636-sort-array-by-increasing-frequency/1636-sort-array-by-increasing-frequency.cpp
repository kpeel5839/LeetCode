class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        map<int,int>m;
        for(int i=0;i<nums.size();i++){
            m[nums[i]]++;
        }
        vector<vector<int>>v;
        for(auto&vv:m){
            v.push_back({vv.first,vv.second});
        }
        sort(v.begin(),v.end(),[](vector<int>&o1,vector<int>&o2){
            if(o1[1]==o2[1]){
                return o1[0]>o2[0];
            }
            return o1[1]<o2[1];
        });
        vector<int>answer;
        for(int i=0;i<v.size();i++){
            for(int j=0;j<v[i][1];j++){
                answer.push_back(v[i][0]); 
            }
        }
        return answer;
    }
};