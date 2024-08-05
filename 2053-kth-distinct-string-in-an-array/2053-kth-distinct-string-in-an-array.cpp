class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        map<string,int>m;
        int n=arr.size();
        for(int i=0;i<n;i++){
            m[arr[i]]++;
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(m[arr[i]]==1){
                cnt++;
                if(cnt==k){
                    return arr[i];
                }
            }
        }
        return "";
    }
};