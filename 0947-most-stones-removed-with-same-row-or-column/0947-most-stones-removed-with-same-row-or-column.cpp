class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    vi parent;
    int n;
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    void join(int a,int b){
        parent[b]=a;
    }
    int removeStones(vector<vector<int>>& stones) {
        n=stones.size();
        parent=vi(n);
        for(int i=0;i<parent.size();i++){
            parent[i]=i;
        }
        for(int i=0;i<stones.size();i++){
            for(int j=i+1;j<stones.size();j++){
                if(stones[i][0]==stones[j][0]){
                    join(find(i),find(j));
                }
                if(stones[i][1]==stones[j][1]){
                    join(find(i),find(j));
                }
            }
        }
        set<int>answer;
        for(int i=0;i<stones.size();i++){
            answer.insert(find(i));
        }
        return n-(int)answer.size();
    }
};