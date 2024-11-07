class Solution {
public:
    int largestCombination(vector<int>& c) {
        map<int,int>m;
        for(int i=0;i<c.size();i++){
            int a=c[i];
            int index=0;
            while(true){
                if(a%2==1){
                    m[index]++;
                }
                index++;
                a/=2;
                if(a==0){
                    break;
                }
            }
        }
        int answer=0;
        for(auto&v:m){
            answer=max(answer,v.second);
        }
        return answer;
    }
};