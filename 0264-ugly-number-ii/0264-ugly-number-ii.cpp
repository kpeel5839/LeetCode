class Solution {
public:
    typedef long long ll;
    int nthUglyNumber(int n) {
        set<ll>s;
        vector<ll>list(1,1);
        vector<ll>mul={2,3,4,5};
        int index=0;
        while(list.size()<n*2){
            for(int i=0;i<mul.size();i++){
                ll value=list[index]*mul[i];
                if(s.find(value)!=s.end()){
                    continue;
                }
                list.push_back(value);
                s.insert(value);
            }
            index++;
        }
        sort(list.begin(),list.end());
        return list[n-1];
    }
};