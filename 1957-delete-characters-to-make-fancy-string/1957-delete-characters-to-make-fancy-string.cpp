class Solution {
public:
    string makeFancyString(string s) {
        string answer="";
        int n=s.size();
        char c=s[0];
        int cnt=1;
        for(int i=1;i<n;i++){
            if(c!=s[i]){
                
                for(int j=0;j<min(2,cnt);j++){
                    answer.push_back(c);
                }
                c=s[i];
                cnt=1;
                continue;
            }
            cnt++;
        }
        for(int i=0;i<min(2,cnt);i++){
            answer.push_back(c);
        }
        return answer;
    }
};