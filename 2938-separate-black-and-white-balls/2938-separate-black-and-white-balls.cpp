class Solution {
public:

    typedef long long ll;
    typedef vector<ll> vl;
    typedef vector<vl> vll;

    long long minimumSteps(string s) {
        int answer=0;
        int n=s.size();
        int goal=n-1;
        for(int i=n-1;0<=i;i--){
            if(s[i]=='1'){
                answer+=(goal-i);
                goal--;
            }
        }
        return answer;
    }
};