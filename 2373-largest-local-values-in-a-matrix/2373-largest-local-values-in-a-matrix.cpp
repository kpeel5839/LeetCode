class Solution {
public:
    typedef vector<int> vi;
    typedef vector<vi> vii;
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        int h=grid.size();
        int w=grid[0].size();
        vii answer(h-2,vi(w-2,0));
        for(int i=0;i<h-2;i++){
            for(int j=0;j<w-2;j++){
                for(int y=i;y<i+3;y++){
                    for(int x=j;x<j+3;x++){
                        answer[i][j]=max(answer[i][j],grid[y][x]);
                    }
                }
            }
        }
        return answer;
    }
};