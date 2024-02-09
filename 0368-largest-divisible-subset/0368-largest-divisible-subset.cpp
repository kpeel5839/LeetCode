class Solution {
public:
  vector<int> largestDivisibleSubset(vector<int>& nums) {
    int n = nums.size();
    sort(nums.begin(), nums.end());
    vector<int> dp(n, 0);
    int answerSize = 0;

    for (int i = 0; i < n; i++) {
      int maxValue = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          maxValue = max(maxValue, dp[j]);
        }
      }
      dp[i] = maxValue + 1;
      answerSize = max(answerSize, dp[i]);
    }

    vector<int> answer;
    int pre = -1;
    for (int i = n - 1; 0 <= i; i--) {
      if (answerSize == dp[i] && (pre == -1 || pre % nums[i] == 0)) {
        pre = nums[i];
        answer.push_back(nums[i]);
        answerSize--;
      }
    }
    sort(answer.begin(), answer.end());
    return answer;
  }
};