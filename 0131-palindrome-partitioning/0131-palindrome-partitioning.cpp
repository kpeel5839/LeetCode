class Solution {
public:
    vector<vector<string>>answer;
    bool is(string s){
        int n=s.size();
        for(int i=0;i<s.size();i++){
            if(s[i]!=s[n-i-1]){
                return false;
            }
        }
        return true;
    }
    void dfs(string& s,int idx,vector<string>a){
        if(idx+1==s.size()){
            for(string ss:a){
                if(!is(ss)){
                    return;
                }
            }
            answer.push_back(a);
            return;
        }
        for(int i=idx+1;i<s.size();i++){
            string ss=s.substr(idx+1,i-idx);
            a.push_back(ss);
            dfs(s,i,a);
            a.pop_back();
        }
    }
    vector<vector<string>> partition(string s) {
        dfs(s,-1,{});
        return answer;
    }
};