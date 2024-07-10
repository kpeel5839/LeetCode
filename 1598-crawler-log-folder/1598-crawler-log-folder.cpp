class Solution {
public:
    int dfs(int index,int depth,vector<string>& logs){
        if(index==logs.size()){
            return depth;
        }
        if(logs[index]=="../"){
            return dfs(index+1,max(0,depth-1),logs);
        }else if(logs[index]!="./"){
            return dfs(index+1,depth+1,logs);
        }
        return dfs(index+1,depth,logs);
    }
    int minOperations(vector<string>& logs) {
        return dfs(0,0,logs);
    }
};