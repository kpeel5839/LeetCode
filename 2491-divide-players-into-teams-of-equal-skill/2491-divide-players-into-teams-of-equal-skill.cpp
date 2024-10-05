class Solution {
public:

    typedef long long ll;
    typedef vector<ll> vl;
    typedef vector<vl> vll;

    long long dividePlayers(vector<int>& skill) {
        ll sum=0;
        unordered_map<ll,ll>m;
        for(auto&v:skill){
            sum+=v;
            m[v]++;
        }
        int div=(int)skill.size()/2;
        if(sum%div!=0){
            return -1;
        }
        int purpose=sum/div;
        ll answer=0;
        int count=0;
        for(int i=0;i<skill.size();i++){
            int a=skill[i];
            if(m[a]==0){
                continue;
            }
            count++;
            int b=purpose-a;
            m[a]--;
            m[b]--;
            if(m[a]<0||m[b]<0){
                return -1;
            }
            answer+=a*b;
        }
        if(count!=div){
            return -1
        }
        return answer;
    }

};