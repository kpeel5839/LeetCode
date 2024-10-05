class Solution {
public:
    bool isGood(map<char,int>&m1,map<char,int>&m2){
        for(auto v:m1){
            if(m2[v.first]!=v.second){
                return false;
            }
        }
        return true;
    }
    bool checkInclusion(string s1, string s2) {
        if(s1.size()>s2.size()){
            return false;
        }
        map<char,int>m1;
        map<char,int>m2;
        int n1=s1.size();
        int n2=s2.size();
        for(int i=0;i<n1;i++){
            m1[s1[i]]++;
        }
        for(int i=0;i<n1;i++){
            m2[s2[i]]++;
        }
        if(isGood(m1,m2)){
            return true;
        }
        for(int i=0;i+n1<n2;i++){
            m2[s2[i]]--;
            m2[s2[i+n1]]++;
            if(isGood(m1,m2)){
                return true;
            }
        }
        return false;
    }
};