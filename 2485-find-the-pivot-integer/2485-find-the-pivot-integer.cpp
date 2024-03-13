class Solution {
public:
  int pivotInteger(int n) {
    for(int i=1;i<=n;i++){
      int lower=((1+i)*i)/2;
      int upper=((i+n)*(n-i+1))/2;
      if(lower==upper){
        return i;
      }
    }
    return -1;
  }
};