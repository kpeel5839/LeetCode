class Solution {
public:
    typedef long long ll;
    long long minEnd(int n, int x) {
        ll index=-1;
        n--;
        ll result=x;
        while(n!=0){
            index++;
            if(((1ll<<index)&x)!=0){
                continue;
            }
            result|=((ll)(n%2)<<index);
            n/=2;
        }
        return result;
    }
};