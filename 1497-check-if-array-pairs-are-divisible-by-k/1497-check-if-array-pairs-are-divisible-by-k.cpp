class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        map<int,int>m;
        for(int i=0;i<arr.size();i++){
            arr[i]%=k;
            m[arr[i]]++;
        }
        for(int i=0;i<arr.size();i++){
            if(m[arr[i]]==0){
                continue;
            }
            int first=arr[i];
            int second=0;
            if(0<=first){
                if(m[-first]!=0){
                    second=-arr[i];
                    m[first]--;
                    m[second]--;
                }else{
                    second=(k-arr[i])%k;
                    m[first]--;
                    m[second]--;
                }
            }else{
                if(m[-first]!=0){
                    second=-arr[i];
                    m[first]--;
                    m[second]--;
                }else{
                    second=-((k+arr[i])%k);
                    m[first]--;
                    m[second]--;
                }
            }
            if(m[first]<0||m[second]<0){
                return false;
            }
        }
        return true;
    }
};