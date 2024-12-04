class Solution {
public:
    bool canMakeSubsequence(string str1, string str2) {
        int idx=0;
        for(int i=0;i<str1.size();i++){
            int a=str2[idx]-'a';
            int b=str1[i]-'a';
            if(a==b||a==(b+1)%26){
                idx++;
            }
            if(idx==str2.size()){
                return true;
            }
        }
        return false;
    }
};