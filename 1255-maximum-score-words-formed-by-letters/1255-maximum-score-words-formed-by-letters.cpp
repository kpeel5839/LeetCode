class Solution {
public:
    vector<string>words;
    map<char,int>sco;
    map<char,int>cnt;
    map<char,int>letterCnt;
    int answer=0;
    void good(int score){
        for(auto v:cnt){
            if(letterCnt[v.first]<v.second){
                return;
            }
        }
        answer=max(answer,score);
    }
    void dfs(int idx,int score){
        good(score);
        for(int i=idx+1;i<words.size();i++){
            for(auto v:words[i]){
                score+=sco[v];
                cnt[v]++;
            }
            cout<<score<<"\n";
            dfs(i,score);
            for(auto v:words[i]){
                score-=sco[v];
                cnt[v]--;
            }
        }
    }
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        this->words=words;
        for(int i=0;i<26;i++){
            sco[(i+'a')]=score[i];
        }
        for(int i=0;i<letters.size();i++){
            letterCnt[letters[i]]++;
        }
        dfs(-1,0);
        return answer;
    }
};