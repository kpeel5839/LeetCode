class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        vector<string>s;
        istringstream iss(sentence);
        string token;
        while(iss>>token){
            s.push_back(token);
        }
        unordered_set<string>se;
        for(int i=0;i<dictionary.size();i++){
            se.insert(dictionary[i]);
        }
        vector<string>answerTokens;
        for(int i=0;i<s.size();i++){
            string a;
            bool good=false;
            for(int j=0;j<s[i].size();j++){
                a.push_back(s[i][j]);
                if(se.find(a)!=se.end()){
                    break;
                }
            }
            answerTokens.push_back(a);
        }
        string answer;
        for(int i=0;i<answerTokens.size();i++){
            if(answerTokens.size()==i+1){
                answer.append(answerTokens[i]);
            }else{
                answer.append(answerTokens[i]);
                answer.push_back(' ');
            }
        }
        return answer;
    }
};