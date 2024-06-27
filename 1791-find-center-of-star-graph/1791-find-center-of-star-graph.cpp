class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        map<int,int>m;
        int n=edges.size();
        for(int i=0;i<n;i++){
            if(++m[edges[i][0]]==n){
                return edges[i][0];
            }
            if(++m[edges[i][1]]==n){
                return edges[i][1];
            }
        }
        return -1;
    }
};