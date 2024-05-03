class Solution {
public:
    vector<string> get(string s){
        vector<string>s1;
        string inputString="";
        for(int i=0;i<s.size();i++){
            if(s[i]=='.'){
                if(inputString.size()==0){
                    s1.push_back("0");
                }else{
                    s1.push_back(inputString);
                }
                inputString="";
                continue;
            }
            if(inputString.size()==0&&s[i]=='0'){
                continue;
            }
            inputString.push_back(s[i]);
        }
        if(inputString.size()==0){
            s1.push_back("0");
        }else{
            s1.push_back(inputString);
        }
        return s1;
    }
    int compare(string s1,string s2){
        if(s1.size()<s2.size()){
            return -1;
        }
        if(s1.size()>s2.size()){
            return 1;
        }
        for(int i=0;i<s1.size();i++){
            int a=s1[i]-'0';
            int b=s2[i]-'0';
            if(a==b){
                continue;
            }
            return a<b?-1:1;
        }
        return 0;
    }
    int compareVersion(string version1, string version2) {
        vector<string>s1=get(version1);
        vector<string>s2=get(version2);
        if(s1.size()<s2.size()){
            int size1=s1.size();
            int size2=s2.size();
            for(int i=0;i<size2-size1;i++){
                s1.push_back("0");
            }
        }
        if(s2.size()<s1.size()){
            int size1=s1.size();
            int size2=s2.size();
            for(int i=0;i<size1-size2;i++){
                s2.push_back("0"); 
            }
        }
        for(int i=0;i<s1.size();i++){
            int result=compare(s1[i],s2[i]);
            if(result!=0){
                return result;
            }
        }
        return 0;
    }
};