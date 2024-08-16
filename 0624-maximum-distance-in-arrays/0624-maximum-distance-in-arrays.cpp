class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int maxDistance(vector<vector<int>>& arrays) {
        int n=arrays.size();
        int ma=arrays.back().back();
        int answer=0;
        for(int i=n-2;0<=i;i--){
            answer=max(answer,abs(ma-arrays[i][0]));
            ma=max(ma,arrays[i].back());
        }
        int mi=arrays.back()[0];
        for(int i=n-2;0<=i;i--){
            answer=max(answer,abs(mi-arrays[i].back()));
            mi=min(mi,arrays[i][0]);
        }
        return answer;
    }
};