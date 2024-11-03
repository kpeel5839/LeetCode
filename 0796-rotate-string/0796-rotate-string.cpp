class Solution {
public:
    bool rotateString(string s, string goal) {
        if(s.size()!=goal.size()){
            return false;
        }
        int n=s.size();
        for(int i=0;i<n;i++){
            int searchIndex=i;
            bool good=true;
            for(int j=0;j<n;j++){
                if(s[j]!=goal[searchIndex]){
                    good=false;
                    break;
                }
                searchIndex=(searchIndex+1)%n;
            }
            if(good){
                return true;
            }
        }
        return false;
    }
};