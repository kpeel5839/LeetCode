class Solution {
public:
    int longestPalindrome(string s) {
        map<char,int>m;
        int n=s.size();
        int oddMax=0;
        for(int i=0;i<n;i++){
            m[s[i]]++;
        }
        int answer=0;
        bool oddExist=false;
        for(auto&v:m){
            if(v.second%2==0){
                answer+=v.second;
            }else{
                answer+=v.second-1;
                oddExist=true;
            }
        }
        return answer+(oddExist?1:0);
    }
};