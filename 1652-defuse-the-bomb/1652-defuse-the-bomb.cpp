class Solution {
public:
    int n;
    vector<int>code;
    int k;
    int calculate(int idx,int dir){
        int cnt=k;
        int sum=0;
        while(cnt!=0){
            idx=(idx+dir+n)%n;
            sum+=code[idx];
            cnt>0?cnt--:cnt++;
        }
        return sum;
    }
    vector<int> decrypt(vector<int>& code, int k) {
        this->n=code.size();
        this->code=code;
        this->k=k;
        vector<int>answer(n,0);
        if(k==0){
            return answer;
        }
        for(int i=0;i<n;i++){
            answer[i]=calculate(i,k>0?1:-1);
        }
        return answer;
    }
};