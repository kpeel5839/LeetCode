class Solution {
public:
  int h;
  int w;
  vector<vector<char>>board;
  string word;
  vector<vector<bool>>visited;
  vector<int> dx={0,1,0,-1};
  vector<int> dy={-1,0,1,0};
  bool isOutOfRange(int y,int x){
    return y<0||y>=h||x<0||x>=w;
  }
  bool dfs(int y,int x,int idx){
    if(idx==word.size()){
      return true;
    }
    for(int i=0;i<4;i++){
      int ny=y+dy[i];
      int nx=x+dx[i];
      if(isOutOfRange(ny,nx)||visited[ny][nx]||word.at(idx)!=board[ny][nx]){
        continue;
      }
      visited[ny][nx]=true;
      if(dfs(ny,nx,idx+1)){
        return true;
      }
      visited[ny][nx]=false;
    }
    return false;
  }
  bool exist(vector<vector<char>>& board, string word) {
    h=board.size();
    w=board[0].size();
    this->board=board;
    this->word=word;
    visited=vector<vector<bool>>(h,vector<bool>(w));
    for(int i=0;i<h;i++){
      for(int j=0;j<w;j++){
        visited[i][j]=true;
        if(word.at(0)==board[i][j]&&dfs(i,j,1)){
          return true;
        }
        visited[i][j]=false;
      }
    }
    return false;
  }
};