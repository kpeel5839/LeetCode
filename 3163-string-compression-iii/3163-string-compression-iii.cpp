class Solution {
public:
    string compressedString(string word) {
        string answer="";
        int n=word.size();
        char c=word[0];
        int cnt=1;
        for(int i=1;i<n;i++){
            if(cnt==9||c!=word[i]){
                answer.push_back(cnt+'0');
                answer.push_back(c);
                c=word[i];
                cnt=1;
                continue;
            }
            cnt++;
        }
        answer.push_back(cnt+'0');
        answer.push_back(c);
        return answer;
    }
};