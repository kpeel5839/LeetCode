class Solution {
public:
    typedef vector<int>vi;
    bool helper(vi p,int m,int ball){
        int n=p.size();
        int pre=p[0];
        ball--;
        for(int i=1;i<n;i++){
            if(ball==0){
                break;
            }
            if(p[i]-pre>=m){
                pre=p[i];
                ball--;
            }
        }
        return ball==0;
    }
    int maxDistance(vector<int>& position, int m) {
        sort(position.begin(),position.end());
        int l=1;
        int r=1e9;
        int answer=-1;
        while(l<=r){
            int mid=(l+r)/2;
            cout<<mid<<"\n";
            if(helper(position,mid,m)){
                l=mid+1;
                answer=mid;
            }else{
                r=mid-1;
            }
        }
        return answer;
    }
};