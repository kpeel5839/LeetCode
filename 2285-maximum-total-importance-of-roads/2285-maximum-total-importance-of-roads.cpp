class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        vector<long long>v(n,0);
        for(int i=0;i<roads.size();i++){
            v[roads[i][0]]++;
            v[roads[i][1]]++;
        }
        sort(v.begin(),v.end());
        long long answer=0;
        for(int i=n-1;0<=i;i--){
            answer+=(i+1)*v[i];
        }
        return answer;
    }
};