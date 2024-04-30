class Solution {
public:
    typedef long long ll;
    typedef vector<ll>vl;
    typedef vector<vl>vll;
    long long wonderfulSubstrings(string word) {
        vl cnt(1024,0);
        int bit=0;
        ll result=0;
        cnt[0]=1;
        for(int i=0;i<word.size();i++){
            int idx=word[i]-'a';
            bit^=(1<<idx);
            result+=cnt[bit];
            for(int j=0;j<10;j++){
                result+=cnt[bit^(1<<j)];
            }
            cnt[bit]++;
        }
        return result;
    }
};