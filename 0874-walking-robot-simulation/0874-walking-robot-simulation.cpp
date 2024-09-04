class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    vi dy={1,0,-1,0};
    vi dx={0,1,0,-1};
    int robotSim(vector<int>& commands, vector<vector<int>>& o) {
        int dir=0;
        int y=0;
        int x=0;
        map<int,set<int>>m;
        int answer=0;
        for(int i=0;i<o.size();i++){
            m[o[i][0]].insert(o[i][1]);
        }
        for(int i=0;i<commands.size();i++){
            if(commands[i]==-1){
                dir=(dir+1)%4;
            }
            if(commands[i]==-2){
                dir=(dir+4-1)%4;
            }
            if(1<=commands[i]){
                for(int j=0;j<commands[i];j++){
                    int ny=y+dy[dir];
                    int nx=x+dx[dir];
                    if(m[nx].find(ny)!=m[nx].end()){
                        break;
                    }
                    y=ny;
                    x=nx;
                }
            }
            answer=max(answer,y*y+x*x);
        }
        return answer;
    }
};