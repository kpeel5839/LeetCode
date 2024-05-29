class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int n=s.size();
        vector<int> diff;
        for(int i=0;i<n;i++){
            diff.push_back(abs((int)s[i]-t[i]));
        }
        int l=0;
        int sum=0;
        int answer=0;
        for(int r=0;r<n;r++){
            sum+=diff[r];
            while(l<r&&maxCost<sum){
                sum-=diff[l++];
            }
            if(sum<=maxCost){
                answer=max(answer,r-l+1);
            }
        }
        return answer;
    }
};