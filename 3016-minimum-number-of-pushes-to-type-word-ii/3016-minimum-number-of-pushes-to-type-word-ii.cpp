class Solution {
public:
    int minimumPushes(string word) {
        vector<int>v(26,0);
        int cnt=0;
        int add=1;
        for(int i=0;i<word.size();i++){
            v[(int)(word[i]-'a')]++;
        }
        int answer=0;
        sort(v.begin(),v.end());
        for(int i=(int)(v.size()-1);0<=i;i--){
            if(v[i]!=0){
                answer+=add*v[i];
                cnt++;
            }
            if(cnt==8){
                cnt=0;
                add++;
            }
        }
        return answer;
    }
};