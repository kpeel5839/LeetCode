class Solution {
public:
    typedef vector<string>vs;
    bool isCircularSentence(string s) {
        string word="";
        int n=s.size();
        vs words;
        for(int i=0;i<n;i++){
            if(s[i]==' '){
                words.push_back(word);
                word="";
                continue;
            }
            word.push_back(s[i]);
        }
        words.push_back(word);
        for(int i=0;i<words.size();i++){
            int nextIdx=(i+1)%((int)words.size());
            if(words[i].back()!=words[nextIdx][0]){
                return false;
            }
        }
        return true;
    }
};