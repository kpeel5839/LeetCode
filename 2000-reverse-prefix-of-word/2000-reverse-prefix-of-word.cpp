class Solution {
public:
    string reversePrefix(string word, char ch) {
        string s=word;
        int l=0;
        int r=0;
        for(int i=0;i<s.size();i++){
            if(s[i]==ch){
                r=i;
                break;
            }
        }
        while(l<r){
            char c=s[l];
            s[l++]=s[r];
            s[r--]=c;
        }
        return s;
    }
};