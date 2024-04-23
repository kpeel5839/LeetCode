class Solution {
public:
  typedef long long ll;
  typedef vector<ll>vl;
  typedef vector<int>vi;
  typedef vector<vl>vll;
  vi c;
  int n;
  long long gcd(long long  a, long long b){
    long long c;
    while (b != 0){
      c = a % b;
      a = b;
      b = c;
    }
    return a;
  }
  long long lcm(long long a, long long b){
    return a*b/gcd(a,b);
  }
  ll getCnt(ll m){
    ll result=0;
    int nn=1<<n;
    for(int i=1;i<nn;i++){
      ll lcmm=1;
      for(int j=0;j<n;j++){
        if((i&(1<<j))!=0){
          lcmm=lcm(lcmm,c[j]);
        }
      }
      if(__builtin_popcount(i)&1!=0){
        result+=m/lcmm;
      }else{
        result-=m/lcmm;
      }
    }
    return result;
  }
  long long findKthSmallest(vector<int>& coins, int k) {
    n=coins.size();
    c=coins;
    sort(c.begin(),c.end());
    ll l=1;
    ll r=5e10;
    ll ans=-1;
    while(l<=r){
      ll m=(l+r)/2;
      ll result=getCnt(m);
      if(result<k){
        l=m+1;
      }else{
        r=m-1;
        ans=m;
      }
    }
    return ans;
  }
};