class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        vector<pair<string,int>>v;
        int n=names.size();
        for(int i=0;i<n;i++){
            v.push_back({names[i],heights[i]});
        }
        sort(v.begin(),v.end(),[](pair<string,int>&o1,pair<string,int>&o2){
            return o1.second>o2.second;
        });
        vector<string>answer;
        for(int i=0;i<n;i++){
            answer.push_back(v[i].first);
        }
        return answer;
    }
};