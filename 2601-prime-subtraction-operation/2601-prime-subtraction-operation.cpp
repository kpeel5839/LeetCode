class Solution {
public:
    vector<int> primes={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
    typedef vector<int>vi;
    typedef vector<vi>vii;
    vector<unordered_set<int>>records=vector<unordered_set<int>>(1001);
    vector<vector<int>>dp;
    vector<int>nums;
    int ma=0;
    int n;
    int dfs(int idx,int num){
        if(ma==idx-1||num==n){
            return num;
        }
        if(dp[idx][num]!=-1){
            return dp[idx][num];
        }
        dp[idx][num]=0;
        if(records[idx].find(num)!=records[idx].end()){
            dp[idx][num]=max(dp[idx][num],dfs(idx+1,num+1));
        }
        return dp[idx][num]=max(dp[idx][num],dfs(idx+1,num));
    }
    
    bool primeSubOperation(vector<int>& nums) {
        n=nums.size();
        this->nums=nums;
        this->dp=vector<vector<int>>(1001,vector<int>(n,-1));
        for(int i=0;i<nums.size();i++){
            records[nums[i]].insert(i);
            for(int j=0;j<primes.size();j++){
                if(primes[j]>=nums[i]){
                    continue;
                }
                records[nums[i]-primes[j]].insert(i);
            }
            ma=max(ma,nums[i]);
        }
        for(auto&v:records[2]){
            cout<<nums[v]<<" ";
        }
        dfs(0,0);
        for(int i=0;i<dp.size();i++){
            cout<<dp[i][0]<<"\n";
            if(dp[i][0]==n){
                return true;
            }
        }
        return false;
    }
};