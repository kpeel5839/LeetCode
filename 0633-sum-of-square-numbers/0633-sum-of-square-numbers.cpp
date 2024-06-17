class Solution {
public:
    typedef long long ll;
    bool judgeSquareSum(int c) {
        // for(int i=2;i*i<=c;i++){
        //     if(c%i==0){
        //         int cnt=0;
        //         while(c%i==0){
        //             cnt++;
        //             c/=i;
        //         }
        //         if(i%4==3&&cnt%2!=0){
        //             return false;
        //         }
        //     }
        // } // 4k+3 형태의 소인수가 짝수개 있으면 끝나는 것
        // return c%4!=3; // 이미 짝수개 다 맞춰놨는데 c%4==3 추가되면 홀 수 되니까 false
        if(c==0){
            return true;
        }
        unordered_set<ll>s;
        for(ll i=0;i*i<=c;i++){
            s.insert(i*i);
        }
        for(ll i=1;i*i<=c;i++){
            ll diff=c-i*i;
            if(s.find(diff)!=s.end()){
                return true;
            }
        }
        return false;
    }
};