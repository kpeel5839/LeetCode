class Solution {
public:
    int appendCharacters(string s, string t) {
        int n=s.size();
        int m=t.size();
        int pointer=0;
        for(int i=0;i<n;i++){
            if(s[i]==t[pointer]){
                pointer++;
            }
        }
        return m-pointer;
    }
};