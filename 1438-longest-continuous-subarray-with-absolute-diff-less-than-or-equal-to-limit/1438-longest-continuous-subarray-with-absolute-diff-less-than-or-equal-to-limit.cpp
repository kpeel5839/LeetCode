class Solution {
public:
    struct maComp{
        bool operator()(int o1,int o2){
            return o1<o2;
        }
    };
    struct miComp{
        bool operator()(int o1,int o2){
            return o1>o2;
        }
    };
    int longestSubarray(vector<int>& nums, int limit) {
        int l=0;
        int n=nums.size();
        priority_queue<int,vector<int>,maComp>ma;
        priority_queue<int,vector<int>,miComp>mi;
        map<int,int>cnt;
        int answer=0;
        for(int r=0;r<n;r++){
            ma.push(nums[r]);
            mi.push(nums[r]);
            cnt[nums[r]]++;
            while(ma.size()!=0&&mi.size()!=0&&l<=r&&ma.top()-mi.top()>limit){
                if(cnt[ma.top()]==0){
                    ma.pop();
                    continue;
                }
                if(cnt[mi.top()]==0){
                    mi.pop();
                    continue;
                }
                cnt[nums[l]]--;
                l++;
            }
            answer=max(answer,(r-l+1));
        }
        return answer;
    }
};