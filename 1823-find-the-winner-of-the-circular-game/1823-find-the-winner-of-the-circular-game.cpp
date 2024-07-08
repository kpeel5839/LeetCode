class Solution {
public:
    int findTheWinner(int n, int k) {
        vector<int>v;
        for(int i=1;i<=n;i++){
            v.push_back(i);
        }
        int idx=0;
        for(int i=0;i<n-1;i++){
            idx=(idx+(k-1))%(n-i);
            v.erase(v.begin()+idx);
            idx%=(n-i);
        }
        return v[0];
    }
};