class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        int n=words.size();
        vector<string>answer;
        for(int i=0;i<26;i++){
            char c=i+'a';
            string s=string(1,c);
            int mi=1e9;
            for(int j=0;j<n;j++){
                int cnt=0;
                for(char cc:words[j]){
                    cnt+=(c==cc?1:0);
                }
                mi=min(mi,cnt);
            }
            for(int j=0;j<mi;j++){
                answer.push_back(s);
            }
        }
        return answer;
    }
};