class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    int H;
    int W;
    vii grid;
    bool isGood(int h,int w){
        set<int>s;
        set<int>sums;
        sums.insert(grid[h][w]+grid[h+1][w+1]+grid[h+2][w+2]);
        sums.insert(grid[h][w+2]+grid[h+1][w+1]+grid[h+2][w]);
        vi rows(3,0);
        vi cols(3,0);
        for(int i=h;i<h+3;i++){
            for(int j=w;j<w+3;j++){
                if(0==grid[i][j]||10<=grid[i][j]||s.find(grid[i][j])!=s.end()){
                    return false;
                }
                s.insert(grid[i][j]);
                rows[i-h]+=grid[i][j];
                cols[j-w]+=grid[i][j];
            }
        }
        for(int i=0;i<3;i++){
            sums.insert(rows[i]);
            sums.insert(cols[i]);
        }
        return sums.size()==1;
    }
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int answer=0;
        H=grid.size();
        W=grid[0].size();
        this->grid=grid;
        for(int i=0;i<H-2;i++){
            for(int j=0;j<W-2;j++){
                answer+=isGood(i,j)?1:0;
            }
        }
        return answer;
    }
};