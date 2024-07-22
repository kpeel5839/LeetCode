class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<vii>viii;
    
    vi getSort(int k,vii&conditions){
        queue<int>q;
        int n=conditions.size();
        vi entry(k+1,0);
        vi result;
        for(int i=0;i<n;i++){
            entry[conditions[i][1]]++;
        }
        for(int i=1;i<=k;i++){
            if(entry[i]==0){
                q.push(i);
            }
        }
        while(q.size()!=0){
            int a=q.front();q.pop();
            result.push_back(a);
            for(int i=0;i<n;i++){
                if(conditions[i][0]==a){
                    if(--entry[conditions[i][1]]==0){
                        q.push(conditions[i][1]);
                    }
                }
            }
        }
        for(int i=1;i<=k;i++){
            if(entry[i]!=0){
                return {-1};
            }
        }
        return result;
    }
    
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions, vector<vector<int>>& colConditions) {
        vi rowResult=getSort(k,rowConditions);
        vi colResult=getSort(k,colConditions);
        if(rowResult[0]==-1||colResult[0]==-1){
            return {};
        }
        vii result(k,vi(k,0));
        for(int i=0;i<rowResult.size();i++){
            for(int j=0;j<colResult.size();j++){
                if(rowResult[i]==colResult[j]){
                    result[i][j]=rowResult[i];
                    break;
                }
            }
        }
        return result;
    }
};