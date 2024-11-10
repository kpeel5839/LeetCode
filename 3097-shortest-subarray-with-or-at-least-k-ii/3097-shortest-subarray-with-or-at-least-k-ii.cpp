class Solution {
public:
    typedef long long ll;
    ll k;
    vector<int>v=vector<int>(30,0);
    bool isGood(){
        ll index=0;
        ll result=0;
        for(int i=0;i<v.size();i++){
            if(v[i]==0){
                continue;
            }
            result|=(1<<i);
        }
        return result>=k;
    }
    int minimumSubarrayLength(vector<int>& nums, int k) {
        this->k=k;
        int l=0;
        int answer=1e9;
        for(int r=0;r<nums.size();r++){
            int num=nums[r];
            int index=0;
            while(num!=0){
                v[index]+=(num%2);
                num/=2;
                index++;
            }
            while(l!=nums.size()&&isGood()){
                answer=min(answer,(r-l)+1);
                int ll=nums[l];
                index=0;
                while(ll!=0){
                    v[index]-=(ll%2);
                    ll/=2;
                    index++;
                }
                l++;
            }
        }
        return answer==1e9?-1:max(1,answer);
    }
};