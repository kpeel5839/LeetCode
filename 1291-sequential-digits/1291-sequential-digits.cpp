class Solution {
  typedef long long ll;
  typedef vector<ll> vl;
  typedef vector<int> vi;
public:
    vector<int> sequentialDigits(int low, int high) {
      vi answer;
      
      for (int i = 1; i <= 9; i++) {
        ll number = 0;
        for (int j = i; j <= 9; j++) {
          number *= 10;
          number += j;
          if (low <= number && number <= high) {
            answer.push_back(number);
          }
        }
      }
      
      sort(answer.begin(), answer.end());
      return answer;
    }
};