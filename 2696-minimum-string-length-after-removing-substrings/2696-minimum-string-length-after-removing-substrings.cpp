class Solution {
public:
    typedef vector<char>vc;
    typedef vector<int>vi;
    int minLength(string s) {
        vc c;
        for(auto&v:s){
            c.push_back(v);
        }
        while(true){
            bool good=false;
            int eraseIndex=0;
            for(int i=1;i<c.size();i++){
                if((c[i]=='B'&&c[i-1]=='A')||(c[i]=='D'&&c[i-1]=='C')){
                    good=true;
                    eraseIndex=i-1;
                    break;
                }
            }
            if(!good){
                break;
            }
            c.erase(c.begin()+eraseIndex);
            c.erase(c.begin()+eraseIndex);
        }
        return c.size();
    }
};