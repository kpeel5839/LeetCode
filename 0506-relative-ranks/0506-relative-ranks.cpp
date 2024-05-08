class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        int n=score.size();
        vector<vector<int>>v;
        for(int i=0;i<n;i++){
            v.push_back({score[i],i});
        }
        sort(v.begin(),v.end(),[](vector<int>o1,vector<int>o2){
            return o1[0]>o2[0];
        });
        vector<string>answer(n);
        for(int i=0;i<n;i++){
            if(i==0){
                answer[v[i][1]]="Gold Medal";
            }else if(i==1){
                answer[v[i][1]]="Silver Medal";
            }else if(i==2){
                answer[v[i][1]]="Bronze Medal";
            }else{
                answer[v[i][1]]=to_string(i+1);
            }
        }
        return answer;
    }
};