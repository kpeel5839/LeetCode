class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    char findKthBit(int n, int k) {
        vi v(pow(2,n));
        for(int i=2;i<=n;i++){
            int size=pow(2,i-1)-1;
            int pivot=pow(2,i-1);
            v[pivot]=1;
            for(int j=1;j<=size;j++){
                v[pivot+size-(j-1)]=(v[j]+1)%2;
            }
        }
        return v[k]+'0';
    }
};