class Solution {
public:
    map<string,int>m;
    vector<string>answer;
    string s;
    void dfs(int idx,vector<string>ss){
        if(idx+1==s.size()){
            string a;
            for(auto&v:ss){
                a.append(v);
                a.push_back(' ');
            }
            a.pop_back();
            answer.push_back(a);
            return;
        }
        for(int i=idx+1;i<s.size();i++){
            string sss=s.substr(idx+1,i-(idx+1)+1);
            if(m[sss]){
                ss.push_back(sss);
                dfs(i,ss);
                ss.pop_back();
            }
        }
    }
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        this->s=s;
        for(auto&v:wordDict)m[v]=1;
        dfs(-1,{});
        return answer;
    }
};